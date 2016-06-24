package com.mshop.backend.database;

import com.mshop.backend.Util.UtilClass;
import com.mshop.backend.model.Category;
import com.mshop.backend.model.Consumer;
import com.mshop.backend.model.Order;
import com.mshop.backend.model.OrderLine;
import com.mshop.backend.model.Product;

import org.apache.commons.codec.binary.Base64;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DataBaseService {

    private static Connection conn = ConnectionManager.getInstance().getConnection();

    public static List<Product> getProducts(String category, String consumer, String density)  {

        List<Product> products = new ArrayList<>();
        PreparedStatement pst = null;
        String query = "select prods.* , i.bitmap_image from images i \n" +
                "\tjoin (select p.* from products p where p.category = ? and p.consumer = ?) As prods \n" +
                "    where i.product_name = prods.name and i.density = ?;";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1,category);
            pst.setString(2,consumer);
            pst.setString(3,density);

            ResultSet rs = pst.executeQuery();
            rs.last();
            if (rs.getRow() == 0) {
                return products;
            }else{
                rs.beforeFirst();
                while (rs.next()) {

                    Product product = new Product();
                    product.setName(rs.getString("name"));
                    product.setDescription(rs.getString("description"));
                    product.setCaracteristics(rs.getString("caracteristics"));
                    product.setPrice(rs.getDouble("price"));
                    product.setConsumer(Consumer.valueOf(rs.getString("consumer").toUpperCase()));
                    product.setCategory(Category.valueOf(rs.getString("category").toUpperCase()));
                    product.setPhoto(Base64.encodeBase64String(rs.getBytes("bitmap_image")));

                    products.add(product);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (pst!=null) try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return products;
    }

    public static boolean isUserValid(String username, String password){

        String query = "select count(*) number from users where username = ? and password = ?";

        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            rs.next();
            int userCount = rs.getInt("number");

            return (userCount > 0) ? true : false;

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (pst != null) try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean insertOrder(Order order) throws SQLException {

        String queryOrder = "INSERT into orders (date, price, state, id_client) VALUES (?, ?, ?, ?)";
        String queryLineOrder = "INSERT into orderlines (ligne_number, product_name, quantity, unit_price, id_order) VALUES (?, ?, ?, ?, ?)";
        ResultSet keys = null;

        try {
            PreparedStatement stmt = conn.prepareStatement(queryOrder, Statement.RETURN_GENERATED_KEYS);
            conn.setAutoCommit(false);

            java.util.Date date = UtilClass.parseDateString(order.getOrderDate());
            stmt.setDate(1, UtilClass.convertToSqlDate(date));
            stmt.setDouble(2, order.getPrice());
            stmt.setString(3, order.getState());
            stmt.setString(4, order.getIdClient());

            int affected = stmt.executeUpdate();

            if (affected == 1) {
                keys = stmt.getGeneratedKeys();
                keys.next();
                int newKey = keys.getInt(1);
                order.setId(newKey);
                int i = 1;
                for (OrderLine orderLine : order.getOrderLines()) {
                    stmt = conn.prepareStatement(queryLineOrder, Statement.RETURN_GENERATED_KEYS);

                    stmt.setInt(1, i);
                    stmt.setString(2, orderLine.getProductName());
                    stmt.setInt(3, orderLine.getQuantity());
                    stmt.setDouble(4, orderLine.getUnitPrice());
                    stmt.setInt(5, order.getId());

                    int orderLineAffected = stmt.executeUpdate();
                    if(orderLineAffected == 1){
                        i++;
                    }else{
                        System.err.println("No rows affected in orderLine Insertion");
                        conn.rollback();
                        return false;
                    }
                }

            } else {
                System.err.println("No rows affected in order Insertion");
                conn.rollback();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
            return false;
        }finally{
            if (keys != null) keys.close();
        }
        conn.commit();
        return true;
    }

    public static String getOrderState(int orderId){
        String query = "SELECT state from orders where id = ?";
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, orderId);

            ResultSet rs = pst.executeQuery();
            rs.last();
            if (rs.getRow() == 0) {
                System.out.println("no order with the specified id : " + orderId);
                return null;
            }else{
                rs.first();
                String state = rs.getString(1);
                return state;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (pst != null) try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

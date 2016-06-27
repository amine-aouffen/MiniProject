package com.mshop.backend.database;

import com.mshop.backend.Util.CartOperationRequest;
import com.mshop.backend.Util.CartOperationResponse;
import com.mshop.backend.Util.CartOperationTypes;
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

    private static Connection conn = null;

    public static List<Product> getProducts(String category, String consumer, String density) {
        conn = ConnectionManager.getInstance().getConnection();
        List<Product> products = new ArrayList<>();
        PreparedStatement pst = null;
        String query = "select prods.* , i.bitmap_image from images i \n" +
                "\tjoin (select p.* from products p where p.category = ? and p.consumer = ?) As prods \n" +
                "    where i.product_name = prods.name and i.density = ?;";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, category);
            pst.setString(2, consumer);
            pst.setString(3, density);

            ResultSet rs = pst.executeQuery();
            rs.last();
            if (rs.getRow() == 0) {
                return products;
            } else {
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectionManager.getInstance().close();
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return products;
    }

    public static Product getProductPhoto(String density, String product_name) {

        conn = ConnectionManager.getInstance().getConnection();
        Product product = new Product();
        PreparedStatement pst = null;

        String query = "SELECT bitmap_image FROM images where density = ? and product_name = ?;";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, density);
            pst.setString(2, product_name);

            ResultSet rs = pst.executeQuery();
            rs.last();
            if (rs.getRow() == 0) {
                return product;
            } else {
                rs.first();
                product.setPhoto(Base64.encodeBase64String(rs.getBytes("bitmap_image")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectionManager.getInstance().close();
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return product;
    }

    public static boolean isUserValid(String username, String password) {
        conn = ConnectionManager.getInstance().getConnection();
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

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectionManager.getInstance().close();
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean insertOrder(Order order) throws SQLException {
        conn = ConnectionManager.getInstance().getConnection();
        String queryOrder = "INSERT into orders (date, price, state, id_client) VALUES (?, ?, ?, ?)";
        String queryLineOrder = "INSERT into orderlines (ligne_number, product_name, quantity, unit_price, id_order) VALUES (?, ?, ?, ?, ?)";
        ResultSet keys = null;

        try {
            PreparedStatement stmt = conn.prepareStatement(queryOrder, Statement.RETURN_GENERATED_KEYS);
            conn.setAutoCommit(false);


            stmt.setDate(1, UtilClass.convertToSqlDate(order.getOrderDate()));
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
                    if (orderLineAffected == 1) {
                        i++;
                    } else {
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
        } finally {
            if (keys != null) keys.close();
        }
        conn.commit();
        ConnectionManager.getInstance().close();
        return true;
    }

    public static String getOrderState(int orderId) {
        conn = ConnectionManager.getInstance().getConnection();
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
            } else {
                rs.first();
                String state = rs.getString(1);
                return state;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectionManager.getInstance().close();
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static CartOperationResponse doCartCheckOperation(CartOperationRequest cartOperationRequest){
        conn = ConnectionManager.getInstance().getConnection();
        CartOperationResponse response = new CartOperationResponse();
        PreparedStatement pst = null;

        String queryCheck = "SELECT s.product_name, s.value, s.quantity FROM products p\n" +
                "\tjoin sizes s where p.name = s.product_name and p.name = ?;";
        try {
            pst = conn.prepareStatement(queryCheck);
            pst.setString(1, cartOperationRequest.getProductName());

            ResultSet rs = pst.executeQuery();
            rs.last();
            if (rs.getRow() == 0) {
                response.setCode(-1);
                response.setDescription("Product quantity check failed : product not found !");
                return response;
            } else {
                rs.beforeFirst();
                response.setType(CartOperationTypes.CHECK);
                response.setProductName(cartOperationRequest.getProductName());
                response.setCode(1);
                response.setDescription("Product quantity check successful");
                int i = 0;
                while (rs.next()) {
                    response.getSizes().add(i, rs.getString("value"));
                    response.getQuantities().add(i, rs.getInt("quantity"));

                    i++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pst != null) try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        ConnectionManager.getInstance().close();
        return response;
    }

    public static CartOperationResponse doCartMathOperation(CartOperationRequest cartOperationRequest){
        conn = ConnectionManager.getInstance().getConnection();
        CartOperationResponse response = new CartOperationResponse();
        PreparedStatement pst = null;

        String queryAdd = "UPDATE sizes SET quantity = quantity + ? \n" +
                "\twhere value = ? and product_name = ?;";


        try {
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(queryAdd, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, cartOperationRequest.getQuantity());
            pst.setString(2, cartOperationRequest.getSize());
            pst.setString(3, cartOperationRequest.getProductName());

            int affected = pst.executeUpdate();
            if (affected == 1) {
                response.setType(CartOperationTypes.MATH_OPERATION);
                response.setProductName(cartOperationRequest.getProductName());
                response.setCode(1);
                if(cartOperationRequest.getQuantity() > 0) {
                    response.setDescription("Product quantity addition successful");
                }
                else{
                    response.setDescription("Product quantity substraction successful");
                }

            } else {
                response.setCode(-1);
                if(cartOperationRequest.getQuantity() > 0) {
                    response.setDescription("Product quantity addition failed");
                }
                else{
                    response.setDescription("Product quantity substraction failed");
                }
                conn.rollback();
                return response;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectionManager.getInstance().close();
        return response;
    }

}

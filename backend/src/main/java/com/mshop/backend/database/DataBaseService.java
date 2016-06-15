package com.mshop.backend.database;

import com.mshop.backend.model.Category;
import com.mshop.backend.model.Consumer;
import com.mshop.backend.model.Product;

import org.apache.commons.codec.binary.Base64;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DataBaseService {

    private static Connection conn = ConnectionManager.getInstance().getConnection();

    public static List<Product> getProducts(String density, String category)  {

        List<Product> products = new ArrayList<>();
        PreparedStatement pst = null;
        String query = "select prods.* , i.bitmap_image from images i join (select p.* from products p where p.category = ?) As prods where i.product_name = prods.name and i.density = ?";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1,category);
            pst.setString(2,density);

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
        }
        try {
            if (pst!=null) pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}

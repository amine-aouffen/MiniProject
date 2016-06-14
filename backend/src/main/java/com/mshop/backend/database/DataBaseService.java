package com.mshop.backend.database;

import com.mshop.backend.model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 14/06/2016.
 */
public class DataBaseService {

    private static Connection conn = ConnectionManager.getInstance().getConnection();

    public List<Product> getProducts(String density, String category)  {

        List<Product> products = new ArrayList<>();
        PreparedStatement pst = null;
        String query = "select prods.* , i.* from images i join (select p.* from products p where p.category = ?) As prods where i.product_name = prods.name and i.density = ?";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1,category);
            pst.setString(2,density);

            ResultSet rs = pst.executeQuery();

            if (rs.getRow() == 0) {
                return products;
            }else{
                rs.beforeFirst();
                while (rs.next()) {

                    Product product = new Product();
                }
            }


        }catch (SQLException e) {
            e.printStackTrace();
        }


        return new ArrayList<>();
    }
}

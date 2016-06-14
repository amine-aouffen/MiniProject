package com.mshop.backend.database;

import com.mshop.backend.model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 14/06/2016.
 */
public class DataBaseService {

    public static final String CLASS_NAME = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    private static final String CONN_STRING = "jdbc:mysql://localhost/dbmobile?useSSL=false";

    public Connection connecter()   {

        Connection con = null;
        try {
            Class.forName(CLASS_NAME);
            con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public List<Product> getBooks(String density)  {
        return new ArrayList<>();
    }
}

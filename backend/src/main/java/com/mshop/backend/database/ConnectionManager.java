package com.mshop.backend.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Dell on 14/06/2016.
 */
public class ConnectionManager {

    private static ConnectionManager instance = null;

    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysql";
    private static final String CONN_STRING =
            "jdbc:mysql://localhost/dbmobile?useSSL=false";


    private Connection conn = null;

    private ConnectionManager() {
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }


    private boolean openConnection()
    {
        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            return true;
        }
        catch (SQLException e) {
            System.err.println(e);
            return false;
        }

    }

    public Connection getConnection()
    {
        if (conn == null) {
            if (openConnection()) {
                System.out.println("Connection opened");
                return conn;
            } else {
                return null;
            }
        }
        return conn;
    }

    public void close() {
        System.out.println("Closing connection");
        try {
            conn.close();
            conn = null;
        } catch (Exception e) {
        }
    }
}

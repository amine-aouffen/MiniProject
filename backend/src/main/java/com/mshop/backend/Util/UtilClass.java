package com.mshop.backend.Util;

import com.google.gson.Gson;
import com.mshop.backend.model.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Dell on 23/06/2016.
 */
public class UtilClass {

    public static StringBuilder readJsonFomBody(HttpServletRequest req) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = req.getReader();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } finally {
            reader.close();
        }
        return sb;
    }

    public static Date parseDateString (String dateString){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.FRENCH);
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static java.sql.Date convertToSqlDate(java.util.Date date){
        return new java.sql.Date(date.getTime());
    }

    public static void printResponse(HttpServletResponse resp, int code, String message) throws IOException {
        PrintWriter writer = resp.getWriter();
        GeneralResponse response = new GeneralResponse(code, message);
        writer.print(new Gson().toJson(response));
    }

    public static void printgetOrdersResponse(HttpServletResponse resp, int code, String message, List<Order> orders) throws IOException {
        PrintWriter writer = resp.getWriter();
        getOrdersResponse response = new getOrdersResponse(code, message, orders);
        writer.print(new Gson().toJson(response));
    }

    public static void printOrderResponse(HttpServletResponse resp, int code, String message, int orderId) throws IOException {
        PrintWriter writer = resp.getWriter();
        OrderResponse response = new OrderResponse(code, message, orderId);
        writer.print(new Gson().toJson(response));
    }
    public static void printOrderResponse(HttpServletResponse resp, int code, String message, int orderId, String state) throws IOException {
        PrintWriter writer = resp.getWriter();
        OrderResponse response = new OrderResponse(code, message, orderId, state);
        writer.print(new Gson().toJson(response));
    }

    public static void printCartOperationResponse(HttpServletResponse resp, CartOperationResponse cartOperationResponse) throws IOException {
        PrintWriter writer = resp.getWriter();
        writer.print(new Gson().toJson(cartOperationResponse));
    }
}

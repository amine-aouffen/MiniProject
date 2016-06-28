package com.mshop.backend.servlets;

import com.google.gson.Gson;
import com.mshop.backend.Util.UtilClass;
import com.mshop.backend.database.DataBaseService;
import com.mshop.backend.model.Order;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Dell on 22/06/2016.
 */
public class OrderValidationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

       // if(username != null && password != null) {
            StringBuilder sb = UtilClass.readJsonFomBody(req);
//            System.out.println(sb.toString());
            Gson gson = new Gson();
            Order order = gson.fromJson(sb.toString(), Order.class);
            order.setOrderDate(new Date());
            order.setIdClient(username);
            order.setState("validee");
//            System.out.println("order id :" + order.getId());
//            System.out.println("order price :" + order.getPrice());
//            System.out.println("order state :" + order.getState());
//            System.out.println("order idClient :" + order.getIdClient());
//            System.out.println("order date :" + order.getOrderDate());
//            System.out.println("order orderLines :");
//            System.out.println("orderLine product name :" + order.getOrderLines().get(0).getProductName());
//                dateFormat.parse(date);
            //    System.out.println(UtilClass.parseDateString(order.getOrderDate()));

            try {
                DataBaseService.insertOrder(order);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            UtilClass.printOrderResponse(resp, 1, "Order insertion successful", order.getId());
       // }else{
            UtilClass.printOrderResponse(resp, -1, "Order insertion failed : user not authenticated", -1);
      //  }

    }
}

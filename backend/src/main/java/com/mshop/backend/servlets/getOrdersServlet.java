package com.mshop.backend.servlets;

import com.google.gson.Gson;
import com.mshop.backend.Util.UtilClass;
import com.mshop.backend.database.DataBaseService;
import com.mshop.backend.model.Order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Salah on 27/06/2016.
 */
public class getOrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        if (username != null && password != null) {
            StringBuilder sb = UtilClass.readJsonFomBody(req);
            Gson gson = new Gson();

            List<Order> orders = DataBaseService.getOrders(username);
            UtilClass.printgetOrdersResponse(resp, 1, "orders retrieved sucessfully", orders);
        } else {
            UtilClass.printOrderResponse(resp, -1, "orders retriev failed : user not authenticated", -1);
        }
    }
}

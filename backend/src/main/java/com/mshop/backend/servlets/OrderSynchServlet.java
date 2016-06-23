package com.mshop.backend.servlets;

import com.google.gson.Gson;
import com.mshop.backend.Util.OrderJsonRequest;
import com.mshop.backend.Util.UtilClass;
import com.mshop.backend.database.DataBaseService;
import com.mshop.backend.model.Order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Dell on 23/06/2016.
 */
public class OrderSynchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        if (username != null && password != null) {
            StringBuilder sb = UtilClass.readJsonFomBody(req);
            Gson gson = new Gson();
            OrderJsonRequest orderJsonRequest = gson.fromJson(sb.toString(), OrderJsonRequest.class);
            String state = DataBaseService.getOrderState(orderJsonRequest.getOrderId());
            if(state != null){
                UtilClass.printOrderResponse(resp, 1, "order state retrieved sucessfully", orderJsonRequest.getOrderId(), state);
            }else{
                UtilClass.printOrderResponse(resp, -1, "order state retrieval failed", orderJsonRequest.getOrderId());
            }
        } else {
            UtilClass.printOrderResponse(resp, -1, "Order state retrieval failed : user not authenticated", -1);
        }
    }
}

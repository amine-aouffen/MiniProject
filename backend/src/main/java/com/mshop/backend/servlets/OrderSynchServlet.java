package com.mshop.backend.servlets;

import com.google.gson.Gson;
import com.mshop.backend.Util.OrderRequest;
import com.mshop.backend.Util.UtilClass;
import com.mshop.backend.database.DataBaseService;

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
            OrderRequest orderRequest = gson.fromJson(sb.toString(), OrderRequest.class);
            String state = DataBaseService.getOrderState(orderRequest.getOrderId());
            if(state != null){
                UtilClass.printOrderResponse(resp, 1, "order state retrieved sucessfully", orderRequest.getOrderId(), state);
            }else{
                UtilClass.printOrderResponse(resp, -1, "order state retrieval failed", orderRequest.getOrderId());
            }
        } else {
            UtilClass.printOrderResponse(resp, -1, "Order state retrieval failed : user not authenticated", -1);
        }
    }
}

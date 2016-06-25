package com.mshop.backend.servlets;

import com.google.gson.Gson;
import com.mshop.backend.Util.CartOperationRequest;
import com.mshop.backend.Util.CartOperationResponse;
import com.mshop.backend.Util.CartOperationTypes;
import com.mshop.backend.Util.UtilClass;
import com.mshop.backend.database.DataBaseService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Dell on 25/06/2016.
 */
public class CartOperationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuilder sb = UtilClass.readJsonFomBody(req);
        System.out.println(sb.toString());
        Gson gson = new Gson();
        CartOperationRequest cartOperationRequest = gson.fromJson(sb.toString(), CartOperationRequest.class);

        CartOperationResponse cartOperationResponse = new CartOperationResponse();
        switch (cartOperationRequest.getType()){
            case CartOperationTypes.CHECK:
                cartOperationResponse = DataBaseService.doCartCheckOperation(cartOperationRequest);
                break;
            case CartOperationTypes.MATH_OPERATION:
                cartOperationResponse = DataBaseService.doCartMathOperation(cartOperationRequest);
                break;
        }

        UtilClass.printCartOperationResponse(resp, cartOperationResponse);
    }
}

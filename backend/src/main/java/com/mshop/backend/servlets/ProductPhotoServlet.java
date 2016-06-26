package com.mshop.backend.servlets;

import com.google.gson.Gson;
import com.mshop.backend.database.DataBaseService;
import com.mshop.backend.model.Product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Salah on 26/06/2016.
 */
public class ProductPhotoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String density = req.getParameter("density");
        String product_name = req.getParameter("product_name");

        Product product = DataBaseService.getProductPhoto(density, product_name);
        resp.getWriter().write(new Gson().toJson(product));
    }
}

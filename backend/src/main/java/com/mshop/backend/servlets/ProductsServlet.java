package com.mshop.backend.servlets;

import com.google.gson.Gson;
import com.mshop.backend.database.ConnectionManager;
import com.mshop.backend.database.DataBaseService;
import com.mshop.backend.model.Product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String density = req.getParameter("density");
        String category = req.getParameter("category");
        String consumer = req.getParameter("consumer");

        List<Product> productList = DataBaseService.getProducts(category, consumer, density);
        resp.getWriter().write(new Gson().toJson(productList));
    }

    @Override
    protected void finalize() throws Throwable {
        ConnectionManager.getInstance().close();
        super.finalize();
    }
}

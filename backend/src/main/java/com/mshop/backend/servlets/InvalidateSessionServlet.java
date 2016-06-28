package com.mshop.backend.servlets;

import com.mshop.backend.Util.UtilClass;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Salah on 27/06/2016.
 */
public class InvalidateSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();

        UtilClass.printResponse(resp, 1, "Invalidate Session successful");
    }
}

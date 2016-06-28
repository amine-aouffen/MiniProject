package com.mshop.backend.servlets;

import com.google.gson.Gson;
import com.mshop.backend.Util.UtilClass;
import com.mshop.backend.database.DataBaseService;
import com.mshop.backend.model.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Dell on 23/06/2016.
 */
public class AuthenticationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuilder sb = UtilClass.readJsonFomBody(req);
        System.out.println(sb.toString());
        Gson gson = new Gson();
        User user = gson.fromJson(sb.toString(), User.class);

        if(DataBaseService.isUserValid(user.getUsername(), user.getPassword())) {
            HttpSession session = req.getSession();
            session.setAttribute("username", user.getUsername());
            session.setAttribute("password", user.getPassword());
            UtilClass.printResponse(resp, 1, "authentication successful");
        }else{
            UtilClass.printResponse(resp, -1, "authentication failed : user credentials are invalid");
        }
    }
}

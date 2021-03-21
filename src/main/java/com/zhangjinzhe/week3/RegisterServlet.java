package com.zhangjinzhe.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");
        String emile = request.getParameter("Emile");
        String Gender = request.getParameter("sex");
        String date = request.getParameter("date");

        PrintWriter writer = response.getWriter();
        writer.println("<br>username"+username);
        writer.println("<br>password"+password);
        writer.println("<br>emile"+emile);
        writer.println("<br>Gender"+Gender);
        writer.println("<br>date"+date);
        writer.close();
    }
}

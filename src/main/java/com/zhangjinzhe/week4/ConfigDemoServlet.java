package com.zhangjinzhe.week4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(//name = "ConfigDemoServlet", value = "/ConfigDemoServlet",
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name = "name",value = "zhangjinzhe"),
                @WebInitParam(name = "studentid",value = "2019211001000909"),
        }
//        loadOnStartup = 1
)
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String name = config.getInitParameter("name");
        String studentid = config.getInitParameter("studentid");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("name : "+name+"<br>");
        writer.println("studentid : "+studentid+"<br>");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

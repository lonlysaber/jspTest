package com.zhangjinzhe.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(//name = "RegisterServlet", value = "/RegisterServlet"
        urlPatterns = {"/register"},
        loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
    Connection con = null;
    String driver;
    String url;
    String username;
    String password;

    public void init(){
        ServletContext context = getServletContext();
        //获取参数值
        driver = context.getInitParameter("driver");
        url = context.getInitParameter("url");
        username = context.getInitParameter("username");
        password = context.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("Username");
//        String password = request.getParameter("Password");
//        String emile = request.getParameter("Emile");
//        String Gender = request.getParameter("sex");
//        String date = request.getParameter("date");
//
//        PrintWriter writer = response.getWriter();
//        writer.println("<br>username"+username);
//        writer.println("<br>password"+password);
//        writer.println("<br>emile"+emile);
//        writer.println("<br>Gender"+Gender);
//        writer.println("<br>date"+date);
//        writer.close();
        String id = null;
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        String Email = request.getParameter("Emile");
        String Gender = request.getParameter("gender");
        String BirthDate = request.getParameter("date");

        PrintWriter writer = response.getWriter();
        try {
            Statement creatdbst = con.createStatement();
            String insertDb = "insert into userdb.dbo.usertable(username,password,email,gender,birthdate) values('"+Username+"','"+Password+"','"+Email+"','"+Gender+"','"+BirthDate+"')";
            creatdbst.executeUpdate(insertDb);
            String selectDb = "select * from userdb.dbo.usertable";
            ResultSet rs = creatdbst.executeQuery(selectDb);
                writer.println(
                    "<table border=\"1\">" +
                    "<tr>"               +
                    "<td>ID</td>"        +
                    "<td>UserName</td>"  +
                    "<td>Password</td>"  +
                    "<td>Email</td>"     +
                    "<td>Gender</td>"    +
                    "<td>BirthDate</td>" +
                    "</tr>"
                );
            while(rs.next()) {
                id =rs.getString("id");
                Username = rs.getString("UserName");
                Password = rs.getString("Password");
                Email = rs.getString("Email");
                Gender = rs.getString("Gender");
                BirthDate = rs.getString("BirthDate");
                writer.println(

                                "<tr>"     +
                                "<td>" + id       + "</td>"   +
                                "<td>" + Username + "</td>" +
                                "<td>" + Password  + "</td>" +
                                "<td>" + Email     + "</td>" +
                                "<td>" + Gender    + "</td>" +
                                "<td>" + BirthDate + "</td>" +
                                "</tr>"
                                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        writer.println("</table>");





    }
}

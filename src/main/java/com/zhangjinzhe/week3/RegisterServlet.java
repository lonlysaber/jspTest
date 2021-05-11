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
//        ServletContext context = getServletContext();
//        //获取参数值
//        driver = context.getInitParameter("driver");
//        url = context.getInitParameter("url");
//        username = context.getInitParameter("username");
//        password = context.getInitParameter("password");
//        try {
//            Class.forName(driver);
//            con = DriverManager.getConnection(url,username,password);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
        con = (Connection) getServletContext().getAttribute("con");

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
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
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");
        String Email = request.getParameter("emile");
        String Gender = request.getParameter("gender");
        String BirthDate = request.getParameter("birthDate");

        PrintWriter writer = response.getWriter();
        try {
            Statement creatdbst = con.createStatement();
            String insertDb = "insert into userdb.dbo.usertable(username,password,email,gender,birthdate) values('"+Username+"','"+Password+"','"+Email+"','"+Gender+"','"+BirthDate+"')";
            int n = creatdbst.executeUpdate(insertDb);
            System.out.println("n-->"+n);
            //String selectDb = "select * from userdb.dbo.usertable";
            //ResultSet rs = creatdbst.executeQuery(insertDb);

            //request.setAttribute("rsname",rs);
            //request.getRequestDispatcher("userList.jsp").forward(request,response);
            System.out.println("i am in RegisterServlet-->doPost()-->afterforward()");
            response.sendRedirect("login");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

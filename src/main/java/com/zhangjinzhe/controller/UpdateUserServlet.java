package com.zhangjinzhe.controller;


import com.zhangjinzhe.dao.UserDao;
import com.zhangjinzhe.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String Username = request.getParameter("Username");
//        String Password = request.getParameter("Password");
//        String Email = request.getParameter("Emile");
//        String Gender = request.getParameter("gender");
//        String BirthDate = request.getParameter("date");
//        User u = new User(id,Username,Password,Email,Gender,BirthDate);
//
//        try {
//            UserDao userDao =new UserDao();
//            int rst = userDao.updateUser(con, u);
//            if (rst!=0){
//                request.getRequestDispatcher("/login").forward(request,response);
//            }else {
//                request.setAttribute("message", "Username or Password Error!!!");
//                request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        int id = Integer.parseInt(request.getParameter("id"));
        String Username = request.getParameter("Username");
        String Password = request.getParameter("password");
        String Email = request.getParameter("Email");
        String Gender = request.getParameter("sex");

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date BirthDate = sdf.parse(request.getParameter("BirthDate"));

            User user = new User();
            user.setId(id);
            user.setUsername(Username);
            user.setPassword(Password);
            user.setEmail(Email);
            user.setGender(Gender);
            user.setBirthdate(BirthDate);

            UserDao userDao = new UserDao();
            Connection con = (Connection) getServletContext().getAttribute("con");
            try {
                if (userDao.updateUser(con, user) != 0) {
                    User u = userDao.findByUsernamePassword(con, Username, Password);
                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(10);
                    session.setAttribute("user", u);
                    request.getRequestDispatcher("accountDetails").forward(request, response);
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}

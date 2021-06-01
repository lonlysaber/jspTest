package com.zhangjinzhe.week5;

import com.zhangjinzhe.dao.UserDao;
import com.zhangjinzhe.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    String driver;
    String url;
    String username;
    String password;
    @Override
    public void init() throws ServletException {
//        ServletContext context=this.getServletContext();
//        driver = context.getInitParameter("driver");
//        url = context.getInitParameter("url");
//        username = context.getInitParameter("username");
//        password = context.getInitParameter("password");
//
//        try{
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, username, password);
//            System.out.println("进入数据库init()-->"+con);//连接数据库成功
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(request,response);
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(con,username,password);
            if(user!=null){
//                Cookie c = new Cookie("sessionid",""+user.getId());
//                c.setMaxAge(10*60);
//                response.addCookie(c);
                String remeberMe = request.getParameter("remeberME");
                if (remeberMe!=null&&remeberMe.equals("1")){
                    Cookie usernameCookies = new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookies = new Cookie("cPassword",user.getPassword());
                    Cookie remeberMeCookies = new Cookie("cRemeberME",remeberMe);

                    usernameCookies.setMaxAge(5);
                    passwordCookies.setMaxAge(5);
                    remeberMeCookies.setMaxAge(5);

                    response.addCookie(usernameCookies);
                    response.addCookie(passwordCookies);
                    response.addCookie(remeberMeCookies);
                }
                HttpSession session = request.getSession();
                System.out.println("session id----->"+session.getId());
                session.setMaxInactiveInterval(10);

                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);

            }else{

                request.setAttribute("message","Username or Password error");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();//当tomcat停止时释放内存
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
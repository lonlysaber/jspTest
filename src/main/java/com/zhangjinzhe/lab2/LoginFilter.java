package com.zhangjinzhe.lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/lab2/welcome.jsp","/lab2/validate.jsp"})
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("i am in LoginFilter--init()");
    }
    @Override
    public void destroy() {
        System.out.println("i am in LoginFilter--destory()");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {



        System.out.println("LoginFilter()-->berfore chain");
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;

        chain.doFilter(request,response);
        System.out.println("LoginFilter()-->after chain");

        Login user=(Login) req.getAttribute("user");
        if(user.getUsername() != null && user.getPassword() != null){
            req.getRequestDispatcher("/lab2/welcome.jsp").forward(req,res);
        }else {
            res.sendRedirect("login.jsp");
        }

    }


}

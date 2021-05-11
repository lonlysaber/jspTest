package com.zhangjinzhe.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FrontEndAuthenticationFilter {
    private HttpServletRequest httpRequest;
    private static final String[] loginRequiredURLs={"/updateUser","/logout","/myCart"};
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        httpRequest = (HttpServletRequest) request;
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        if (path.startsWith("/admin/")){
            chain.doFilter(request,response);
            return;
        }
        HttpSession session = httpRequest.getSession(false);
        boolean isLoggedIn  =(session!=null&&session.getAttribute("userList")!=null);
        String loginURI = httpRequest.getContextPath() + "/login";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login");

        if (isLoggedIn&&(isLoginPage||isLoginRequest)){
            httpRequest.getRequestDispatcher("/").forward(request,response);
        }else if(!isLoggedIn&&isLoginRequired()){
            String loginPage = "login";
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPage);
            dispatcher.forward(request,response);
        }else{
            chain.doFilter(request,response);
        }

    }
    private boolean isLoginRequired(){
        String requestURL = httpRequest.getRequestURI().toString();
        for (String loginRequiredURL : loginRequiredURLs){
            if(requestURL.contains(loginRequiredURL)){
                return true;
            }
        }
        return false;
    }
    public void destroy(){
    }
    public void init(FilterConfig config) throws ServletException {
    }

}

package com.zhangjinzhe.week6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String txt = request.getParameter("text");
        String search = request.getParameter("search");
        response.setContentType("text/html");
        if(txt.equals("")){
            response.sendRedirect("index.jsp");
        }
        else{

            if(search.equals("baidu")){
                response.sendRedirect("https://www.baidu.com/s?wd="+txt);
            }else if(search.equals("google")){
                response.sendRedirect("https://www.google.com/search?q="+txt);
            }else if(search.equals("bing")){
                response.sendRedirect("https://cn.bing.com/search?q="+txt);
            }
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}

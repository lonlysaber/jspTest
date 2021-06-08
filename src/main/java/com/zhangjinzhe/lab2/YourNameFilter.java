package com.zhangjinzhe.lab2;



import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.LogRecord;

@WebFilter(filterName = "YourNameFilter", urlPatterns = "/lab2/welcome.jsp")
public class YourNameFilter implements Filter {
    public void init(FilterConfig config)throws ServletException{

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("YourNameFilter()-->berfore chain");
        chain.doFilter(request,response);
        System.out.println("YourNameFilter()-->after chain");
    }


}

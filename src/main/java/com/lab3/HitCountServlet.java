package com.lab3;

import jdk.nashorn.internal.objects.Global;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HitCountServlet", value = "/HitCountServlet")
public class HitCountServlet extends HttpServlet {
    static int count = 0;
    @Override
    public void init() throws ServletException {

        super.init();

    }
    public void showCount(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                count++;
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");

                out.println("</head>");
                out.println("<body>");
                out.println("<h1 align=center>" + "Total Number of Hits" + "</h1>");
                out.println("<h1 align=center>" + count + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }

        }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            showCount(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            showCount(request,response);
    }
}

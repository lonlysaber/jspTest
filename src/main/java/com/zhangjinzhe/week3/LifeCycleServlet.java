package com.zhangjinzhe.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LifeCycleServlet", value = "/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
    public LifeCycleServlet(){
        System.out.println("i am in liftCycle()");
    }
    public void inti(){
        System.out.println("i am in inti()");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in service -> doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        System.out.println("i am in destory()");
    }
}

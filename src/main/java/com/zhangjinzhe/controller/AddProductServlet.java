package com.zhangjinzhe.controller;

import com.zhangjinzhe.dao.ProductDao;
import com.zhangjinzhe.model.Category;
import com.zhangjinzhe.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

@WebServlet(name = "AddProductServlet", value = "/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)
public class AddProductServlet extends HttpServlet {
    Connection con=null;
    public void init(){
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> categoryList = Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
            String path="../WEB-INF/views/admin/addProduct.jsp";
            request.getRequestDispatcher(path).forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName=request.getParameter("productName");
        double price=request.getParameter("price")
                !=null?Double.parseDouble(request.getParameter("price")):0.0;
        int categoryId=request.getParameter("categoryId")
                !=null?Integer.parseInt(request.getParameter("categoryId")):8;
        String productDescription =request.getParameter("productDescription");

        InputStream inputStream=null;
        Part fileParts = request.getPart("picture");
        if (fileParts!=null){
            inputStream =fileParts.getInputStream();
        }

        Product product =new Product();
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setPicture(inputStream);
        product.setPrice(price);
        product.setCategoryId(categoryId);
        ProductDao productDao=new ProductDao();
        int i=0;
        try {
            i =productDao.save(product,con);
            if (i>0){
                response.sendRedirect("productList");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
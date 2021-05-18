package com.zhangjinzhe.dao;

import com.zhangjinzhe.model.Product;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{

    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        String sql ="delete from produce where productid=?";
        PreparedStatement pt = con.prepareStatement(sql) ;
        pt.setInt(1,productId);
        return pt.executeUpdate();
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        String sql = "update userdb.dbo.Product set ProductName=?,ProductDescription=?,picture=?,price=?,CategoryId=? where ProductId=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setString(1,instance.getProductName());
        pt.setString(2,instance.getProductDescription());
        pt.setBinaryStream(3,instance.getPicture());
        pt.setDouble(4,instance.getPrice());
        pt.setInt(5,instance.getCategoryId());
        pt.setInt(6,instance.getProductId());
        return pt.executeUpdate();
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String sql = "select * from userdb.dbo.Product where ProductId=? ";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs=pt.executeQuery();
        Product p = new Product();
        while (rs.next()){
            p.setProductId(rs.getInt("ProductId"));
            p.setProductName(rs.getString("ProductName"));
            p.setProductDescription(rs.getString("ProductDescription"));
            p.setPicture(rs.getBinaryStream("picture"));
            p.setPrice(rs.getDouble("price"));
            p.setCategoryId(rs.getInt("CategoryId"));
        }
        return p;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        String sql = "select * from userdb.dbo.Product where CategoryId= ?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,categoryId);
        return getProducts(pt);
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        String sql = "select * from userdb.dbo.Product where price>? & price<?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setDouble(1,minPrice);
        pt.setDouble(2,maxPrice);
        return getProducts(pt);
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        String sql = "select * from userdb.dbo.Product";
        PreparedStatement pt=con.prepareStatement(sql);
        return getProducts(pt);
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        String sql = "select * from userdb.dbo.Product where ProductName= ?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setString(1,productName);
        return getProducts(pt);
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        String sql = "select * from userdb.dbo.Product where picture is not null ";
        PreparedStatement pt=con.prepareStatement(sql);
        return getProducts(pt);
    }

    private List<Product> getProducts(PreparedStatement pt) throws SQLException {
        ResultSet rs= pt.executeQuery();
        List<Product> list= new ArrayList<>();
        if (rs.next()) {
            Product product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPrice(rs.getDouble("price"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setCategoryId(rs.getInt("CategoryId"));
            list.add(product);
        }
        return list;
    }
}

package com.zhangjinzhe.dao;

import com.zhangjinzhe.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements IUserDao{


    //@Override
    public int saveUser(Connection con, User user) throws SQLException {
        String sql ="insert usertable into username=?,password=?,email=?,gender=?,birthdate=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,user.getUsername());
        st.setString(2,user.getPassword());
        st.setString(3,user.getEmail());
        st.setString(4,user.getGender());
        st.setString(5,user.getBirthdate());

        return st.executeUpdate();
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql ="delete from usertable where id=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1,user.getId());
        return st.executeUpdate();
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql ="update usertable set username=?,password=?,email=?,gender=?,birthdate=? where id =?";
        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1,user.getUsername());
        st.setString(2,user.getPassword());
        st.setString(3,user.getEmail());
        st.setString(4,user.getGender());
        st.setString(5,user.getBirthdate());
        st.setInt(6,user.getId());
        System.out.println("i am in updateUser()");
        return st.executeUpdate();
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql ="select * from usertable where id=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1,id);
        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("birthdate"));
        }
        return user;

    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql ="select * from usertable where username=? and password=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql ="select * from usertable where username=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,username);
        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("birthdate"));
        }
        return (List<User>) user;

    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql ="select * from usertable where password=?";
        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1,password);
        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("birthdate"));
        }
        return (List<User>) user;

    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql ="select * from usertable where email=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,email);

        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("birthdate"));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql ="select * from usertable where gender=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,gender);

        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("birthdate"));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findByBirthdate(Connection con, String birthdate) throws SQLException {
        String sql ="select * from usertable where birthdate=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,birthdate);

        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("birthdate"));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql ="select * from usertable";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("birthdate"));
        }
        return (List<User>) user;
    }
}

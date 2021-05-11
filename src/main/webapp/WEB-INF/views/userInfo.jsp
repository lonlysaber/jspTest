<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/4/8
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.zhangjinzhe.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%--<%--%>
<%--    Cookie [] allcookies = request.getCookies();--%>
<%--    for(Cookie c:allcookies){--%>
<%--        out.println("<br>"+c.getName()+"---"+c.getValue());--%>
<%--    }--%>
<%--%>--%>
<%
    User u = (User)session.getAttribute("user");
%>
<table>
    <tr><td>ID:</td><td><%=u.getId()%></td></tr>
    <tr><td>Username:</td><td><%=u.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=u.getPassword()%></td></tr>
    <tr><td>Email:</td><td><%=u.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=u.getGender()%></td></tr>
    <tr><td>BirthDate:</td><td><%=u.getBirthdate()%></td></tr>
    <tr><td><a href="updateUser">Update User</a></td></tr>
</table>
<%@include file="footer.jsp"%>

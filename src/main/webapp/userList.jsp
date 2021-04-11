<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/4/7
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.io.PrintWriter" %>

<h1 align="center">User List</h1>
<table border=1 align="center">
<tr>
    <td>ID</td><td>UserName</td><td>Password</td><td>Email</td><td>Gender</td><td>BirthDate</td>
</tr>
    <%
        ResultSet rs = (ResultSet) request.getAttribute("rsname");

        if(rs==null){
    %>
    <tr>
        <td>No Date!!</td>
    </tr>
    <% }else {



        while (rs.next()) {

            out.println("<tr>");
            out.println("<td>" + rs.getString("id") + "</td>");
            out.println("<td>" + rs.getString("UserName") + "</td>");
            out.println("<td>" + rs.getString("Password") + "</td>");
            out.println("<td>" + rs.getString("Email") + "</td>");
            out.println("<td>" + rs.getString("Gender") + "</td>");
            out.println("<td>" + rs.getString("BirthDate") + "</td>");
            out.println("</tr>");

        }

    }
    %>

</table>
<%@include file="footer.jsp"%>

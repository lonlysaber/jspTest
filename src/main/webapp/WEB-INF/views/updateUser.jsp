<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/4/24
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.zhangjinzhe.model.User" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>
<%
    User u = (User)session.getAttribute("user");
%>
<form style="text-align:center;background: cadetblue;" method="post" action="updateUser">
    <span style="color:#ff0000">New User Registration</span><br/>
    <input type="hidden" name="id" value="<%=u.getId()%>">
    <input style = "border-radius: 15px;background: #EAEAAE;" type="text" name="Username" value = "<%=u.getUsername()%>" required="required"><br/><br/>
    <input style="border-radius: 15px;background: #EAEAAE;" type="password" name="Password" value = "<%=u.getPassword()%>" required="required" maxlength="8"><br/><br/>
    <input style = "border-radius: 15px;background: #EAEAAE;" type="text"  name="Emile" value=" <%=u.getEmail()%>" required="required"><br/><br>
    Gender: <input type="radio" name="gender" value="male" <%="male".equals(u.getGender())?"checked":""%>>Male
    <input type="radio" name="gender" value="famale" <%="famale".equals(u.getGender())?"checked":""%>>Famale<br/><br/>
    <input style = "border-radius: 15px;background: #EAEAAE;" type="text"  name="date" value="<%=u.getBirthdate()%>" required="required"/><br/><br>

    <input style="color:#ff0000" type="submit" value="Save Changes">
</form>
<%@include file="footer.jsp"%>

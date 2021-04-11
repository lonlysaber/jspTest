<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/4/5
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<%
    if(!(request.getAttribute("message") ==null)){
        out.print("<h3>"+request.getAttribute("message")+"<h3>");
    }
%>
<form style="text-align: center;background: #9932CD" method="post" action="login">
    <h1 style="text-align: center;color: #ff00ff">login</h1>
    username:<input type="text" name="username"><br/>
    password:<input type="password" name="password"><br/>
<%--    <input type="text" name="username" value="" placeholder="username"></br></br>--%>
<%--    <input type="password" name="password" value="" placeholder="password"></br></br>--%>
    <input type="submit" name="login" value="login">
</form>
<%@include file="footer.jsp"%>

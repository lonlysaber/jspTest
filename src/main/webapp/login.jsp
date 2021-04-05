<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/4/5
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>>
<form style="text-align: center;background: #9932CD" method="post" action="login">
    <h1 style="text-align: center;color: #ff00ff">login</h1>
    <input type="text" name="username" value="" placeholder="username"></br></br>
    <input type="password" name="password" value="" placeholder="password"></br></br>
    <input type="submit" name="login" value="login">
</form>
<%@include file="footer.jsp"%>

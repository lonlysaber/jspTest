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
        //out.print(request.getAttribute("message"));
    }
%>
<%
    Cookie[] allCookies = request.getCookies();
    String username = "",password = "",rememberMeVal = "";
    if(allCookies!=null){
        for (Cookie c:allCookies){
            if(c.getName().equals("cUsername")){
                username = c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password = c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeVal = c.getValue();
            }
        }
    }
%>
<form style="text-align: center;background: #9932CD" method="post" action="login">
    <h1 style="text-align: center;color: #ff00ff">login</h1>
    username:<input type="text" name="username" value="<%=username%>"><br/>
    password:<input type="password" name="password" value="<%=password%>"><br/>
<%--    <input type="text" name="username" value="" placeholder="username"></br></br>--%>
<%--    <input type="password" name="password" value="" placeholder="password"></br></br>--%>
    <input type="checkbox" name="remeberME" value="1" <%=rememberMeVal.equals("1")?"checked":""%>>remeberme</br>
    <input type="submit" name="login" value="login">
</form>
<%@include file="footer.jsp"%>

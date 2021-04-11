<%@include file="header.jsp"%>
<h1><%= "Hello World!" %>
</h1>
<br/>
<h1>Welcome to my online home page.</h1>
<form method="get" target="_blank" action="search">
    <input type="text" name="text" size=30/>
    <select name="search">
        <option value="baidu">baidu</option>
        <option value="google">google</option>
        <option value="bing">bing</option>
    </select>
    <input type="submit" value="search"/>
</form>
<a href="hello-servlet">Hello Servlet</a>
<a href="hello">student into servlet-week2</a>
<br>
<a href="life">life cycle servlet-week3</a>
<br>
<a href="Register.jsp">Register-getParameter-week3</a>
<br>
<a href="config">Config parameter-week4</a>
<br>
<a href="Register.jsp">Register jdbc-week4</a>
<br>
<a href="index.jsp">include-week5</a>
<br>
<a href="login.jsp">Login-week5</a>

<%@include file="footer.jsp"%>
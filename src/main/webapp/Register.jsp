<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/3/20
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form</title>
</head>
<body>
<form style="text-align:center;background: cadetblue;" method="post" action="register">
    <span style="color:#ff0000">New User Registration</span><br/>
    <input style = "border-radius: 15px;background: #EAEAAE;" type="text" name="Username" value = "Username" required="required"
           onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
           onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999;border-radius: 15px;"><br/><br/>
    <input style="border-radius: 15px;background: #EAEAAE;" type="password" name="Password" value = "Password" required="required" maxlength="8"
           onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
           onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999;border-radius: 15px;"><br/><br/>

    <input style = "border-radius: 15px;background: #EAEAAE;" type="text"  name="Emile" value=" Emile" required="required"
           onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
           onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999;border-radius: 15px;"><br/><br>
    Gender: <label><input type="radio" name="gender" value="male"></label>
    Male <label><input type="radio" name="gender" value="female"></label>Female<br/>
    <input style = "border-radius: 15px;background: #EAEAAE;" type="text"  name="date" value=" date of birth (yyyy/mm/dd)" required="required"
           onFocus="if(value==defaultValue){value='';this.style.color='#ffaa00'}"
           onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999;border-radius: 15px;"><br/><br>

    <input style="color:#ff0000" type="submit" value="Register">
</form>
</body>
</html>

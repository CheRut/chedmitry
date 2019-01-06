<%--
  Created by IntelliJ IDEA.
  User: dimsan
  Date: 01.12.2018
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>authorization</title>
</head>
<body>
<fieldset>
    <legend>Authorization</legend>
    <c:if test="${error!= ''}">
        <div style="background-color: red" >
            <c:out value="${error}"/>
        </div>
    </c:if>

    <form method="post" action="account">
        <table cellpadding="2" cellspacing="2">
            <tr>
                <td>Login</td>
                <td><input type="text" name="login"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="Login"></td>
            </tr>
        </table>
    </form>

    administrator:"admin","123"
    <br>
    user:"user","111"



</fieldset>

</body>
</html>

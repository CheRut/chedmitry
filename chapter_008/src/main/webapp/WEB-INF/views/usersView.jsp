<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>users</title>
</head>
<body>
<div align="left">
        <caption><h2>List of Users</h2></caption>
        <c:forEach var="user" items="${userList}">
            <ul>
                <li> Id:<c:out value="${user.id}" /></li>
                <li> Name:<c:out value="${user.name}" /></li>
                <li> Email:<c:out value="${user.email}" /></li>
                <li> Create:<c:out value="${user.create}" /></li>
            </ul>
        </c:forEach>

    <a href="admin/account?action=Login">Sign in</a>
</div>
</body>
</html>
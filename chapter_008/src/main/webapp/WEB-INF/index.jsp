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
                <li> Actions:
                    <a href="/edit?id=<c:out value='${user.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=<c:out value='${user.id}' />">Delete</a>
                </li>
            </ul>
        </c:forEach>

    <h3>
        <a href="/new">Add User</a>
    </h3>
</div>
</body>
</html>
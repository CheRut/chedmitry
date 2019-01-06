<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>users</title>
</head>
<body>
<form align="left" action="${pageContext.servletContext.contextPath}/admin/users?action=/list" method="post">
    <caption><h2>ADMINISTRATOR PAGE</h2></caption>

    <c:forEach var="user" items="${userList}">
        <ul>

            <li> Id:<c:out value="${user.id}" /></li>

            <li> Name:<c:out value="${user.name}" /></li>
            <li> Email:<c:out value="${user.email}" /></li>
            <li> Create:<c:out value="${user.create}" /></li>
            <li> Role:<c:out value="${user.role}" /></li>
            <li> Actions:

                <a href="${pageContext.servletContext.contextPath}/admin/users?action=/edit&id=${user.id}"/>Edit</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="${pageContext.servletContext.contextPath}/admin/users?action=/delete&id=${user.id}"/>Delete</a>

            </li>
        </ul>
    </c:forEach>

    <%--<a href="/admin/users?action=%2fnew">Add User</a>--%>
    <a href="${pageContext.servletContext.contextPath}/admin/users?action=/new">Add User</a>


    <a href="${pageContext.servletContext.contextPath}/admin/account?action=logout">Logout</a>



</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>users</title>
</head>
<body>
<form align="left" >
    <caption><h2>User page</h2></caption>
    <c:if test="${user != null}">
        <input type="hidden" name="id" value="<c:out value='${user.id}' />" />

        <ul>
            <li> Id:<c:out value="${user.id}" /></li>
            <li> Name:<c:out value="${user.name}" /></li>
            <li> Email:<c:out value="${user.email}" /></li>
            <li> Create:<c:out value="${user.create}" /></li>
            <li> Role:<c:out value="${user.role}" /></li>
            <li> Actions:
                <a href="${pageContext.servletContext.contextPath}/users/selfpage?action=/edit&id=${user.id}"/>Edit</a>

            </li>
        </ul>
    </c:if>



    <a href="/admin/account?action=Login">Logout</a>


</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>new/update</title>
</head>
<body>
<center>
    <h3>
      Edit user
    </h3>
</center>
<div align="center">
    <c:if test="${user != null}">
    <form action="${pageContext.servletContext.contextPath}/users/selfpage?action=/update" method="post">
        </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${user != null}">
                            Edit User
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${user != null}">
                    <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                </c:if>
                <tr>
                    <th>Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${user.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Em@il: </th>
                    <td>
                        <input type="text" name="email" size="45"
                               value="<c:out value='${user.email}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Create: </th>
                    <td>
                        <input type="text" name="create" size="5"
                               value="<c:out value='${user.create}' />"
                        />
                    </td>
                </tr>
                <input type="hidden" name="login" value="<c:out value='${user.login}' />" />
                <input type="hidden" name="password" value="<c:out value='${user.password}' />" />
                <input type="hidden" name="role" value="<c:out value='${user.role}' />" />
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
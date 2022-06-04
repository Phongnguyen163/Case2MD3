<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 6/4/2022
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="text" name="name">
    <input type="text" name="img">
    <input type="text" name="numberOfProduct">
    <input type="text" name="price">
    <select name="categoryid">
        <c:forEach items='${categories}' var="ca">
            <option value="${ca.id}">${ca.name}</option>
        </c:forEach>
    </select>
    <button>

        Thêm
    </button>
</form>
</body>
</html>

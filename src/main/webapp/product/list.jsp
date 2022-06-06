<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 6/3/2022
  Time: 3:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Day la danh sach</h2>
<c:forEach items="${ds}" var="pro">
    <h2>${pro.name}, ${pro.img}, ${pro.numberOfProduct}, ${pro.price}, ${pro.categoryzz.name}</h2>
</c:forEach>
</body>
</html>

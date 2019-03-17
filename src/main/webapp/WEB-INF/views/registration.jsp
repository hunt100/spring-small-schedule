<%--
  Created by IntelliJ IDEA.
  User: Anvar HunT
  Date: 13.12.2018
  Time: 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Reg</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="/resources/js/bootstrap.min.js"></script>
</head>
<body>
<form:form action="/register" method="post" modelAttribute="userForm">
    <form:input type="email" path="email"></form:input>
    <form:input type="password" path="password"></form:input>
    <input type="SUBMIT" value="Submit" />
</form:form>

 
</body>
</html>

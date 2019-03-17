<%@ page import="com.myspring.entities.Users" %><%--
  Created by IntelliJ IDEA.
  User: Ali
  Date: 12.12.2018
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="/resources/js/bootstrap.min.js"></script>
</head>
<body>
<%
    Users user = (Users)request.getAttribute("user");
%>
<h1>PROFILE PAGE OF <%=user.getEmail() %> </h1>
<br>
<a href="admin">ADMIN PAGE</a>
<a href="main">MAIN PAGE</a>
<br>
<form action="logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="LOGOUT" class="btn btn-primary">
</form>
</body>

</body>
</html>

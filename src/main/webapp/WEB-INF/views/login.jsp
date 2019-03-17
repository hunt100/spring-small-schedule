<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.myspring.entities.Users" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Hello Spring</title>
    <%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">--%>
    <%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>--%>
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>--%>
    <%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>--%>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

    <style>

        /*body {*/
            /*background: #9F9F9F !important;*/
        /*}*/

        .wrapper {
            margin-top: 80px;
            margin-bottom: 80px;
        }

        .form-signin {
            max-width: 400px;
            padding: 15px 35px 45px;
            margin: 0 auto;
            background-color: #fff;
            border: 1px solid rgba(0, 0, 0, 0.1);
        }

        .form-signin-heading{
            margin-bottom: 30px;
        }



        .form-control {
            position: relative;
            font-size: 16px;
            height: auto;
            padding: 10px;
        @include box-sizing(border-box);

        }

        input[type="text"] {
            margin-bottom: -1px;
            border-bottom-left-radius: 0;
            border-bottom-right-radius: 0;
        }

        input[type="password"] {
            margin-bottom: -1px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }

        .loginmodal-container {
            padding: 30px;
            max-width: 400px;
            width: 100% !important;
            background-color: #F7F7F7;
            margin: 0 auto;
            border-radius: 2px;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            overflow: hidden;
        }

        .loginmodal-submit {
            /* border: 1px solid #3079ed; */
            border: 0px;
            color: #fff;
            text-shadow: 0 1px rgba(0,0,0,0.1);
            background-color: #4d90fe;
            padding: 17px 0px;
            font-size: 14px;
            /* background-image: -webkit-gradient(linear, 0 0, 0 100%,   from(#4d90fe), to(#4787ed)); */
        }

        .loginmodal-container a {
            text-decoration: none;
            color: #666;
            font-weight: 400;
            text-align: center;
            display: inline-block;
            opacity: 0.6;
            transition: opacity ease 0.5s;
        }

        body {
            background-image: url("/resources/img/282040.jpg");
            background-size: cover;
            background-repeat: no-repeat;
        }


    </style>

</head>
<body>
<%--<form action="/login" method="post">--%>
    <%--EMAIL : <input type="email" name="email_parameter"><br><br>--%>
    <%--PASSWORD : <input type="password" name="password_parameter"><br><br>--%>
    <%--<input type="submit" value="SIGN IN"><br><br>--%>
    <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
<%--</form>--%>
<%--<a href="/register">REGISTRATION</a>--%>

<div class="wrapper">
    <form class="form-signin" action="/login" method="post">
        <h2 class="form-signin-heading">Please login</h2>
        <input type="email" class="form-control" name="email_parameter" placeholder="Email Address" required="" autofocus="" />
        <input type="password" class="form-control pass_show" name="password_parameter" placeholder="Password" required=""  data-toggle="password"/>
        <br>
            <button class="btn btn-lg btn-primary btn-block" type="submit" value="SIGN IN">Login</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <a href="#" data-toggle="modal" data-target="#login-modal" > <p class="text-center">Or you can pass Registration</p></a>
    </form>

</div>


<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="loginmodal-container">
            <h1 class="form-signin-heading">Account Registration</h1><br>
            <form:form action="/register" method="post" modelAttribute="userForm">
                <form:input type="email" path="email" class="form-control" placeholder="Email Address" required=""></form:input>
                <form:input path="password" type="password" class="form-control pass_show" id="password" placeholder="Password" required=""></form:input>
                <br>
                <button type="button" class="btn btn-primary btn-sm" onclick="myFunction()">Click</button> <span>Show/Hide Password</span>
                <br><br>
                <input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign up">
            </form:form>

            <%--<form:input type="email" path="email" class="form-control" name="email_parameter" placeholder="Email Address" required="" autofocus=""></form:input>--%>
            <%--<form:input type="password" path="password" class="form-control pass_show" name="password_parameter" placeholder="Password" required="" id="password" data-toggle="password"/></form:form>--%>
            <%--<br>--%>
            <%--<button type="button" class="btn btn-primary btn-sm" onclick="myFunction()">Click</button> <span>Show/Hide Password</span>--%>
            <%--<br><br>--%>
            <%--<button class="btn btn-lg btn-primary btn-block" type="submit" value="Submit">Sign up</button>--%>

        </div>
    </div>
</div>


</body>

<script src="/resources/js/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="/resources/js/bootstrap.min.js"></script>

<script type="text/javascript">
    function myFunction() {
        var x = document.getElementById("password");
        if (x.type === "password") {
            x.type = "text";
        } else {
            x.type = "password";
        }
    }
</script>
</html>
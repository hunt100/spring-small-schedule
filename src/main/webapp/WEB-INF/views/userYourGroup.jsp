<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/animate.min.css">
    <link rel="stylesheet" href="/resources/css/light-bootstrap-dashboard.css">
    <link rel="stylesheet" href="/resources/css/pe-icon-7-stroke.css">
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

    <style>

    </style>

</head>
<body>
<div class="wrapper">



    <nav class="navbar navbar-default navbar-fixed">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="">Welcome, ${user.email}</a>   <!-- ------------------------------------------- -->
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li>

                    <c:if test="${isAdmin}">
                        <a class="btn btn-outline-primary" href="/admin" role="button">
                            Admin panel
                        </a>
                    </c:if>
                </li>
                <li>

                    <form action="logout" method="post" style="padding: 0; margin: 0;">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <button type="submit" class=" btn btn-outline-primary " value="LOGOUT">Log out</button>
                    </form>
                </li>
            </ul>
        </div>
    </nav>

    <div class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">

                        <div class="header">
                            <h4 class="title">Welcome to your group Schedule</h4>
                            <p class="category">Schedule</p>
                        </div>
                        <div class="content">
                            <a href="/main">Go back</a>
                        </div>
                    </div>
                </div>
                <c:choose>
                    <c:when test="${sch!=null}">
                        <div class="content">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="card">

                                            <div class="header">
                                                <h4 class="title">Search Schedule</h4>
                                                <p class="category">Search Schedule</p>
                                            </div>
                                            <div class="content">
                                                <table class="table">
                                                    <thead>
                                                    <th></th>
                                                    <th>MONDAY</th>
                                                    <th>TUESDAY</th>
                                                    <th>WEDNESDAY</th>
                                                    <th>THURSDAY</th>
                                                    <th>FRIDAY</th>
                                                    <th>SATURDAY</th>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach var="row" items="${sch}" varStatus="statusRow">
                                                        <tr>
                                                            <td>${timer = timer + 1}:00</td>
                                                            <c:forEach var="day" items="${row}"  varStatus="statusCol">
                                                                <c:choose>
                                                                    <c:when test="${day!=null}">
                                                                        <td>
                                                                            <p>Subject: ${day.subject.subjectName}</p>
                                                                            <p>Teacher: ${day.teacher.degree} ${day.teacher.lname} ${day.teacher.fname}</p>
                                                                            <p>Group: ${day.group.groupName}</p>
                                                                            <p>${day.classType.classType} ${day.time} - ${day.weekDay} </p>
                                                                        </td>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <td></td>
                                                                    </c:otherwise>
                                                                </c:choose>


                                                            </c:forEach>
                                                        </tr>

                                                    </c:forEach>

                                                    </tbody>
                                                </table>
                                                <a href="/main">Go back</a>
                                            </div>
                                        </div>
                                    </div>




                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="content">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="card">

                                            <div class="header">
                                                <h4 class="title">I'm so sorry</h4>
                                                <p class="category">I'm so sorry</p>
                                            </div>
                                            <div class="content">
                                                <h2 class="category">I'm so sorry about this, but you don't have any connected group</h2>
                                                <h3 class="category">Ask your administrator, maybe he can help with this problem.</h3>
                                                <a href="/main">Go back</a>
                                            </div>
                                        </div>
                                    </div>




                                </div>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
    </div>


</div>
</div>
</div>
</div>
</body>

<!--   Core JS Files   -->
<script src="/resources/js/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="/resources/js/bootstrap.min.js" type="text/javascript"></script>

<!--  Charts Plugin -->
<script src="/resources/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="/resources/js/bootstrap-notify.js"></script>

</html>



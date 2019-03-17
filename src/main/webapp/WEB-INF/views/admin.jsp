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


</head>
<body>
<div class="wrapper">
    <div class="sidebar" data-color="blue" data-image="/resources/img/sidebar-3.jpg">


        <div class="sidebar-wrapper">
            <div class="logo">
                <h4 class="simple-text">
                    Schedule Admin Page
                </h4>
            </div>

            <ul class="nav">
                <li class="active">
                    <a href="/admin">
                        <i class="pe-7s-home"></i>
                        <p>Home page</p>
                    </a>
                </li>
                <li>
                    <a href="/subjectPage">
                        <i class="pe-7s-note2"></i>
                        <p>CRUD Subjects</p>
                    </a>
                </li>
                <li>
                    <a href="/teacherPage">
                        <i class="pe-7s-bookmarks"></i>
                        <p>CRUD Teachers</p>
                    </a>
                </li>
                <li>
                    <a href="/groupPage">
                        <i class="pe-7s-users"></i>
                        <p>CRUD Groups</p>
                    </a>
                </li>
                <li>
                    <a href="/userGroupPage">
                        <i class="pe-7s-id"></i>
                        <p>Edit group index</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="">Admin Dashboard</a>
                </div>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a class="btn btn-outline-primary" href="/main" role="button">
                                User profile
                            </a>
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
                                <h4 class="title">Add Schedule Day</h4>
                                <p class="category">BE CAREFUL WITH REPETITIONS</p>
                            </div>
                            <div class="content">
                                <form action="/addSchedule" method="post">
                                    <div class="form-group col-md-4">
                                        <p class="category">Time:</p>
                                    <select name="time" required class="form-control">
                                        <option value="8:00">8:00</option>
                                        <option value="9:00">9:00</option>
                                        <option value="10:00">10:00</option>
                                        <option value="11:00">11:00</option>
                                        <option value="12:00">12:00</option>
                                    </select>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <p class="category">Day of Week:</p>
                                    <select name="week" required class="form-control">
                                        <option value="mon">Monday</option>
                                        <option value="tue">Tuesday</option>
                                        <option value="wed">Wednesday</option>
                                        <option value="thu">Thursday</option>
                                        <option value="fri">Friday</option>
                                        <option value="sat">Saturday</option>
                                    </select>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <p class="category">Type of Class:</p>
                                    <select name="clas" required class="form-control">
                                        <c:forEach var="clas" items="${classes}">
                                            <option value="${clas.id}">${clas.classType}</option>
                                        </c:forEach>
                                    </select>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <p class="category">Group name:</p>
                                    <select name="group" required class="form-control">
                                        <c:forEach var="group" items="${groups}">
                                            <option value="${group.id}">${group.groupName}</option>
                                        </c:forEach>
                                    </select>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <p class="category">Subject:</p>
                                    <select name="subject" required class="form-control">
                                        <c:forEach var="subject" items="${subjects}">
                                            <option value="${subject.id}">${subject.subjectName}</option>
                                        </c:forEach>
                                    </select>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <p class="category">Teacher:</p>
                                    <select name="teacher" required class="form-control">
                                        <c:forEach var="teacher" items="${teachers}">
                                            <option value="${teacher.id}">${teacher.lname} ${teacher.fname}</option>
                                        </c:forEach>
                                    </select>
                                    </div>
                                    <input type="submit" value="submit" class="btn btn-primary" />
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                </form>
                            </div>
                        </div>
                    </div>

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
                                            <form action="/admin" method="get">
                                                <p class="category">Try Search by teacher or group:</p>
                                                <input type="search" placeholder="Search..." class="form-control" name="query"/>
                                                <br>
                                                <input type="submit" class="btn btn-primary">
                                            </form>
                                        </div>
                                    </div>
                                </div>


                    <c:if test="${sch!=null}">
                    <div class="content">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="card">

                                        <div class="header">
                                            <h4 class="title">Show Schedules</h4>
                                            <p class="category">Your group:</p>
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
                                                                        <p>${day.classType.classType} ${day.time} - ${day.weekDay} (${day.id})</p>
                                                                        <form action="/deleteSchedule" method="post" style="margin: 0px;padding: 0px;">
                                                                            <input type="hidden" name="id" value="${day.id}"/>
                                                                            <button type="submit" class="btn btn-danger"> Delete </button>
                                                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                                        </form>
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
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    </c:if>


                </div>
            </div>
        </div>


        <footer class="footer">
            <div class="container-fluid">
                <nav class="pull-left">
                    <ul>
                        <li>
                            <a href="#">
                                Home
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                About us
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Help
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Donate
                            </a>
                        </li>
                    </ul>
                </nav>
                <p class="copyright pull-right">
                    &copy; <script>document.write(new Date().getFullYear())</script> Anvar HunT, made without knowledge of Bootstrap :D
                </p>
            </div>
        </footer>

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

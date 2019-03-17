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

        <!--
            Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
            Tip 2: you can also add an image using data-image tag
        -->

        <div class="sidebar-wrapper">
            <div class="logo">
                <h4 class="simple-text">
                    Schedule Admin Page
                </h4>
            </div>

            <ul class="nav">
                <li>
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
                <li class="active">
                    <a href="/groupPage">
                        <i class="pe-7s-users"></i>
                        <p>CRUD Group</p>
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
                                <h4 class="title">Edit current group</h4>
                                <p class="category">Your group ${group.groupName}</p>
                            </div>
                            <div class="content">

                                <form action="/editGroupPost" method="post">
                                    <input type="hidden" value="${group.id}" name="id">
                                    <div class="form-group">
                                        <label>Group name: </label>
                                        <input type="text" name="name" class="form-control" value="${group.groupName}"/>
                                    </div>

                                    <button type="submit" class="btn btn-primary "> Change </button>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                </form>

                            </div>
                        </div>
                    </div>



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


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <script src="../js/jquery-1.11.3.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" href="../css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript">
        $(function () {
            var url = "/IndexServlet";
            $.post(url,{"method":"getcategories"},function (data) {
                $.each(data , function (index, element) {
                    $("#menu").append("<li><a href='/ProductServlet?method=findByCid&cid="+element.cid+"'>"+ element.cname +"</a></li>");
                })
            });
        });
        
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-3"><img src="../img/logo_new1.jpg" height="8%"></div>
        <div class="col-md-5"><img src="../img/header.png" ></div>
        <div class="col-md-4" style="padding-top: 20px">
            <ol class="list-inline">
                <c:if test="${empty user}">
                    <li><a href="/UserServlet?method=loginUI">登录</a></li>
                    <li><a href="/UserServlet?method=registerUI">注册</a></li>
                </c:if>
                <c:if test="${not empty user}">
                    <li><a href="#">欢迎您,${user.name}</a></li>
                    <li><a href="#">我的订单</a></li>
                    <li><a href="/UserServlet?method=logout">注销</a></li>
                </c:if>
            </ol>
        </div>
    </div>

    <%--2 导航栏--%>
    <div class="row">
        <div class="col-md12">
            <nav class="navbar navbar-default navbar-inverse">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="/IndexServlet">首页</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav" id="menu">
                            <c:forEach items="${categories}" var="category">
                                <li><a href="#">${category.cname}</a></li>
                            </c:forEach>
                        </ul>
                        <form class="navbar-form navbar-right">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Search">
                            </div>
                            <button type="submit" class="btn btn-default">Submit</button>
                        </form>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
        </div>
    </div>
</div>
</body>
</html>



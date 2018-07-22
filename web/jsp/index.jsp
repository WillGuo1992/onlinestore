<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/10/010
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
<%--3.滑动片--%>
    <div class="row">
        <div class="col-md12">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="${pageContext.request.contextPath}/img/ad/1.jpg" alt="...">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/img/ad/2.jpg" alt="...">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/img/ad/3.jpg" alt="...">
                        <div class="carousel-caption">
                        </div>
                    </div>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>


    <%--4 热门商品--%>
    <div class="row">
        <div class="col-md12">
            <h2>热门商品
            <img src="${pageContext.request.contextPath}/img/title2.jpg">
            </h2>
        </div>
    </div>

    <%--热门商品--%>
    <div class="row">
        <div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
            <img src="${pageContext.request.contextPath}/products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
        </div>
        <div class="col-md-10">
            <div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
                <a href="#">
                    <img src="${pageContext.request.contextPath}/products/hao/middle01.jpg" width="100%" height="200px" style="display: inline-block;">
                </a>
            </div>

            <c:forEach items="${hotProducts}" var="product">
                <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                    <a href="${pageContext.request.contextPath}/ProductServlet?method=findbyid&pid=${product.pid}">
                        <img src="${product.pimage}" width="130" height="130" style="display: inline-block;">
                    </a>
                    <p><a href="${pageContext.request.contextPath}/ProductServlet?method=findbyid&pid=${product.pid}" style='color:#666'>${product.pname}</a></p>
                    <p><font color="#E4393C" style="font-size:16px">&yen;${product.shop_price}</font></p>
                </div>
            </c:forEach>

        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-12">
            <img src="${pageContext.request.contextPath}/products/hao/ad.jpg" width="100%"/>
        </div>
    </div>


    <%--最新商品--%>
    <div class="row">
        <div class="col-md12">
            <h2>最新商品
                <img src="${pageContext.request.contextPath}/img/title2.jpg">
            </h2>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
            <img src="${pageContext.request.contextPath}/products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
        </div>
        <div class="col-md-10">
            <div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
                <a href="#">
                    <img src="${pageContext.request.contextPath}/products/hao/middle01.jpg" width="100%" height="200px" style="display: inline-block;">
                </a>
            </div>
            <c:forEach items="${newProducts}" var="product">
                <div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
                    <a href="${pageContext.request.contextPath}/ProductServlet?method=findbyid&pid=${product.pid}">
                        <img src="${product.pimage}" width="130" height="130" style="display: inline-block;">
                    </a>
                    <p><a href="${pageContext.request.contextPath}/ProductServlet?method=findbyid&pid=${product.pid}" style='color:#666'>${product.pname}</a></p>
                    <p><font color="#E4393C" style="font-size:16px">&yen;${product.shop_price}</font></p>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

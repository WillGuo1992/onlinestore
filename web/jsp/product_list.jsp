<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/14/014
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品分类</title>
    <link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.5.5.2/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.5.5.2/themes/icon.css">
    <script type="text/javascript" src="../js/jquery-easyui-1.5.5.2/jquery.min.js"></script>
    <script type="text/javascript">
        var $180 = $;
    </script>
    <script type="text/javascript" src="../js/jquery-easyui-1.5.5.2/jquery.easyui.min.js"></script>

    <script type="text/javascript">
        $180(function() {
            $180("#pp").pagination({
                total: ${pageBean.totalRecord},
                pageSize: ${pageBean.pageSize},
                pageNumber:${pageBean.pageNumber},
                pageList:[12,18,24],
                onSelectPage:function (pageNumber, pageSize) {
                    window.location.href = "/ProductServlet?method=findByCid" +
                        "&cid="+${pageBean.data[0].cid}+
                    "&pageNumber="+pageNumber+"&pageSize="+pageSize;
                }
            });

            var url = "/ProductServlet";
            var paras = {"method":"getCnamebyCid","cid":"${pageBean.data[0].cid}"}
            $.post(url,paras,function (data) {
                $("#categoryName").text(data.cname);
            });
        });
    </script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <ol class="breadcrumb">
                <li><a href="/IndexServlet">首页</a></li>>
                <li><a id="categoryName" href="#">###</a></li>
            </ol>
        </div>
    </div>
    <div class="row">
        <c:forEach items="${pageBean.data}" var="product">
            <div class="col-md-2" style="height: 260px;">
                <a href="/ProductServlet?method=findbyid&pid=${product.pid}">
                    <img src="${product.pimage}" width="100%">
                    <div align="center"><font color="#5f9ea0">${product.pname}</font></div>
                    <div align="center"><font color="red">商城价:￥${product.shop_price}元</font></div>
                </a>
            </div>
        </c:forEach>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="easyui-panel">
                <div id="pp" class="easyui-pagination" data-options="total:114"></div>
            </div>
        </div>
    </div>

</div>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/17/017
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的订单</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>


<div class="container">
    <div class="row">
        <div style="margin:0 auto; margin-top:10px;width:950px;">
            <strong>我的订单</strong>
            <table class="table table-bordered">
                <c:forEach items="${orders}" var="order">
                <tbody>
                <tr class="success">
                    <th colspan="5">订单编号:${order.oid}</th>
                </tr>
                <tr class="warning">
                    <th>图片</th>
                    <th>商品</th>
                    <th>价格</th>
                    <th>数量</th>
                    <th>小计</th>
                </tr>
                <c:forEach items="${order.list}" var="orderitem">
                    <tr class="active">
                        <td width="60" width="40%">
                            <img src="${orderitem.product.pimage}" width="70" height="60">
                        </td>
                        <td width="30%">
                            <a target="_blank">${orderitem.product.pname}</a>
                        </td>
                        <td width="20%">
                            ￥${orderitem.product.shop_price}
                        </td>
                        <td width="10%">
                                ${orderitem.count}
                        </td>
                        <td width="15%">
                            <span class="subtotal">￥${orderitem.subtotal}</span>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

<%@ page import="domain.Order" %>
<%@ page import="domain.OrderItem" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/15/015
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div style="margin:0 auto;margin-top:10px;width:950px;">
                <strong>订单详情</strong>
                <%
                    Order order =(Order) request.getSession().getAttribute("order");
//                    OrderItem item = (OrderItem) order.getList().get(0);
                    System.out.println(order.getList().size());

                %>
                <table class="table table-bordered">
                    <tbody>
                    <tr class="warning">
                        <th colspan="5">订单编号:${order.oid}</th>
                    </tr>
                    <tr class="warning">
                        <th>图片</th>
                        <th>商品</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>小计</th>
                    </tr>
                    <c:forEach items="${order.list}" var="item">
                        <tr class="active">
                            <td width="60" width="40%">
                                <input type="hidden" name="id" value="22">
                                <img src="/${item.product.pimage}" width="70" height="60">
                            </td>
                            <td width="30%">
                                <a target="_blank">${item.product.pname}</a>
                            </td>
                            <td width="20%">
                                ￥${item.product.shop_price}
                            </td>
                            <td width="10%">
                                    ${item.count}
                            </td>
                            <td width="15%">
                                <span class="subtotal">￥${item.subtotal}</span>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <div style="text-align:right;margin-right:120px;">
                商品金额: <strong style="color:#ff6600;">￥${order.total }元</strong>
            </div>
    </div>
</div>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

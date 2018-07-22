<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/15/015
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div style="margin:0 auto; margin-top:10px;width:950px;">
                <strong style="font-size:16px;margin:5px 0;">购物车详情</strong>
                <table class="table table-bordered" style="vertical-align: central">
                    <tbody>
                    <tr class="warning">
                        <th>图片</th>
                        <th>商品名</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>小计</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${cart.map}" var="entryset">
                        <tr class="active">
                            <td width="60">
                                <img src="${pageContext.request.contextPath}/${entryset.value.product.pimage}" style="width: 60px">
                            </td>
                            <td width="30%">${entryset.value.product.pname}</td>
                            <td width="20%">￥${entryset.value.product.shop_price}</td>
                            <td width="10%">${entryset.value.count}</td>
                            <td width="15%">￥${entryset.value.itemTotal}</td>
                            <td width="15%"><a href="${pageContext.request.contextPath}/CartServlet?method=deleteOneItem&pid=${entryset.value.product.pid}">删除</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <div style="text-align: right; margin-right: 50px">
                    商品金额:<strong><font color="red" size="5">￥${cart.total}元</font></strong>
                </div>
                <div style="text-align:right;margin-top:10px;margin-right: 30px;">
                    <a href="${pageContext.request.contextPath}/CartServlet?method=deleteAll">清空购物车</a>
                    <input type="button" value="提交订单" style="background: url('${pageContext.request.contextPath}/img/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white; " onclick="window.location.href = '${pageContext.request.contextPath}/OrderServlet?method=saveorder';
						">
                </div>
            </div>

        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

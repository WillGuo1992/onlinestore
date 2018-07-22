<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
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
                                <img src="${pageContext.request.contextPath}/${item.product.pimage}" width="70" height="60">
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
    <hr>
    <form method="post" action="OrderServlet" id="orderForm">
        <input type="hidden" name="method" value="payOrder">
        <input type="hidden" name="oid" value="${order.oid}">
        <div class="row">
            <div class="col-md-12">
                <div style="margin:0 auto;margin-top:10px;width:950px;">
                    <div class="form-group">
                        <label for="address" class="col-md-1 control-label">地址</label>
                        <div class="col-md-5">
                            <input type="text" class="form-control" name="address" id="address"
                                   placeholder="请输入收货地址">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div style="margin:0 auto;margin-top:10px;width:950px;">

                    <div class="form-group">
                        <label for="name" class="col-md-1 control-label">收货人</label>
                        <div class="col-md-5">
                            <input type="text" class="form-control" name="name" id="name"
                                   placeholder="请输入收货人">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div style="margin:0 auto;margin-top:10px;width:950px;">

                    <div class="form-group">
                        <label for="telephone" class="col-md-1 control-label">电话</label>
                        <div class="col-md-5">
                            <input type="text" class="form-control" name="telephone" id="telephone"
                                   placeholder="请输入收货电话">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <hr>
        <div class="row">
            <div class="col-md-12">
                <div style="margin-top:5px;margin-left:100px;">
                    <strong>选择银行：</strong>
                    <p>
                        <br/>
                        <input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked"/>工商银行
                        <img src="${pageContext.request.contextPath}/img/bank_img/icbc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>中国银行
                        <img src="${pageContext.request.contextPath}/img/bank_img/bc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>农业银行
                        <img src="${pageContext.request.contextPath}/img/bank_img/abc.bmp" align="middle"/>
                        <br/>
                        <br/>
                        <input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>交通银行
                        <img src="${pageContext.request.contextPath}/img/bank_img/bcc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="pd_FrpId" value="PINGANBANK-NET"/>平安银行
                        <img src="${pageContext.request.contextPath}/img/bank_img/pingan.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>建设银行
                        <img src="${pageContext.request.contextPath}/img/bank_img/ccb.bmp" align="middle"/>
                        <br/>
                        <br/>
                        <input type="radio" name="pd_FrpId" value="CEB-NET-B2C"/>光大银行
                        <img src="${pageContext.request.contextPath}/img/bank_img/guangda.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C"/>招商银行
                        <img src="${pageContext.request.contextPath}/img/bank_img/cmb.bmp" align="middle"/>
                    </p>
                    <hr/>
                    <p style="text-align:right;margin-right:100px;">
                        <a href="javascript:document.getElementById('orderForm').submit();">
                            <img src="${pageContext.request.contextPath}/img/finalbutton.gif" width="204" height="51"
                                 border="0"/>
                        </a>
                    </p>
                    <hr/>
                </div>
            </div>
        </div>
    </form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

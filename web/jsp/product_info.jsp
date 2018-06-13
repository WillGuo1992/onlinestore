<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/13/013
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
    <script src="../js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var url = "/ProductServlet";
            var paras = {"method":"getCnamebyPid","pid":"${product.pid}"}
            $.post(url,paras,function (data) {
                $("#categoryName").text(data.cname);
                $("#categoryName").attr("href","/ProductServlet?method=getByCid&cid="+data.cid);
            });
        });
    </script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="row">
                <div class="col-md-12">
                    <div style="border: 1px solid #e4e4e4;width:100%;margin-bottom:10px;margin:0 auto;padding:10px;margin-bottom:10px;">
                        <a href="/IndexServlet">首页</a>>
                        <a href="#" id="categoryName">填充</a>>
                        <a href="#">${product.pname}</a>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <img src="${product.pimage}" width="100%"></img>
                </div>
                <div class="col-md-6">
                    <div class="row">
                        <div class="col-md-12">
                            <h1><b>${product.pname}</b></h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <h5>编号:${product.pid}</h5>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                           本平台价格	&ensp;<font color="red" size="5">￥${product.shop_price}元</font>  	&ensp;	&ensp;
                               参考价	&ensp;<span style="text-decoration-line: line-through">${product.market_price}元 </span>
                        </div>
                    </div>



                    <div class="row">
                        <div class="col-md-12" style="padding:10px;border:1px solid #e7dbb1;width:100%;margin:15px 0 10px 0;;background-color: #fffee6;">
                            <div style="border-bottom: 1px solid #faeac7;margin-top:20px;padding-left: 10px;">
                                <h4>商品描述</h4>
                                ${product.pdesc}
                                <br>	&ensp;	&ensp;
                            </div>
                            <div style="margin:20px 0 10px 0;;text-align: center;">
                                购买数量:<input id="quantity" value="1" type="text" />
                                <br>
                                <a href="#">
                                    <input value="加入购物车" type="button" style="margin-top: 20px;background: url('../img/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0);height:36px;width:127px;">
                                </a>
                            </div>
                        </div>
                    </div>

                </div>
            </div>


        </div>
        <div class="col-md-1"></div>
    </div>
</div>


<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>

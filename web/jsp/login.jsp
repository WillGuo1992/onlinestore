<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/12/012
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>会员登录</title>
    <script type="text/javascript">
        function getnewPic() {
            var img = $("#checkcode2");
            var src = img.attr("src");
            img.attr("src", chgUrl(src));
        }

        // 时间戳
        // 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
        function chgUrl(url) {
            var timestamp = (new Date()).valueOf();
            url = url + "&stamp=" + timestamp;
            return url;
        }
    </script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container" style="background: url('../img/loginbg.jpg')">
    <div class="row">
        <div class="col-md-7"></div>
        <div class="col-md-5"
             style="width:440px;border:1px solid #E7E7E7;padding:20px 0 20px 30px;border-radius:5px;margin-top:60px; margin-bottom: 60px;background:#fff;">
            <span><font color="#6495ed" size="5">会员登录</font>USER LOGIN</span>
            <form class="form-horizontal" style="margin-top: 10px;" action="/UserServlet?method=login" method="post">
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="username" name="username" placeholder="用户名" value="${cookie.autousername.value}"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" id="password" name="password"
                               placeholder="密码"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label for="checkcode" class="col-sm-2 control-label">验证码</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="checkcode" name="checkcode"
                               placeholder="验证码"></input>
                    </div>
                    <div class="col-sm-3">
                        <img id="checkcode2" src="/UserServlet?method=getCheckCodePic"
                             style="width: 100%; padding-top: 5px" onclick="getnewPic()" alt="点击更换一张"></img>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-4">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="autologin" ${not empty cookie.autologincookie ? "checked='checked'":""}>自动登录
                            </label>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="noteusername" ${not empty cookie.autousername ? "checked='checked'":""}>记住用户名
                            </label>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" width="100" value="登录" name="submit"
                               style="background: url('../img/register.gif'); height: 35px;width: 100px; color: white">
                    </div>
                </div>

                <div class="form-group"></div>
                <div class="form-group"></div>
            </form>
            <font color="red">${msg}</font>
        </div>
    </div>


</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

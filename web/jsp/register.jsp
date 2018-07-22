<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/11/011
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script type="text/javascript">
        function getnewPic() {
            var img = $("#checkcode2");
            var src = img.attr("src");
            img.attr("src",chgUrl(src));
        }
        // 时间戳
        // 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
        function chgUrl(url) {
            var timestamp = (new Date()).valueOf();
            url = url + "&stamp=" + timestamp;
            return url;
        }

        function checkusername() {
            var username = $("#username").val();
            var str = username
            var data={"username":username};
            $.post("UserServlet?method=checkUsername",data,function (data) {
                if (data!=null){
                    $("#msg").text(data);
                } else {
                    $("#msg").text("");
                }
            })
        }

        function checkpassword() {
            var password = $("#password").val();
            var repassword = $("#repassword").val();
            if(password!=repassword){
                $("#msg").text("两次密码不相等");
            } else {
                $("#msg").text("");
            }
        }
    </script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container" style="background: url('${pageContext.request.contextPath}/img/regist_bg.jpg');">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8" style="background: #fff; padding: 40px 80px ; margin: 30px; border: 7px solid #ccc; " >
            <span><font color="#6495ed" size="5">会员注册</font>USER REGISTER</span>
            <form class="form-horizontal" style="margin-top: 10px " action="${pageContext.request.contextPath}/UserServlet?method=register" method="post">
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="username" name="username" placeholder="用户名" onblur="checkusername()" n></input>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label for="repassword" class="col-sm-2 control-label">确认密码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="repassword" name="repassword" placeholder="请再次输入密码" onblur="checkpassword()"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="email" name="email" placeholder="Email"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">姓名</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label  class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-10">
                        <div class="radio-inline">
                            <label>
                                <input type="radio" name="sex" id="man" value="男">男
                            </label>
                        </div>
                        <div class="radio-inline">
                            <label>
                                <input type="radio" name="sex" id="woman" value="女">女
                            </label>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="birthday" class="col-sm-2 control-label">出生日期</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" id="birthday" name="birthday"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label for="telephone" class="col-sm-2 control-label">电话</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="telephone" name="telephone" placeholder="请输入电话"></input>
                    </div>
                </div>

                <div class="form-group">
                    <label for="checkcode" class="col-sm-2 control-label">验证码</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="checkcode" name="checkcode" placeholder="请输入验证码"></input>
                    </div>
                    <div class="col-sm-1"></div>
                    <div class="col-sm-3">
                        <img id="checkcode2" src="UserServlet?method=getCheckCodePic" style="width: 100%; padding-top: 5px" onclick="getnewPic()" alt="点击更换一张" ></img>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" width="100" value="注册" name="submit" style="background: url('${pageContext.request.contextPath}/img/register.gif'); height: 35px;width: 100px; color: white">
                        <input type="reset" width="100" value="清空" style="background: url('${pageContext.request.contextPath}/img/register.gif'); margin-left: 50px;height: 35px;width: 100px; color: white">
                    </div>
                </div>

            </form>
            <div align="center">
                <font color="red" size="5"><span id="msg"></span></font>
            </div>

        </div>
        <div class="col-md-2"></div>
    </div>

</div>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>



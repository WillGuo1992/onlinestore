<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/18/018
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台首页</title>
</head>
<frameset rows="103,*,43" frameborder=0 border="0" framespacing="0" >
    <frame src="/jsp/admin/top.jsp"  scrolling="NO" noresize>
    <frameset cols="15%,*" frameborder=0 border="0" framespacing="0">
        <frame src="/jsp/admin/left.jsp" scrolling="NO" noresize>
        <frame src="/jsp/admin/welcome.jsp" name="mainFrame" id="mainFrame" scrolling="NO" noresize>
    </frameset>
    <frame src="/jsp/admin/buttom.jsp" scrolling="NO" noresize>
</frameset>

</html>

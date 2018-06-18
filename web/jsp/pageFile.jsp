<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%--分页显示的开始 --%>
    	<div style="text-align:center">
			第${page.pageNumber}页/共${page.totalPage}页
    		<a href="${page.url}&num=1">首页</a>
    		<a href="${page.url}&num=${page.prePageNum}">上一页</a>
    		<a href="${page.url}&num=${page.nextPageNum}">下一页</a>
    		<a href="${page.url}&num=${page.totalPage}">末页</a>

    	</div>
    	<%--分页显示的结束--%>

<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String name= (String)request.getAttribute("USERNAME");

if(name==null){
	Cookie[] cArray = request.getCookies();
		if(cArray!=null){
			for(Cookie c:cArray){
				if("USERNAME".equals(c.getName())){
					name =URLDecoder.decode(c.getValue());
				}
			}
		}
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'countryList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
	<script type="text/javascript">
		function dele(id){
			$.get("country/deleteCountry.do?id="+id,function(data){
				if("success"==data.result){
					alert("删除成功");
					window.location.reload();
				}else{
					alert("删除失败");
				}
			});
		}
	</script>
  </head>
  
  <body>
  	您好：<%=name %>
  	<br>
    <form action="country/findCountryAndLanguage.do" id="listform" method="post">
    	请输入要查询的国家：<input type="text" name="name">
    	请输入要查询的语言：<input type="text" name="language">
    	<input type="submit" value="查询">
    </form>
    	 <a href="country/preAdd.do">添加</a>
    	<table border="1px">
    		<tr>
    			<td>国家</td>
    			<td>语言</td>
    			<td>操作</td>
    		</tr>
    		<c:if test="${!empty countryList}">
    			<c:forEach var="coun" items="${countryList }">
    				<tr>
    					<td>${coun.name}</td>
    					<td>${coun.language}</td>
    					<td>
    						<a href="country/preUpdate.do?id=${coun.id}">修改</a>
    						<a href="javascript:dele('${coun.id}')">删除</a>
    						<input type="hidden" value="${coun.id}" name="id">
    					</td>
    				</tr>
    			</c:forEach>
    		</c:if>
    	</table>
  </body>
</html>

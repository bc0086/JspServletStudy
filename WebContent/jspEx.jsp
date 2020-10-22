<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage = "errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script>
$(function(){
	
});
</script>
</head>
<body>
	<%!
		String adminId;
		String adminPw;
		
		String imgDir;
		String testServerIP;
		
		String str;
	%>
	
	<%
		adminId = config.getInitParameter("adminId");
		adminPw = config.getInitParameter("adminPw");
	%>
	<!-- config대신getServletConfig로 가져와도 같은 결과이다. -->
	<p>adminId : <%= adminId %></p>
	<p>adminPw : <%= adminPw %></p>
	
	<!-- context-param의 값을 가져오려면 application객체를 불러야한다. -->
	<%
		imgDir = application.getInitParameter("imgDir");
		testServerIP = application.getInitParameter("testServerIP");
	%>
	
	<p>imgDir : <%= imgDir %></p>
	<p>testServerIP : <%= testServerIP %></p>
	
	<%
		application.setAttribute("connectedIP", "162.62.58.23");
		application.setAttribute("connectedUser", "hong");
	%>
	
	<!-- exception 객체 -->
	<%
		out.print(str.toString());
	%>
</body>
</html>
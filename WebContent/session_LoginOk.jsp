<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<!-- session이 넘어왔을 것이다. 확인해보자. -->
	<%
		session = request.getSession();
		out.print("memberId : " + session.getAttribute("memberId") + "<br>");
	%>
	
	<form action="session_LogoutCon" method="post">
		<input type="submit" value="logout" />
	</form>
</body>
</html>
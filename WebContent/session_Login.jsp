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
	<!-- 기존의 세션 유무 -->
	<%
		if(session.getAttribute("memberId") != null)
			response.sendRedirect("session_LoginOk.jsp");
	%>
	
	<form action="session_LoginCon" method="post">
		ID : <input type="text" name="mID" > <br />
		PW : <input type="password" name="mPW" > <br />
		<input type="submit" value="login" />
	</form>
</body>
</html>
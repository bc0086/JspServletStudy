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
	<!-- <form action="encodingSignUp.jsp" method="post"> -->
	<form action="encodingSignUp.jsp" method="get">
		<!-- get방식일때는 server.xml에서 수정하자. -->
		
		이름 : <input type="text" name="m_name" /> <br />
		별명 : <input type="text" name="m_nickname" /> <br />
		<input type="submit" value="sign up" />
	</form>
</body>
</html>
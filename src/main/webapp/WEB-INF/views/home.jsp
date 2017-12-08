<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello world!</h1>

	<p> <a href="${pageContext.request.contextPath}/check"> 학기별 이수 학점 조회</a></p>
	<p> <a href="${pageContext.request.contextPath}/check2"> 이수 구분별 학점 조회</a></p>
	<p> <a href="${pageContext.request.contextPath}/createoffer"> 수강 신청하기</a></p>
	<p> <a href="${pageContext.request.contextPath}/future"> 수강 신청 조회</a></p>
	<%-- <p> <a href="${pageContext.request.contextPath}/offers"> 수강 신청 조회</a></p> --%>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>


<h1>Hellod!</h1>

	<table border="1">
	<caption>나의 강의들</caption>
		<thead> 
			<tr><th>년도</th>	 <th>학기</th> <th>이수학점</th> <th>상세보기</th> 
		</thead>
		
		<tbody>
			<c:forEach var="offer" items="${offer}"> 
				<tr><th><c:out value="${offer.year}"></c:out></th>	<th><c:out value="${offer.term}"></c:out></th> <th><c:out value="${offer.grade}"></c:out></th> <th><a href="${pageContext.request.contextPath}/link?year=${offer.year}&term=${offer.term}">링크</a></th></tr>
		
			</c:forEach>
		</tbody>
	</table>
	
	
<%-- 	
	<c:forEach var="offer" items="${offer}"> 
		<p>
			<c:out value="${offer.year}"></c:out>
		</p>
	</c:forEach> --%>
	
	
</body>
</html>
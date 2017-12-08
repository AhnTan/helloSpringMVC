<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
<body>

	<table border="1">
	<caption>이수 구분별 학점내역</caption>
		<thead> 
			<tr>
				<c:forEach var="offers" items="${offers}"> 
					<th><c:out value="${offers.division}"></c:out></th>
				</c:forEach>
				<th>총점</th>
			</tr>
		</thead>
		
		<tbody>
			<tr>
				<c:forEach var="offers" items="${offers}"> 
				<!-- c:set은 총 합을 구하기 위해서 선언해준 sum변수 -->
					<th><c:out value="${offers.grade}"></c:out> <c:set var= "sum" value="${sum + offers.grade}"/> </th>
				</c:forEach>
				
				<td> <c:out value="${sum}"/> </td>
			</tr>
		</tbody>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<caption>2018년도 1학기 예정 신청 과목</caption>
		<thead> 
			<tr><th>수강년도</th>	<th>학기</th>  <th>교과코드</th> <th>교과목명</th> <th>구분</th> <th>학점</th> 
		</thead>
		
		<tbody>
			<c:forEach var="offer" items="${offer}"> 
				<tr>
					<th><c:out value="${offer.year}"></c:out></th>	
					<th><c:out value="${offer.term}"></c:out></th> 
					<th><c:out value="${offer.subject}"></c:out></th>
					<th><c:out value="${offer.code}"></c:out></th>
					<th><c:out value="${offer.division}"></c:out></th>
					<th><c:out value="${offer.grade}"></c:out></th>
				</tr>
		
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
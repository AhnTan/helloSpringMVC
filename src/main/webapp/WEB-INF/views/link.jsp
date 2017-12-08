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
	<caption>해당 과목 리스트</caption>
		<thead> 
			<tr><th>Subject</th> <th>Code</th> <th>division</th></tr> 
		</thead>
		
		<tbody>
			<c:forEach var="offer" items="${offer}"> 
				<tr><th><c:out value="${offer.subject}"></c:out></th> <th><c:out value="${offer.code}"></c:out></th> <th><c:out value="${offer.division}"></c:out></th></tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
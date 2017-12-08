<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

	<sf:form method ="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="offer">
	
	<table class="formtable">
		<tr> <td class="label"> year:  </td> <td> <sf:input class="control" type="text" path="year"/> <br/> 
		<sf:errors class="error" path="year" /></td> </tr>
		<tr> <td class="label"> term:  </td> <td> <sf:input class="control" type="text" path="term"/>
		<sf:errors class="error" path="term" /> </td> </tr>
		<tr> <td class="label"> subject:  </td> <td> <sf:textarea class="control" type="text" path="subject" />
		<sf:errors class="error" path="subject" /> </td> </tr>
		<tr> <td class="label"> code:  </td> <td> <sf:textarea class="control" type="text" path="code" />
		<sf:errors class="error" path="code" /> </td> </tr>
		<tr> <td class="label"> division:  </td> <td> <sf:textarea class="control" type="text" path="division" />
		<sf:errors class="error" path="division" /> </td> </tr>
		<tr> <td class="label"> grade:  </td> <td> <sf:input class="control" type="text" path="grade"/> <br/> 
		<sf:errors class="error" path="grade" /></td> </tr>
		
		<tr> <td class="label">   </td> <td> <input class="control" type="submit" value="새 제안"/> </td> </tr>
		
	<%-- 	<tr> <td class="label"> division:  </td> <td> <sf:textarea class="control" path="division" rows="3" cols="3" />
		<sf:errors class="error" path="division" /> </td> </tr> --%>
	</table>	
	</sf:form>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"/>
<title>Insert title here</title>
</head>
<body>
	<h1>El nombre es:<c:out value="${userName}"/><br>
		El correo es:<c:out value="${userEmail}"/><br>
		la fecha es:<c:out value="${userPassword}"/>
	</h1>
	
</body>
</html>
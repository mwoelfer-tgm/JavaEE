<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>all capitals</title>
</head>
<body>

<h1 style="text-align: center"> Politische Bildung JSP </h1>
<h2> all capitals</h2>
<div style="font-size: 1.5em">
<c:forEach var="hs" items="${requestScope['list']}"> 
	<c:out value="${hs}"/> </br>

</c:forEach>

</br> </br>
<a href="index.jsp"> Back to the main page... </a>
</div>
</body>
</html>
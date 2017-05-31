<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>capital</title>
</head>
<body>
<h1 style="text-align: center"> Politische Bildung JSP </h1>

<h2> capital</h2>

<%-- Es wird eine einfach Ausgabe gemacht, wobei im Servlet zwei Attribute im requestScope gesetzt wurden
und zwar 'state' und 'capital'. Diese Variablen werden hier simpel ausgelesen und ausgegeben --%>
Die Hauptstadt von <c:out value="${requestScope['state']}"/> lautet <c:out value="${requestScope['capital']}"/>!

</br> </br>
<a href="index.jsp"> Back to the main page... </a>
</body>
</html>
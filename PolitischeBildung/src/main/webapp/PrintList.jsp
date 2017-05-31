<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Idee hier war es eine Variable zu setzen, um die Ausgaben leichter zu machen. Dies funktioniert indem im Servlet
eine Variable gesetzt wurde 'calledBy', je nachdem ob die jsp aufgerufen wurde um Bundesländer oder Hauptstädte auszugeben.

Der Variable 'mode' wird entweder der wert "states" oder "capitals" zugewiesen um eine Ausgabe im Body bzw. title 
leichter zu machen--%>
<c:if test="${requestScope['calledBy'] == 'BL'}">
	<c:set var ="mode" value="states"/>
</c:if>
<c:if test="${requestScope['calledBy'] == 'HS'}">
	<c:set var ="mode" value="capitals"/>
</c:if>
<title>
<%-- Durch die Zuweisung vorhin kann nun ganz einfach der Modus ausgegegeben werden --%>
all <c:out value="${mode}"/>
</title>
</head>
<body>

<h1 style="text-align: center"> Politische Bildung JSP </h1>
<h2> all <c:out value="${mode}"/> </h2>

<div style="font-size: 1.5em">

<%-- Im servlet wurde eine Liste mit entweder Hauptstädten oder Bundesländern als Attribut gespeichert, welche man durch
den requestScope auslesen kann

Anschließend wird mit forEach durch diese Liste iteriert und es wird jedes item aus dieser Liste ausgegeben --%>
<c:forEach var="item" items="${requestScope['list']}"> 
	<c:out value="${item}"/> </br>

</c:forEach>

</div>
</br> </br>
<a href="index.jsp"> Back to the main page... </a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>choose capital</title>
</head>
<body>

<h1 style="font-align: center"> W&auml;hle ein Bundesland aus </h1>

Lerne Dein Land kennen <br>

Bundesland:
<form action="Select.do">
	<select name="secondDropDown">
		<%-- Im servlet wurde die liste mit den Bundesländern wieder als Attribut gespeichert und wird hier durchiteriert--%>
		<c:forEach var="item" items="${requestScope['list']}"> 
			<%-- Aus jedem item aus dieser Liste entsteht dann ein <option> tag mit passender value und Text--%>
			<option value='${item}'><c:out value="${ item }"></c:out></option>
		</c:forEach>
	</select>
		
	<button type="submit"> Submit </button>
</form>

</br> </br>
<a href="index.jsp"> Back to the main page... </a>
</body>
</html>
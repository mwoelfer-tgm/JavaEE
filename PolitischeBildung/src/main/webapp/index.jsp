<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
		<title>Politische Bildung</title>
	</head>
	<body>
		<form action="Select.do" id="firstSelect">
			<select name="firstDropDown">
				<option value="HS1"> Alle Hauptst&auml;dte </option> 
				<option value="BL"> Alle Bundesl&auml;der </option>
				<option value="HS2"> Eine Hauptstadt </option>
			</select>
			
			<button type="submit"> Submit </button>
		</form>
	</body>
</html>
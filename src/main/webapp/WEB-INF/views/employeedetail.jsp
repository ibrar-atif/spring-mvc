<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome
${emp.name} ${name} ${emp.age}

<br/>
<br/>
<form:form  method="post" action="saveEmp" modelAttribute="emp">
Name : <form:input type="text" path="name" name="name"/>
<br/>

Age : <form:input type="text" path="age" name="age"/>
<form:button type="submit">Save</form:button>
</form:form>
</body>
</html>
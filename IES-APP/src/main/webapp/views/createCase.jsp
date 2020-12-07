<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><div align="center">
<h2>Creating Case</h2><br/><br/>

<form:form action="/createCase" method="post" modelAttribute="citizen">
		<table>
			<tr>
				<td>Application Id :</td>
				<td><form:input path="arNo" readonly="true"/>     </td>				
								
			</tr>

			<tr>
				<td> First Name :</td>
				<td><form:input path="firstName" readonly="true"/> </td>
			</tr>
			<tr>
				<td> First Name :</td>
				<td><form:input path="lastName" readonly="true"/> </td>
			</tr>
			<tr>
					<td>Gender :</td>
					<td><form:input path="gender" readonly="true"/></td>
							
			</tr>
			<tr>
					<td>SSN :</td>
					<td><form:input path="ssn" readonly="true"/></td>
							
			</tr>
			<tr>
					<td>Phone Number:</td>
					<td><form:input path="phoneNumber" readonly="true"/></td>
							
			</tr>
			

			<tr>
				<td>Email :</td>
				<td><form:input path="email" readonly="true"/></td>
						
			</tr>
					
			     <tr>
					
					    <td><input type="submit" value="Create Case" id="submitBtn"></td>
				
				</tr>
		
		</table><br><br>
	
	</form:form>
</div>


</body>
</html>
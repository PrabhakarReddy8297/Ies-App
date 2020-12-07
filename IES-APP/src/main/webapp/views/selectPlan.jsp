<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>
<script type="text/javascript">
$(document).ready(function()
		{
		    $('#planName').change(function(){			   		   
		       window.location.href = '/selectPlan?plan=' + $("#planName").val();
		    }); 
     
		});

</script>
</head>
<body>
<div align="center">
<h2>Select Plan</h2>

<form:form action="#" method="post" modelAttribute="dcplanObj">
<table>
<tr> 
   <td>Case Id : </td>
   <td><form:input path="caseId" readonly="true"/> </td>

</tr>
<tr> 
   <td>First Name : </td>
   <td><form:input path="firstName" readonly="true"/> </td>

</tr>
<tr> 
   <td>Last Name : </td>
   <td><form:input path="lastName" readonly="true"/> </td>

</tr>
<tr> 
   <td>Select Plan : </td>
   <td> 
    <form:select path="plan" id="planName">
     <form:option value="">-select-</form:option>
    <form:options items="${plans}" />
    </form:select>
   
   </td>

</tr>

</table>
<input type="submit" value="Next">

</form:form>
  </div>
</body>
</html>
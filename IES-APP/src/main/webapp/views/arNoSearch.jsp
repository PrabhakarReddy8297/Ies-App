<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		    $('#search').click(function(){			   		   
		       window.location.href = '/createCase?arNo=' + $("#arNo").val();
		    }); 
     
		});

</script>
</head>
<body>

<div align="center">
<h2>Creating Case</h2><br/><br/>
<font color="red">${errorMsg}</font><br/><br/>
<input type="text" name="arNo" id="arNo"  placeholder="Enter Application Number"> 
<input type="button" value="Search" id="search"></div>
</body>
</html>
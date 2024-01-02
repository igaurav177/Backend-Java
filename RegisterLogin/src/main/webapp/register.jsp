<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="RegForm" method="post">
	Name : <input type="text" name="name1"/> <br>
	Email : <input type="text" name="email1"/> <br>
	Password : <input type="password" name="pwd1"/> <br>
	Gender : <input type="radio" name="gender1" value="Male"/> Male <input type="radio" name="gender1" value="Femail"/> Female
	<br>
	City : <select name="city1">
			<option>select City </option>
			<option>Delhi</option>
			<option>Mumbai</option>
			<option>Banglore</option>
			<option>Pune</option>
			<option>Bihar</option>
			</select>  <br>
		<input type ="submit" value="Register"/>
	</form>
</body>
</html>
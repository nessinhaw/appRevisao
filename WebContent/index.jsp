<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Revisao Java</title>
	</head>
	<body>
		<h1>LOGIN</h1>
		
		<form action="/appRevisao/ServletController" type="POST">
			<p>
				<label for="Login">Login</label>
				<input type="text" id="Login" name="Login" />
			</p>
			<p>
				<label for="senha">Senha</label>
				<input type="password" id="senha" name="senha" />
			</p>
			
			<button type="submit">Logar</button>
		</form>
		
	</body>
</html>
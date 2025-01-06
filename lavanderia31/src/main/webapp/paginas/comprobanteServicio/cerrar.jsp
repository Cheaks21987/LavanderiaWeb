<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <script src='main.js'></script>
</head>

    <body onLoad="setTimeout('window.close()',0)">  holaaaa  aasdsa  <br>

	<input value="Mirar Havana" onclick="cerrar()" type="button">

    <script>
    var ventana_secundaria
    function cerrar(){
   
    ventana_secundaria.close();
    } 
    
    </script>
    
    <input type="button"
    
value="Cerrar esta ventana"
onclick="window.close();">
	

    <a href="javascript: closeWin.Click();">Cerrar</a>
</body>
</html>
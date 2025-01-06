<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<!-- header.jsp -->
<%@ include file="../header.jsp"%>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<style>
	h1 {color:blue; font-size:14px;}
	.btnDL{
	padding:10px 200px 10px 200px;
	color:white;
	background-color:RGB(22,124,233);
	font-size: 20px;
	}
	.btnDL:hover {
	  background-color: #4CAF50; /* Green */
	  color: white;
	}
	.btnDL:visited {
	  color: yellow;
	}
	</style>
<body>

	
	<!-- navbar.jsp -->
	<%@ include file="../navbar.jsp"%>
	<!-- END nav -->
	<div style="display: flex;justify-content: center;">
	<button data-link = "mantenimientoAtencionDomicilio.jsp"  class="btnDL" onclick="buscar2()">ATENCIÓN DOMICILIO</button>
	<button data-link = "mantenimientoAtencionLavanderia.jsp" class="btnDL">ATENCIÓN LAVANDERÍA</button>
	</div>
	
	<br>
	<iframe src="mantenimientoAtencionDomicilio.jsp" height="1000" width="100%" name="demo" id="capa">
	  <p>Su navegador no es compatible con iframes</p>
	</iframe>
	


<script>
	var botones = document.getElementsByTagName("button"),
    iframe = document.getElementById("capa"),
    sizeBotones = botones.length;
 
	for (i = 0; i < sizeBotones; i++){
    botones[i].addEventListener("click", function(){
        iframe.src = this.getAttribute("data-link");
    }, false);
	}
</script>
	<!-- footer.jsp -->
	<%@ include file="../footer.jsp"%>

</body>
</html>
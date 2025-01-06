<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<%@ include file="paginas/header.jsp" %>
  <body style="background-image: url('<%=request.getContextPath() %>/images/bg_2.png')">
     <div class="login-box" style="text-align:center;background-color: RGBA(0, 0, 128,0.7);">
      <h1 style="color:white;">Lavanderia UTP</h1>
      <h2 style="color:white;text-align:center;">Iniciar sesión</h2>
      <br><br>
      <form action="<%=request.getContextPath()%>/ServletLogin?action=buscar" method="post" >
        <!-- USERNAME INPUT -->   
        <input type="text" placeholder="Ingresar usuario" style="color:white;" name="usuario" required>
        <!-- PASSWORD INPUT -->
        <input type="password" placeholder="Ingresar contraseña" style="color:white;" name="contrasenia" required>
        <input type="submit" value="Iniciar sesión">

        <a href="<%=request.getContextPath() %>/paginas/login/loginRegistrar.jsp" style="color:white;">Registrarme</a>
      </form>
    </div>
  </body>
</html>
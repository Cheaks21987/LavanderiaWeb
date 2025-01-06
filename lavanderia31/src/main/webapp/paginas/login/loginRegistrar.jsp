<!DOCTYPE html>
<html>
  <!-- header.jsp -->
	<%@ include file="../header.jsp" %>
  <body style="background-image: url('<%=request.getContextPath() %>/images/bg_2.png')">

    <div class="login-box" style="text-align:center;background-color: RGBA(0, 0, 128,0.7);">
      <h2 style="color:white;text-align:center;">Nueva Usuario</h2><br>
      <form action="<%=request.getContextPath() %>/ServletLogin?action=guardarNuevo" method="post" >
        <!-- USERNAME INPUT -->   
        <input type="text" placeholder="Ingresar usuario" style="color:white;" name="usuario" required>
        <!-- PASSWORD INPUT -->
        <input type="password" placeholder="Ingresar contraseña" style="color:white;" name="contrasenia" required>
        <input type="submit" value="Registrar">
        
      </form>
    </div>
  </body>
</html>

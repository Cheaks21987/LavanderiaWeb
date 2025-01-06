<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

  <!-- header.jsp -->
	<%@ include file="../header.jsp" %>
  <body>
    <!-- navbar.jsp -->
 	<%@ include file="../navbar.jsp" %>
    <!-- END nav -->
    <%@ page import="pe.edu.universidad.proc.paginasServlet.*"%>
    <%@ page import="java.util.List"%>
    <%@ page import="pe.edu.universidad.entidades.jdbc.Persona"%>
    <%
    BOGestionPersona bo = new BOGestionPersona();
    List<Persona> lstDistrito = bo.consultarDistrito();
    %>
    <div class="hero-wrap hero-wrap-2" style="background-image: url('../images/bg_2.png'); background-attachment:fixed;">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text justify-content-center" data-scrollax-parent="true">
          <div class="col-md-8 ftco-animate text-center">
            <br>  <h1 class="mb-3 bread"><br>Mantenimiento Persona</h1>
          </div>
        </div>
      </div>
    </div>
    
    <section class="ftco-section contact-section ftco-degree-bg" aling="center">
      
      <div class="container formularioRegistrarPersona" >

          
          <center>
            <form action="<%=request.getContextPath() %>/ServletMantenimientoPersona?action=guardarModificado" method="post">
			<c:forEach items="${lstResultadosPersona}" var="persona">
			<div class="form-group">
                <input value="${persona.idPersona}" type="text" class="form-control" placeholder="idPersona" name="idPersona" required>
             </div>
             <div class="form-group">
                <input value="${persona.nombrePersona.trim()}" type="text" class="form-control" placeholder="Nombres" name="nombrePersona" required>
              </div>
              <div class="form-group">
                <input value="${persona.apellidoPaterno.trim()}" type="text" class="form-control" placeholder="Apellido Paterno" name="apellidoPaterno" required>
              </div>
              <div class="form-group">
                <input value="${persona.apellidoMaterno.trim()}" type="text" class="form-control" placeholder="Apellido Materno" name="apellidoMaterno" required>
              </div>
              <div class="form-group">
                <input value="${persona.dni}" type="text" onkeypress='return event.charCode >= 48 && event.charCode <= 57' class="form-control" placeholder="DNI" name="dni" minlength="8" maxlength="8" required>
             </div>
              <div class="form-group">
                <input value="${persona.direccion.trim()}" type="text" class="form-control" placeholder="Dirección" name="direccion" required>
              </div>
              <div class="form-group">
				<select name="idDistrito" class="form-control" placeholder="Distrito">
						<%
						for (Persona u : lstDistrito) {
						%>
						<option class="mb-4" value=<%=u.getIdDistrito()%>><%=u.getNombreDistrito()%></option>
						<%
						}
						%>
					</select>
				</div>
              <div class="form-group">
                <input value="${persona.correo.trim()}" type="email" class="form-control" placeholder="Correo" name="correo" required>
              </div>
              <div class="form-group">             
	              <select name="estadoTF" class="form-control">
				  <option value="T">Activo</option>
				  <option value="F">Desactivo</option>
				  </select>
              </div>
              <div class="form-group">
                <input value="${persona.tipo.trim()}" type="text" class="form-control" placeholder="Tipo" name="tipo" required>
              </div>
              <div class="form-group">
               Edad
                <input class="form-control" type="date" id="start"	
									name="fecha" value="${persona.fechaNacimiento.trim()}" required>
              </div>
              
              <div class="form-group">
                <input type="submit" value="Guardar Persona" class="btn btn-primary py-3 px-5">
              </div>
              </c:forEach>
            </form>
          </div>
		</center>
		
		
        </div>
      </div>
    </section>
    <table>
   
		 
    </table>

    <!-- footer.jsp -->
    <%@ include file="../footer.jsp" %>
    
  </body>
</html>
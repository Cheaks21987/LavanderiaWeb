<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html lang="en">

	<!-- header.jsp -->
	<%@ include file="../header.jsp" %>
	<script> 
          //Cuadro de diálogo de confirmación en JavaScript
          function confirmarAccesoURL()
          {
	    	return confirm("¿Seguro de eliminar?");
          }
	</script>
  <body>
    
 	<!-- navbar.jsp -->
 	<%@ include file="../navbar.jsp" %>
 	
    <!-- END nav -->
    
    <div class="hero-wrap hero-wrap-2" style="background-image: url('../../../../../uwin-lavanderia-lib/images/bg_2.png')'); background-attachment:fixed;">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text justify-content-center" data-scrollax-parent="true">
          <div class="col-md-8 ftco-animate text-center">
            <br><h1 class="mb-3 bread"><br>Mantenimiento de Personas</h1>
          </div>
        </div>
      </div>
    </div>
    <section class="ftco-section contact-section ftco-degree-bg">

      <div class="">
      
          <div class="">
			<form action="<%=request.getContextPath() %>/ServletMantenimientoPersona?action=buscar" method="post">
              <table class="tabla-matenimiento-usuarios" border="0" align="center">
               <tr>
                <td><a href="<%=request.getContextPath() %>/paginas/persona/registrarNuevoPersona.jsp" style="margin:10px;" class="btn manUsuForm btn-primary py-2 px-4">Nuevo Persona</a></td>   
                  
                  <td><input style="margin:10px;" type="submit" value="Buscar Persona" class="btn manUsuForm btn-primary py-2 px-4" value="Buscar"></td> 
                  <td><input style="margin:10px;" type="text" class="form-control manUsuForm btn-primary" placeholder="Nombre" name="cadenaBusqueda"></td>
                  </tr>
                  <tr><td colspan="3"><br></td></tr>
              </table></form>

            </div>
            <div class="cuerpo-matenimiento-usuarios">
             <%@ page import="pe.edu.universidad.proc.paginasServlet.*"%>
		    <%@ page import="java.util.List"%>
		    <%@ page import="pe.edu.universidad.entidades.jdbc.Persona"%>
		    <%
		    BOGestionPersona bo = new BOGestionPersona();
		    List<Persona> lst = bo.consultarPersona();
		    %>
            <table align="center">
            <tr >

             <td class="cabeceraProgracionVisitas" style="pading: 10px 115pxpx 10px 110px;">ID Persona</td>
              <td class="cabeceraProgracionVisitas" style="padding: 10px 50px;">Nombre</td>
              <td class="cabeceraProgracionVisitas">Apellido Paterno</td>
              <td class="cabeceraProgracionVisitas">Apellido Materno</td>
              <td class="cabeceraProgracionVisitas">DNI</td>
              <td class="cabeceraProgracionVisitas">Direccion</td>
              <td class="cabeceraProgracionVisitas">Distrito</td>
              <td class="cabeceraProgracionVisitas">Correo</td>
              <td class="cabeceraProgracionVisitas">Estado</td>
              <td class="cabeceraProgracionVisitas">Tipo</td>
              <td class="cabeceraProgracionVisitas">Fecha Nacimiento</td>
              <td class="cabeceraProgracionVisitas">Editar</td>
              <td class="cabeceraProgracionVisitas">Eliminar</td>
            	
            </tr>

		       <c:forEach items="${lstResultadosPersona}" var="persona">
		        <tr>
		       		<td><c:out value='${persona.idPersona}'></c:out></td>
		       		<td><c:out value="${persona.nombrePersona}"></c:out></td>
		       		<td><c:out value="${persona.apellidoPaterno}"></c:out></td>
		       		<td><c:out value="${persona.apellidoMaterno}"></c:out></td>
		       		<td><c:out value="${persona.dni}"></c:out></td>
		       		<td><c:out value="${persona.direccion}"></c:out></td>
		       		<td><c:out value="${persona.nombreDistrito}"></c:out></td>
		       		<td><c:out value="${persona.correo}"></c:out></td>
		       		<td><c:out value="${persona.estadoTF}"></c:out></td>
		       		<td><c:out value="${persona.tipo}"></c:out></td>
		       		<td><c:out value="${persona.fechaNacimiento}"></c:out></td>
		           	<td><a href="<%=request.getContextPath() %>/ServletMantenimientoPersona?action=editar&planId=<c:out value="${persona.idPersona}"></c:out>">editar</a></td>
		           	<td><a href="<%=request.getContextPath() %>/ServletMantenimientoPersona?action=eliminar&idPersonaEliminar=<c:out value="${persona.idPersona}"></c:out>">eliminar</a></td>
		       
		        </tr>
		        </c:forEach>
          </table>


          </div>
      	
      </div>
    </section>


	<!-- footer.jsp -->
    <%@ include file="../footer.jsp" %>
    
  </body>
</html>
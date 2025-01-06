<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<!-- header.jsp -->
	<%@ include file="../header.jsp" %>
  <body>
    <!-- navbar.jsp -->
 	<%@ include file="../navbar.jsp" %>
    <!-- END nav -->
    
    <div class="hero-wrap hero-wrap-2" style="background-image: url('../../../../../uwin-lavanderia-lib/images/bg_2.png')'); background-attachment:fixed;">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text justify-content-center" data-scrollax-parent="true">
          <div class="col-md-8 ftco-animate text-center">
            <br><h1 class="mb-3 bread"><br>Mantenimiento de Cliente</h1>
          </div>
        </div>
      </div>
    </div>

    <section class="ftco-section contact-section ftco-degree-bg">

      <div class="">
      
          <div class="cuerpo-matenimiento-personas">

              <form action="<%=request.getContextPath()%>/ServletMantenimientoPersona?action=buscar" method="post">
              <table class="tabla-matenimiento-persona"  align="center" style="border:10px;" style="border: 1px solid #000;">
               <tr>
                <td><a href="<%=request.getContextPath()%>/paginas/persona/registrarNuevoPersona.jsp" style="margin:10px;" class="btn manUsuForm btn-primary py-2 px-4">Nuevo Cliente</a></td>   

                  <td><input style="margin:10px;" type="submit" value="Buscar" class="btn manUsuForm btn-primary py-2 px-4" value="Buscar"></td> 

                  <td><input  style="margin:10px;" 	type="text" class="form-control manUsuForm btn-primary" placeholder="Nombre" name="cadenaBusqueda"></td>
                  
                  </tr>
                  <tr><td colspan="4"><br></td></tr>
              </table></form>

            </div>
            <div >
             <%@ page import="pe.edu.universidad.proc.paginasServlet.*"%>
		    <%@ page import="java.util.List"%>
		    <%@ page import="pe.edu.universidad.entidades.jdbc.Persona"%>
		    <%
		    BOGestionPersona bo = new BOGestionPersona();
		    List<Persona> lst = bo.consultarPersona();
		    %>
            <table align="center" >
            <tr >

              <td class="cabeceraProgracionVisitas" style="pading: 10px 115pxpx 10px 110px;">ID Persona</td>
              <td class="cabeceraProgracionVisitas" style="padding: 10px 50px;">Nombre</td>
              <td class="cabeceraProgracionVisitas">Apellido Paterno</td>
              <td class="cabeceraProgracionVisitas">Apellido Materno</td>
              <td class="cabeceraProgracionVisitas">DNI</td>
              <td class="cabeceraProgracionVisitas">Dirección</td>
              <td class="cabeceraProgracionVisitas">ID Distrito</td>
              <td class="cabeceraProgracionVisitas">Correo</td>
              <td class="cabeceraProgracionVisitas">Estado</td>
              <td class="cabeceraProgracionVisitas">Tipo</td>
              <td class="cabeceraProgracionVisitas">Fecha Nacimiento</td>
              <td class="cabeceraProgracionVisitas">Editar</td>
              <td class="cabeceraProgracionVisitas">Eliminar</td>
            	
            </tr>

		           <%
		        for (Persona u : lst) {
		        %>
		        <tr>
		            <td><%=u.getIdPersona()%></td>
		            <td><%=u.getNombrePersona()%></td>
		            <td><%=u.getApellidoPaterno()%></td>
		            <td><%=u.getApellidoMaterno()%></td> 
		            <td><%=u.getDni()%></td>
		            <td><%=u.getDireccion()%></td>
		            <td><%=u.getNombreDistrito()%></td>
		            <td><%=u.getCorreo()%></td>
		            <td><%=u.getEstadoTF()%></td>
		           	<td><%=u.getTipo()%></td>
		           	<td><%=u.getFechaNacimiento()%></td>
		           	<td><a href="<%=request.getContextPath() %>/ServletMantenimientoPersona?action=editar&planId=<%=u.getIdPersona()%>">editar</a></td>
		           	<td><a href="<%=request.getContextPath() %>/ServletMantenimientoPersona?action=eliminar&idPersonaEliminar=<%=u.getIdPersona()%>">eliminar</a></td>
		         
		           	
		        </tr>
		        <%
		        }
		        %>
          </table>


          </div>
       
      </div>
    </section>

	<!-- footer.jsp -->
    <%@ include file="../footer.jsp" %>
    
  </body>
</html>
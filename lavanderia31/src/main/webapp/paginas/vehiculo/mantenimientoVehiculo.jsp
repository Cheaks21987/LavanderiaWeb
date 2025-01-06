<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
            <br><h1 class="mb-3 bread"><br>Mantenimiento Veh�culo</h1>
          </div>
        </div>
      </div>
    </div>

    <section class="ftco-section contact-section ftco-degree-bg">

      <div class="container">
      
          <div class="cuerpo-matenimiento-usuarios">

              <form action="<%=request.getContextPath()%>/ServletMantenimientoVehiculo?action=buscar" method="post">
              <table class="tabla-matenimiento-usuarios"  align="center" style="border:10px;" style="border: 1px solid #000;">
               <tr>
                <td><a href="<%=request.getContextPath()%>/paginas/vehiculo/registrarNuevoVehiculo.jsp" style="margin:10px;" class="btn manUsuForm btn-primary py-2 px-4">Nuevo</a></td>   

                  <td><input style="margin:10px;" type="submit" value="Buscar" class="btn manUsuForm btn-primary py-2 px-4"></td> 

                  <td><input  style="margin:10px;"  type="text" class="form-control manUsuForm btn-primary" placeholder="Nombre" name="cadenaBusqueda"></td>
                  
                  </tr>
                  <tr><td colspan="4"><br></td></tr>
              </table></form>

            </div>
            <div class="cuerpo-matenimiento-usuarios">
             <%@ page import="pe.edu.universidad.proc.paginasServlet.*"%>
            <%@ page import="java.util.List"%>
            <%@ page import="pe.edu.universidad.entidades.jdbc.*"%>
            <%
            BOGestionVehiculo bo = new BOGestionVehiculo();
            List<Vehiculo> lst = bo.consultarVehiculo();
            %>
            <table align="center">
            <tr >

             <td class="cabeceraProgracionVisitas" style="pading: 10px 115pxpx 10px 110px;">ID</td>
              <td class="cabeceraProgracionVisitas">Nombre</td>
              <td class="cabeceraProgracionVisitas">Modelo</td>
              <td class="cabeceraProgracionVisitas" style="padding: 10px 50px;">Placa</td>
              <td class="cabeceraProgracionVisitas" style="padding: 10px 50px;">Editar</td>
              <td class="cabeceraProgracionVisitas">Eliminar</td>
            
            
            </tr>

                    <%
                for (Vehiculo u : lst) {
                %>
                <tr>
                    <td><%=u.getIdVehiculo()%></td>
                    <td><%=u.getNombre()%></td>
                    <td><%=u.getNombreModelo()%></td>
                    <td><%=u.getPlaca()%></td>
                    <td><a href="<%=request.getContextPath() %>/ServletMantenimientoVehiculo?action=editar&planId=<%=u.getIdVehiculo()%>">editar</a></td>
                	<td><a href="<%=request.getContextPath() %>/ServletMantenimientoVehiculo?action=eliminar&idUsuarioEliminar=<%=u.getIdVehiculo()%>" onclick="return confirmarAccesoURL()">eliminar</a></td>
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
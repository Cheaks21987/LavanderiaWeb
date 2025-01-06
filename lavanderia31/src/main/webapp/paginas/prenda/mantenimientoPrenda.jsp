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
	    	return confirm("�Seguro de eliminar?");
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
            <br><h1 class="mb-3 bread"><br>Mantenimiento de prendas</h1>
          </div>
        </div>
      </div>
    </div>

    <section class="ftco-section contact-section ftco-degree-bg">

      <div class="container">
      
          <div class="cuerpo-matenimiento-prenda">

              <form action="<%=request.getContextPath()%>/ServletMantenimientoPrenda?action=buscar" method="post">
              <table class="tabla-matenimiento-prenda"  align="center" style="border:10px;" style="border: 1px solid #000;">
               <tr>
                <td><a href="<%=request.getContextPath()%>/paginas/prenda/registrarNuevoPrenda.jsp" style="margin:10px;" class="btn manUsuForm btn-primary py-2 px-4">Nueva Prenda</a></td>   

                  <td><input style="margin:10px;" type="submit" value="Buscar Prenda" class="btn manUsuForm btn-primary py-2 px-4" value="Buscar"></td> 

                  <td><input  style="margin:10px;"  type="text" class="form-control manUsuForm btn-primary" placeholder="Nombre" name="cadenaBusqueda"></td>
                  
                  </tr>
                  <tr><td colspan="4"><br></td></tr>
              </table></form>

            </div>
            <div class="cuerpo-matenimiento-prenda">
             <%@ page import="pe.edu.universidad.proc.paginasServlet.*"%>
            <%@ page import="java.util.List"%>
            <%@ page import="pe.edu.universidad.entidades.jdbc.*"%>
            <%
            BOGestionPrenda bo = new BOGestionPrenda();
            List<Prenda> lst = bo.consultarPrenda();
            List<Prenda> lstM = bo.consultarMaterial();
            List<Prenda> lstC = bo.consultarColor();
            %>
            <table align="center">
            <tr >

              <td class="cabeceraProgracionVisitas" style="pading: 10px 115pxpx 10px 110px;">ID</td>
              <td class="cabeceraProgracionVisitas" style="padding: 10px 50px;">Nombre</td>
              <td class="cabeceraProgracionVisitas">Marca</td>
              <td class="cabeceraProgracionVisitas">Material</td>
              <td class="cabeceraProgracionVisitas">Color</td>
              <td class="cabeceraProgracionVisitas">Observacion</td>
              <td class="cabeceraProgracionVisitas">Editar</td>
              <td class="cabeceraProgracionVisitas">Eliminar</td>
            
            </tr>

                    <%
                for (Prenda u : lst) {
                %>
                <tr>
                    <td><%=u.getIdPrenda()%></td>
                    <td><%=u.getNombrePrenda()%></td>
                    <td><%=u.getNombreMarca()%></td> 
                    <td><%=u.getNombreMaterial()%></td>
                    <td><%=u.getNombreColor()%></td>
                    <td><%=u.getObservacion()%></td>
                    <td><a href="<%=request.getContextPath() %>/ServletMantenimientoPrenda?action=editar&planId=<%=u.getIdPrenda()%>">editar</a></td> 
                    <td><a href="<%=request.getContextPath() %>/ServletMantenimientoPrenda?action=eliminar&idPrendaEliminar=<%=u.getIdPrenda()%>" onclick="return confirmarAccesoURL()">eliminar</a></td>
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
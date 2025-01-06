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
      
          <div class="cuerpo-matenimiento-prendas">
            <form action="<%=request.getContextPath() %>/ServletMantenimientoPrenda?action=buscar" method="post">
              <table class="tabla-matenimiento-prendas" border="0" align="center">
               <tr>
                <td><a href="<%=request.getContextPath()%>/paginas/prenda/registrarNuevoPrenda.jsp" style="margin:10px;" class="btn manUsuForm btn-primary py-2 px-4">Nueva Prenda</a></td>   
                  
                  <td><input style="margin:10px;" type="submit" value="Buscar Prenda" class="btn manUsuForm btn-primary py-2 px-4" value="Buscar"></td> 
                  <td><input style="margin:10px;" type="text" class="form-control manUsuForm btn-primary" placeholder="Nombre" name="cadenaBusqueda"></td>
                  </tr>
                  <tr><td colspan="3"><br></td></tr>
              </table></form>

            </div>
            <div class="cuerpo-matenimiento-prendas">
             <%@ page import="pe.edu.universidad.proc.paginasServlet.*"%>
            <%@ page import="java.util.List"%>
            <%@ page import="pe.edu.universidad.entidades.jdbc.Prenda"%>
            <%
            BOGestionPrenda bo = new BOGestionPrenda();
            List<Prenda> lst = bo.consultarPrenda();
            %>
            <table align="center">
            <tr >

              <td class="cabeceraProgracionVisitas">ID Prenda</td>
              <td class="cabeceraProgracionVisitas">Nombre Prenda</td>
              <td class="cabeceraProgracionVisitas">Marca</td>
              <td class="cabeceraProgracionVisitas">Material</td>
              <td class="cabeceraProgracionVisitas">Color</td>
              <td class="cabeceraProgracionVisitas">Observacion</td>
              <td class="cabeceraProgracionVisitas">Editar</td>
              <td class="cabeceraProgracionVisitas">Eliminar</td>
            
            </tr>

               <c:forEach items="${lstResultadosPrenda}" var="prenda">
                <tr>
                    <td><c:out value="${prenda.idPrenda}"></c:out></td>
                    <td><c:out value="${prenda.nombrePrenda}"></c:out></td>
                    <td><c:out value="${prenda.nombreMarca}"></c:out></td>
                    <td><c:out value="${prenda.nombreMaterial}"></c:out></td>
                    <td><c:out value="${prenda.nombreColor}"></c:out></td>
                    <td><c:out value="${prenda.observacion}"></c:out></td>
                    <td><a href="<%=request.getContextPath() %>/ServletMantenimientoPrenda?action=editar&planId=<c:out value="${prenda.idPrenda}"></c:out>">editar</a></td>
                    <td><a href="<%=request.getContextPath() %>/ServletMantenimientoPrenda?action=eliminar&idPrendaEliminar=<c:out value="${prenda.idPrenda}"></c:out>"onclick="return confirmarAccesoURL()"> eliminar</a></td>
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

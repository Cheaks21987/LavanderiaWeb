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
      <%@ page import="pe.edu.universidad.proc.paginasServlet.*"%>
		    <%@ page import="java.util.List"%>
		    <%@ page import="pe.edu.universidad.entidades.jdbc.ComprobanteServicio"%>
		    <%
		    BOComprobanteServicio bo = new BOComprobanteServicio();
		    List<ComprobanteServicio> lstPersona = bo.consultarPersona();
		  
		    %>
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text justify-content-center" data-scrollax-parent="true">
          <div class="col-md-8 ftco-animate text-center">
            <br><h1 class="mb-3 bread"><br>Comprobante Servicio</h1>
          </div>
        </div>
      </div>
    </div>

    <section class="ftco-section contact-section ftco-degree-bg">

      <div class="container">
      
          <div class="cuerpo-matenimiento-usuarios">
			<form action="<%=request.getContextPath()%>/ServletMantenimientoComprobanteServicio?action=calcularTotal"
			method="post">
              <table class="tabla-matenimiento-usuarios"  align="center" style="border:10px;" style="border: 1px solid #000;">
               <tr>
              		<select name="idPe" class="form-control">
								<%
								for (ComprobanteServicio u : lstPersona) {
								%>
								<option class="mb-4" value=<%=u.getIdComprobante()%>><%=u.getNombrePersona()%></option>
								<%
								}
								%>
								</select>
                  <td><input style="margin:10px;" type="submit" value="Calcular Total" class="btn manUsuForm btn-primary py-2 px-4"></td> 
                  
                  </tr>
                 
              </table></form>

            </div>
            <div class="cuerpo-matenimiento-usuarios">
            <table align="center">
            <tr >
				
              <td class="cabeceraProgracionVisitas" style="pading: 10px 115pxpx 10px 110px;">Persona</td>
              <td class="cabeceraProgracionVisitas" style="pading: 10px 115pxpx 10px 110px;">ID Comprobante</td>
              <td class="cabeceraProgracionVisitas" style="padding: 10px 50px;">Prenda</td>
              <td class="cabeceraProgracionVisitas">Cantidad</td>
              <td class="cabeceraProgracionVisitas">Servicio</td>
              <td class="cabeceraProgracionVisitas">SubTotal</td>
              <td class="cabeceraProgracionVisitas">Editar</td>
              <td class="cabeceraProgracionVisitas" style="padding: 10px 50px 10px 50px;">Eliminar</td>
            
            </tr>

		       <c:forEach items="${lstResultadosUsuario}" var="comser">
		        <tr>
		        	<td><c:out value="${comser.nombrePersona}"></c:out></td>
		       		<td><c:out value="${comser.idComprobante}"></c:out></td>
		       		<td><c:out value="${comser.nombrePrenda}"></c:out></td>
		       		<td><c:out value="${comser.cantidad}"></c:out></td>
		       		<td><c:out value="${comser.nombreServicio}"></c:out></td>
		       		<td><c:out value="${comser.subtotal}"></c:out></td>
		       		<td><a href="<%=request.getContextPath() %>/ServletMantenimientoServicio?action=editar&planId=<c:out value="${comser.idComprobante}"></c:out>">editar</a></td>
					<td><a href="<%=request.getContextPath() %>/ServletMantenimientoServicio?action=eliminar&idUsuarioEliminar=<c:out value="${comser.idComprobante}"></c:out>" onclick="return confirmarAccesoURL()">eliminar</a></td>
					
		           	
		        </tr>
		        </c:forEach>
		        <tr>
							<td colspan = 4></td>
							<td>Total</td>
								<td><c:forEach items="${lstResultadosUsuario}">
										<div class="form-group">
											${comser.total}
										</div>
									</c:forEach></td>
				</tr>
          </table>
			</div>
   		</section>


	<!-- footer.jsp -->
    <%@ include file="../footer.jsp" %>
    
  </body>
</html>
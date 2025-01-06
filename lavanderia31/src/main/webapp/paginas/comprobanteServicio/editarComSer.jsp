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
    <%@ page import="pe.edu.universidad.proc.paginasServlet.ServletMantenimientoComprobanteServicio"%>
    <%@ page import="java.util.List"%>
    <%@ page import="pe.edu.universidad.entidades.jdbc.ComprobanteServicio"%>
    <%@ page import="pe.edu.universidad.proc.paginasServlet.BOComprobanteServicio"%>
    <%
    BOComprobanteServicio bo = new BOComprobanteServicio();
    List<ComprobanteServicio> lstComprobante = bo.consultarComprobante();
    List<ComprobanteServicio> lstPrenda = bo.consultarPrenda();
    List<ComprobanteServicio> lstServicio = bo.consultarServicio();
    %>
    <div class="hero-wrap hero-wrap-2" style="background-image: url('../images/bg_2.png'); background-attachment:fixed;">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text justify-content-center" data-scrollax-parent="true">
          <div class="col-md-8 ftco-animate text-center">
            <br>  <h1 class="mb-3 bread"><br>Mantenimiento Comprobante Servicio</h1>
          </div>
        </div>
      </div>
    </div>
    
    <section class="ftco-section contact-section ftco-degree-bg" aling="center">
      
      <div class="container formularioRegistrarPrenda" >

          
          <center>
            <form action="<%=request.getContextPath() %>/ServletMantenimientoComprobanteServicio?action=guardarModificado" method="post">
            <c:forEach items="${lstResultadosUsuario}" var="comprobanteServicio">
              <div class="form-group">
                <h4 style="color:black;">Ingrese nuevo Comprobante</h4>
              </div>
              <div class="form-group">
				<select name="idC" class="form-control" placeholder="Comprobante">
						<%
						for (ComprobanteServicio u : lstComprobante) {
						%>
						<option class="mb-4" value=<%=u.getIdComprobante()%>><%=u.getIdComprobante()%></option>
						<%
						}
						%>
					</select>
				</div>
				<div class="form-group">
				<select name="idP" class="form-control" placeholder="Prenda">
						<%
						for (ComprobanteServicio u : lstPrenda) {
						%>
						<option class="mb-4" value=<%=u.getIdPrenda()%>><%=u.getNombrePrenda()%></option>
						<%
						}
						%>
					</select>
				</div>
				<div class="form-group">
                <input type="text" class="form-control" placeholder="Cantidad" name="cantidad" required>
              </div>
				<div class="form-group">
				<select name="idS" class="form-control" placeholder="Servicio">
						<%
						for (ComprobanteServicio u : lstServicio) {
						%>
						<option class="mb-4" value=<%=u.getIdServicio()%>><%=u.getNombreServicio()%></option>
						<%
						}
						%>
					</select>
				</div>
              <div class="form-group">             
	              <select name="estado" class="form-control">
				  <option value="T">Activo</option>
				  <option value="F">Desactivo</option>
				  </select>
              </div>
              <div class="form-group">
                <input type="submit" value="Guardar ComprobanteServicio" class="btn btn-primary py-3 px-5">
              </div>
              </c:forEach>
            </form>
          </div>
        </center>
        </div>
      </div>
    </section>

    <!-- footer.jsp -->
    <%@ include file="../footer.jsp" %>
    
  </body>
</html>
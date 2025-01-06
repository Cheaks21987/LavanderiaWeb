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
    <%@ page import="pe.edu.universidad.entidades.jdbc.Prenda"%>
    <%
    BOGestionPrenda bo = new BOGestionPrenda();
    List<Prenda> lstMarca = bo.consultarMarca();
    List<Prenda> lstMaterial = bo.consultarMaterial();
    List<Prenda> lstColor = bo.consultarColor();
    %>
    <div class="hero-wrap hero-wrap-2" style="background-image: url('../images/bg_2.png'); background-attachment:fixed;">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text justify-content-center" data-scrollax-parent="true">
          <div class="col-md-8 ftco-animate text-center">
            <br>  <h1 class="mb-3 bread"><br>Mantenimiento Prenda</h1>
          </div>
        </div>
      </div>
    </div>
    
    <section class="ftco-section contact-section ftco-degree-bg" aling="center">
      
      <div class="container formularioRegistrarPrenda" >

          
          <center>
            <form action="<%=request.getContextPath() %>/ServletMantenimientoPrenda?action=guardarModificado" method="post">
            <c:forEach items="${lstResultadosPrenda}" var="prenda">
             <div class="form-group">
                <input value="${prenda.idPrenda}" type="text" class="form-control" placeholder="Id Prenda" name="idPrenda" required readonly>
              </div>
             <div class="form-group">
                <input value="${prenda.nombrePrenda.trim()}" type="text" class="form-control" placeholder="Nombre" name="nombrePrenda" required>
              </div>
              <div class="form-group">
              
				<select name="idMarca" class="form-control" placeholder="Marca">
				<option class="mb-4" value="${prenda.idMarca}" selected>${prenda.nombreMarca.trim()}</option>
						<%
						for (Prenda u : lstMarca) {
						%>
						<option class="mb-4" value=<%=u.getIdMarca()%>><%=u.getNombreMarca()%></option>
						<%
						}
						%>
					</select>
				</div>
              <div class="form-group">
				<select name="idMaterial" class="form-control" placeholder="Material">
				<option class="mb-4" value="${prenda.idMaterial}" selected>${prenda.nombreMaterial.trim()}</option>
						<%
						for (Prenda u : lstMaterial) {
						%>
						<option class="mb-4" value=<%=u.getIdMaterial()%>><%=u.getNombreMaterial()%></option>
						<%
						}
						%>
					</select>
				</div>
              <div class="form-group">
				<select name="idColor" class="form-control" placeholder="Color">
				<option class="mb-4" value="${prenda.idColor}" selected>${prenda.nombreColor.trim()}</option>
						<%
						for (Prenda u : lstColor) {
						%>
						<option class="mb-4" value=<%=u.getIdColor()%>><%=u.getNombreColor()%></option>
						<%
						}
						%>
					</select>
				</div>
              <div class="form-group">
                <input value="${prenda.observacion.trim()}" type="text" class="form-control" placeholder="Observacion" name="observacion" required>
              </div>
              <div class="form-group">             
	              <select name="estadoTF" class="form-control">
				  <option value="T">Activo</option>
				  <option value="F">Desactivo</option>
				  </select>
              </div>
              <div class="form-group">
                <input type="submit" value="Guardar Prenda" class="btn btn-primary py-3 px-5">
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
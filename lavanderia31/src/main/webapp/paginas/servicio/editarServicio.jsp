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
    <%@ page import="pe.edu.universidad.entidades.jdbc.*"%>
    <%
    BOGestionServicio bo = new BOGestionServicio();
    List<Servicio> lstCategoria = bo.consultarCategoria();
    %>
    <div class="hero-wrap hero-wrap-2" style="background-image: url('../images/bg_2.png'); background-attachment:fixed;">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text justify-content-center" data-scrollax-parent="true">
          <div class="col-md-8 ftco-animate text-center">
            <br>  <h1 class="mb-3 bread"><br>Servicios</h1>
          </div>
        </div>
      </div>
    </div>
    
    <section class="ftco-section contact-section ftco-degree-bg" aling="center">
      
      <div class="container formularioRegistrarUsuario" >

          
          <center>
            <form action="<%=request.getContextPath() %>/ServletMantenimientoServicio?action=guardarModificado" method="post">
            <c:forEach items="${lstResultadosUsuario}" var="serv">
            
             <div class="form-group">
                <input value="${serv.idServicio}" type="number" class="form-control" placeholder="Id" name="id" required readonly>
              </div>
             <div class="form-group">
                <input value="${serv.nombreServicio.trim()}" type="text" class="form-control" placeholder="Nombre Servicio" name="nombreServicio" required>
              </div>
            <div class="form-group">
                <input value="${serv.precio}" type="number" class="form-control" placeholder="Precio" name="precio" required>
              </div>
              <div class="form-group">
				<select name="idCategoria" class="form-control" placeholder="Categoria">
						<%
						for (Servicio u : lstCategoria) {
						%>
						<option class="mb-4" value=<%=u.getIdCategoria()%>><%=u.getNombreCategoria()%></option>
						<%
						}
						%>
					</select>
				</div>
              <div class="form-group">
                <input type="submit" value="Guardar Servicio" class="btn btn-primary py-3 px-5">
              </div>
              </c:forEach>
            </form>
          </div>
        </center>
        
        

    </section>
    <table>
   
         
    </table>

    <!-- footer.jsp -->
    <%@ include file="../footer.jsp" %>
    
  </body>
</html>
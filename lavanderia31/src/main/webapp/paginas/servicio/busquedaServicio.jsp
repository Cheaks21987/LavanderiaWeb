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
            <br><h1 class="mb-3 bread"><br>Servicios</h1>
          </div>
        </div>
      </div>
    </div>

    <section class="ftco-section contact-section ftco-degree-bg">

      <div class="container">
      
          <div class="cuerpo-matenimiento-usuarios">
            <form action="<%=request.getContextPath()%>/ServletMantenimientoServicio?action=buscar" method="post">
              <table class="tabla-matenimiento-usuarios"  align="center" style="border:10px;" style="border: 1px solid #000;">
               <tr>
                <td><a href="<%=request.getContextPath()%>/paginas/servicio/registrarNuevoServicio.jsp" style="margin:10px;" class="btn manUsuForm btn-primary py-2 px-4">Nuevo</a></td>   

                  <td><input style="margin:10px;" type="submit" value="Buscar" class="btn manUsuForm btn-primary py-2 px-4" value="Buscar"></td> 

                  <td><input  style="margin:10px;"  type="text" class="form-control manUsuForm btn-primary" placeholder="Nombre" name="cadenaBusqueda"></td>
                  
                  </tr>
                  <tr><td colspan="4"><br></td></tr>
              </table></form>

            </div>
            <div class="cuerpo-matenimiento-usuarios">
             <%@ page import="pe.edu.universidad.proc.paginasServlet.*"%>
            <%@ page import="java.util.List"%>
            <%@ page import="pe.edu.universidad.entidades.jdbc.Persona"%>
            <%
            BOGestionServicio bo = new BOGestionServicio();
          
            %>
            <table align="center">
            <tr >

              <td class="cabeceraProgracionVisitas" style="pading: 10px 115pxpx 10px 110px;">ID</td>
              <td class="cabeceraProgracionVisitas" style="pading: 10px 115pxpx 10px 110px;">Nombre Servicio</td>
              <td class="cabeceraProgracionVisitas">Precio</td>
              <td class="cabeceraProgracionVisitas">Categoria</td>
              <td class="cabeceraProgracionVisitas">Editar</td>
              <td class="cabeceraProgracionVisitas" style="padding: 10px 50px 10px 50px;">Eliminar</td>
            </tr>

               <c:forEach items="${lstResultadosUsuario}" var="ordserv">
                <tr>
                    <td><c:out value="${ordserv.idServicio}"></c:out></td>
                    <td><c:out value="${ordserv.nombreServicio}"></c:out></td>
                    <td><c:out value="${ordserv.precio}"></c:out></td>
                    <td><c:out value="${ordserv.nombreCategoria}"></c:out></td>
                    <td><a href="<%=request.getContextPath() %>/ServletMantenimientoServicio?action=editar&planId=<c:out value="${ordserv.idServicio}"></c:out>">editar</a></td>
					<td><a href="<%=request.getContextPath() %>/ServletMantenimientoServicio?action=eliminar&idUsuarioEliminar=<c:out value="${ordserv.idServicio}"></c:out>" onclick="return confirmarAccesoURL()">eliminar</a></td>                
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
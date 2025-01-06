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
    
    <div class="hero-wrap hero-wrap-2" style="background-image: url('../images/bg_2.png'); background-attachment:fixed;">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text justify-content-center" data-scrollax-parent="true">
          <div class="col-md-8 ftco-animate text-center">
            <br>  <h1 class="mb-3 bread"><br>Nueva Categoría</h1>
          </div>
        </div>
      </div>
    </div>
    
    <section class="ftco-section contact-section ftco-degree-bg" aling="center">
      
      <div class="container formularioRegistrarUsuario" >
        
          <center>
            <form action="<%=request.getContextPath() %>/ServletMantenimientoCategoria?action=guardarNuevo" method="post">
              <div class="form-group">
                <h4 style="color:black;">Ingrese nueva categoría</h4>
              </div>
             <div class="form-group">
                <input type="text" class="form-control" placeholder="Nombres" name="nombres" required>
              </div>
              
              <div class="form-group">             
	              <select name="estadoTF" class="form-control">
				  <option value="T">Activo</option>
				  <option value="F">Desactivo</option>
				  </select>
              </div>
              
              <div class="form-group">
                <input type="submit" value="Registrar Categoría" class="btn btn-primary py-3 px-5">
              </div>
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
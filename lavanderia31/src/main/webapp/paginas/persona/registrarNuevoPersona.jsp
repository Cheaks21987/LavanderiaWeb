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
    <%@ page import="pe.edu.universidad.proc.paginasServlet.*"%>
    <%@ page import="java.util.List"%>
    <%@ page import="pe.edu.universidad.entidades.jdbc.Persona"%>
    <%
    BOGestionPersona bo = new BOGestionPersona();
    List<Persona> lstDistrito = bo.consultarDistrito();
    %>
    <div class="hero-wrap hero-wrap-2" style="background-image: url('../images/bg_2.png'); background-attachment:fixed;">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text justify-content-center" data-scrollax-parent="true">
          <div class="col-md-8 ftco-animate text-center">
            <br>  <h1 class="mb-3 bread"><br>Nuevo Usuario</h1>
          </div>
        </div>
      </div>
    </div>
    
    <section class="ftco-section contact-section ftco-degree-bg" aling="center">
      
      <div class="container formularioRegistrarUsuario" >
        
          <center>
            <form action="<%=request.getContextPath() %>/ServletMantenimientoPersona?action=guardarNuevo" method="post">
              <div class="form-group">
                <h4 style="color:black;">Ingrese datos</h4>
              </div>
              
              <div class="form-group">
                <input type="number" class="form-control" placeholder="ID Persona" name="idPersona" required>
              </div>
             <div class="form-group">
                <input type="text" class="form-control" placeholder="Nombres" name="nombrePersona" required>
              </div>
              <div class="form-group">
                <input type="text" class="form-control" placeholder="Apellido Paterno" name="apellidoPaterno" required>
              </div>
              <div class="form-group">
                <input type="text" class="form-control" placeholder="Apellido Materno" name="apellidoMaterno" required>
              </div>
              <div class="form-group">
                <input type="text" onkeypress='return event.charCode >= 48 && event.charCode <= 57' class="form-control" placeholder="DNI" name="dni" minlength="8" maxlength="8" required>
              </div>
              <div class="form-group">
                <input type="text" class="form-control" placeholder="Dirección" name="direccion" required>
              </div>
              <div class="form-group">
				<select name="idDistrito" class="form-control" placeholder="Distrito">
						<%
						for (Persona u : lstDistrito) {
						%>
						<option class="mb-4" value=<%=u.getIdDistrito()%>><%=u.getNombreDistrito()%></option>
						<%
						}
						%>
					</select>
				</div>
              <div class="form-group">
                <input type="email" class="form-control" placeholder="Correo" name="correo" required>
              </div> 
              <div class="form-group">             
	              <select name="estadoTF" class="form-control">
				  <option value="T">Activo</option>
				  <option value="F">Desactivo</option>
				  </select>
              </div>
              <div class="form-group">
                <select name="tipo" class="form-control">
				  <option value="Cliente">Cliente</option>
				  <option value="Administrador">Administrador</option>
				  <option value="Chofer">Chofer</option>
				  </select>
              </div>
              
              
				  
              <div class="form-group">
              Edad
                <input class="form-control" type="date" id="start"	
									name="fecha" value="2000-09-01" ><br></div>
              <div class="form-group">
                <input type="submit" value="Registrar Persona" class="btn btn-primary py-3 px-5">
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
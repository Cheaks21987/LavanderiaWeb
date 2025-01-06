<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<!-- header.jsp -->
<%@ include file="../header.jsp"%>
<body>

	<!-- navbar.jsp -->
	<%@ include file="../navbar.jsp"%>
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

	<%@ page import="pe.edu.universidad.proc.paginasServlet.*"%>
	<%@ page import="java.util.List"%>
	<%@ page import="pe.edu.universidad.entidades.jdbc.Servicio"%>
	<%
	BOGestionServicio bo3 = new BOGestionServicio();
	List<Servicio> lst = bo3.consultarServicio();
	%>

	<div class="hero-wrap hero-wrap-2"
		style="background-image: url('../images/bg_2.png'); background-attachment: fixed;">
		<div class="overlay"></div>
		<div class="container">
			<div class="row no-gutters slider-text justify-content-center"
				data-scrollax-parent="true">
				<div class="col-md-8 ftco-animate text-center">
					<br>
					<h1 class="mb-3 bread">
						<br>Nueva Prenda
					</h1>
				</div>
			</div>
		</div>
	</div>

	<section class="ftco-section contact-section ftco-degree-bg"
		aling="center">

		<div class="container formularioRegistrarPrenda">

			<center>
				<form
					action="<%=request.getContextPath()%>/ServletMantenimientoPrenda?action=guardarNuevo"
					method="post">
					<div class="form-group">
						<h4 style="color: black;">Ingrese datos</h4>
					</div>
					Id Comprobante
					<c:forEach items="${lstCliente}" var="persona">

						<div class="form-group">

							<input type="text" class="form-control"
								placeholder=<c:out value="${persona.idPersona}"></c:out>
								name="idCliente"
								value=<c:out value="${persona.idPersona}"></c:out> required>

						</div>
					</c:forEach>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Nombre"
							name="nombrePrenda" required>
					</div>
					<div class="form-group">
						Marca <select name="idMarca" class="form-control"
							placeholder="Marca">
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
						Material <select name="idMaterial" class="form-control"
							placeholder="Material">
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
						<input type="text" class="form-control" placeholder="Observacion"
							name="observacion" required>
					</div>

					<div class="form-group">
						<select name="estadoTF" class="form-control">
							<option value="T">Activo</option>
							<option value="F">Desactivo</option>
						</select>
					</div>
					------------------------------------------------------------------------------------------
					<div class="form-group">
						<select name="idServicio" class="form-control"
							style="width: 200px;">
							<%
							for (Servicio u : lst) {
							%>
							<option value=<%=u.getIdServicio()%>><b><%=u.getNombreServicio()%></b>
								<p style="color: red">
									S/.<%=u.getPrecio()%></p>
							</option>
							<%
							}
							%>
						</select> Cantidad: <input type="number" class="form-control" placeholder=""
							name="cantidad" style="width: 80px;" required>	
					</div>


					<div class="form-group">
						<input type="submit" value="Registrar"
							class="btn btn-primary py-3 px-5">
					</div>
				</form>
		</div>
		</center>
		</div>
		</div>
	</section>


	<!-- footer.jsp -->
	<%@ include file="../footer.jsp"%>

</body>
</html>
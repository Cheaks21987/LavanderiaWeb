<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="es">
<meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />
<!-- header.jsp -->
<%@ include file="../header.jsp"%>
<script>
	//Cuadro de diÃ¡logo de confirmaciÃ³n en JavaScript
	function confirmarAccesoURL() {
		return confirm("¿Seguro de eliminar?");
	}
</script>
<body>
	<!-- navbar.jsp -->
	<%@ include file="../navbar.jsp"%>
	<!-- END nav -->
	<%@ page import="pe.edu.universidad.proc.paginasServlet.*"%>
	<%@ page import="java.util.List"%>
	<%@ page import="pe.edu.universidad.entidades.jdbc.*"%>
	<%
	BOGestionServicio bo = new BOGestionServicio();
	List<Servicio> lstCategoria = bo.consultarCategoria();
	BOGestionServicio bo3 = new BOGestionServicio();
	List<Servicio> lst3 = bo3.consultarServicio();

	BOProgramaVisita bo4 = new BOProgramaVisita();
	List<ProgramaVisita> lstCliente = bo4.consultarCliente();
	List<ProgramaVisita> lstTodos = bo4.consultarTodos();
	List<ProgramaVisita> lst = bo4.consultarProgramaVisita();
	List<ProgramaVisita> lstVehiculo = bo4.consultarVehiculo();
	%>



	<div class="hero-wrap hero-wrap-2"
		style="background-image: url('<%=request.getContextPath()%>/images/bg_2.png')'); background-attachment:fixed;">
		<div class="overlay"></div>
		<div class="container">
			<div class="row no-gutters slider-text justify-content-center"
				data-scrollax-parent="true">
				<div class="col-md-8 ftco-animate text-center">
					<br>
					<h1 class="mb-3 bread">
						<br>Reportes

					</h1>
				</div>
			</div>
		</div>
	</div>
	<br>

	<center>
		<b><h3 style="color: darkblue;">Reporte de servicios por
				categorias y tipos de servicio</h3></b>
	</center>
	<section class="ftco-section contact-section ftco-degree-bg"
		style="margin: 0px; padding: 0px; display: flex; justify-content: center; text-align: center;">

		<form
			action="<%=request.getContextPath()%>/ServletMantenimientoComprobanteServicio?action=generarReporte1"
			method="post">
			<table border="0" style="text-align: center;">
				<tr>
					<td><b>Categoria</b></td>
					<td><b>Servicio</b></td>
					<td colspan="2"><b>Fecha</b></td>
					<td><b> </b></td>
				</tr>
				<tr>
					<td><select name="nCategoria" class="form-control">
							<option value=" ">Todo</option>
							<%
							for (Servicio u : lstCategoria) {
							%>
							<option class="mb-4" value="<%=u.getNombreCategoria()%>"><%=u.getNombreCategoria()%></option>
							<%
							}
							%>
					</select></td>
					<td><select name="nServicio" class="form-control">
							<option value=" ">Todo</option>
							<%
							for (Servicio u3 : lst3) {
							%>
							<option class="mb-4" value=<%=u3.getNombreServicio()%>><%=u3.getNombreServicio()%></option>
							<%
							}
							%>
					</select></td>
					<td><input type="date" value="2022-01-01" name="fecha1"
						class="form-control" /></td>
					<td><input type="date" value="2022-12-31" name="fecha2"
						class="form-control" /></td>
					<td><input style="margin: 10px;" type="submit" value="Generar"
						class="btn manUsuForm btn-primary py-2 px-4"></td>
				</tr>
			</table>
		</form>
	</section>
	<br>
	<br>

	<center>
		<b><h3 style="color: darkblue;">Reporte de servicios por
				cliente</h3></b>
	</center>
	<section class="ftco-section contact-section ftco-degree-bg"
		style="display: flex; justify-content: center; text-align: center; margin: 0px; padding: 0px;">

		<form
			action="<%=request.getContextPath()%>/ServletMantenimientoComprobanteServicio?action=generarReporte2"
			method="post">
			<table border="0" style="text-align: center;">
				<tr>
					<td><b></b></td>
					<td colspan="2"><b>Cliente</b></td>
					
					<td colspan="2"><b>Monto</b></td>
					<td colspan="2"><b>Fecha</b></td>
					<td><b> </b></td>
				</tr>
				<tr>
					<td>
					<a id="open" class="btn btn-primary py-1 px-4"
										style="color: white; display: flex; justify-content: center;width:100px;justify-content: justify-self;">Buscar</a>
					</td>
					<td>
					<input type="text" style="width: 150px;"
										class="form-control" placeholder="Id Cliente" id="id"
										name="idCliente" required>
					</td>
					<td>
					<input type="text" class="form-control"
										placeholder="Nombre Cliente" style="width: 150px;" id="nombre"
										required>
					</td>
					<td><input type="text" placeholder="menor" name="monto1" class="form-control" style="width:100px" required></td>
					<td> <input type="text" placeholder="mayor" name="monto2" class="form-control" style="width:100px" required></td>
					<td><input type="date" value="2022-01-01" name="fecha1" class="form-control"/>
					 </td><td><input
						type="date" value="2022-12-10" name="fecha2" class="form-control"/></td>
					<td><input style="margin: 10px;" type="submit" value="Generar"
						class="btn manUsuForm btn-primary py-2 px-4" ></td>
				</tr>
			</table>
		</form>
	</section>
	<br>
	<br>
	<center>
		<b><h3 style="color: darkblue;">Resumen de servicios por
				fechas</h3></b>
	</center>
	<section class="ftco-section contact-section ftco-degree-bg"
		style="display: flex; justify-content: center; text-align: center; margin: 0px; padding: 0px;">

		<form
			action="<%=request.getContextPath()%>/ServletMantenimientoComprobanteServicio?action=generarReporte1"
			method="post">
			<table border="0" style="text-align: center;">
				<tr>
					<td><b>Categoria</b></td>
					<td><b>Servicio</b></td>
					<td><b>Fecha</b></td>
					<td><b> </b></td>
				</tr>
				<tr>
					<td><select name="nCategoria" class="form-control">
							<option value=" ">Todo</option>
							<%
							for (Servicio u : lstCategoria) {
							%>
							<option class="mb-4" value="<%=u.getNombreCategoria()%>"><%=u.getNombreCategoria()%></option>
							<%
							}
							%>
					</select></td>
					<td><select name="nServicio" class="form-control">
							<option value=" ">Todo</option>
							<%
							for (Servicio u3 : lst3) {
							%>
							<option class="mb-4" value=<%=u3.getNombreServicio()%>><%=u3.getNombreServicio()%></option>
							<%
							}
							%>
					</select></td>
					<td><input type="date" value="2022-01-01" name="fecha1"
						class="form-control" /></td>
					<td><input type="date" value="2022-12-10" name="fecha2"
						class="form-control" /></td>
					<td><input style="margin: 10px;" type="submit" value="Generar"
						class="btn manUsuForm btn-primary py-2 px-4"></td>
				</tr>
			</table>
		</form>
	</section>

	<br>
	<br>

	<div id="modal_container" class="modal-container">
		<div class="modal-cliente">
			<center>
				<table>
					<tr>
						<td><input type="text" id="formulario"
							class="form-control manUsuForm btn-primary" style=""></td>
						<td><button id="boton"
								class="btn manUsuForm btn-primary py-2 px-4"
								style="border-radius: 0px;">Buscar</button></td>
					</tr>
				</table>
			</center>
			<ul id="resultado">
			</ul>
		</div>
	</div>


	<script>		
	const productos = [
		
		<%for (ProgramaVisita u : lstCliente) {%>
		{nombre: '<%=u.getNombreCliente()%>', Valor: '<%=u.getIdCliente()%>'},
		<%}%>
	]
	
	const formulario =document.querySelector('#formulario');
	const boton =document.querySelector('#boton');
	const resultado =document.querySelector('#resultado');
	const mc =document.querySelector('#modal_container');
	const filtrar = ()=>{	
		resultado.innerHTML = '<p class="btn navbar-brand">NOMBRES DEL CLIENTE</p>';
		
		const texto = formulario.value.toUpperCase();
		
		for(let producto of productos){
			let nombre = producto.nombre.toUpperCase();
			let Valor = producto.Valor.toUpperCase();
			if(nombre.indexOf(texto) !== -1){
				
				resultado.innerHTML += `<div><a onclick="cerrarVentana()" type="button" id=` + Valor + ` class="btn navbar-brand"
				data-toggle="modal" data-target="#exampleModal" style="font-size:15px;"
					data-nom=` + nombre + ` data-id=` + Valor + `>`+ nombre +`</a></div>
				`	 + ``
				
				
				<%for (ProgramaVisita u : lstCliente) {%>
				$(document).ready(function() {
					$("#" +
				<%=u.getIdCliente()%>
					).click(function() {
							var nombre = $(this).data('nom');
							var id = $(this).data('id');
							$("#nombre").val(nombre);
							$("#id").val(id);
							cerrarVentana();
						});
					
					});
				<%}%>		 
			}
			
		}
		
		if(resultado.innerHTML === ''){
			resultado.innerHTML += `
			Cliente no encontrado...
			`
		}
		
	}
	
	boton.addEventListener('click',filtrar)
	formulario.addEventListener('keyup',filtrar)
	filtrar();
	
	function cerrarVentana(){
		mc.classList.remove('show');
	}
	
	</script>


	<%@ include file="../footer.jsp"%>

	<script>
		
	<%for (ProgramaVisita u : lstCliente) {%>
		$(document).ready(function() {
			$("#" +
	<%=u.getIdCliente()%>
		).click(function() {
				var nombre = $(this).data('nom');
				var id = $(this).data('id');
				$("#nombre").val(nombre);
				$("#id").val(id);
				cerrarVentana();
			});
		});
	<%}%>
		
	</script>

</body>
</html>
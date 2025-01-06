<!DOCTYPE html>
<html lang="es">
<!-- header.jsp -->
<%@ include file="../header.jsp"%>

<body>
	<div class="container mt-5">

		<!-- navbar.jsp -->
		<%@ include file="../navbar.jsp"%>
		<!-- END nav -->
		<%@ page import="pe.edu.universidad.proc.paginasServlet.*"%>
		<%@ page import="java.util.List"%>
		<%@ page import="pe.edu.universidad.entidades.jdbc.*"%>
		<%
		BOProgramaVisita bo = new BOProgramaVisita();
		List<ProgramaVisita> lst = bo.consultarProgramaVisita();
		List<ProgramaVisita> lstCliente = bo.consultarCliente();
		List<ProgramaVisita> lstTodos = bo.consultarTodos();
		List<ProgramaVisita> lstVehiculo = bo.consultarVehiculo();
		%>



		<div class="hero-wrap hero-wrap-2"
			style="background-image: url('images/bg_2.png'); background-attachment: fixed;">
			<div class="overlay"></div>
			<div class="container">
				<div class="row no-gutters slider-text justify-content-center"
					data-scrollax-parent="true">
					<div class="col-md-8 ftco-animate text-center">
						<h1 class="mb-3 bread">
							<br>Programación de visitas a domicilio
						</h1>
					</div>
				</div>
			</div>
		</div>

		<section class="ftco-section contact-section ftco-degree-bg">
			<div class="container">
				<div class="row block-9" >
					
					<table><tr><td style="width:500px;display: flex;justify-content: center;">
	
						<form action="<%=request.getContextPath()%>/ServletMantenimientoProgramaVisita?action=guardarNuevo"
							method="post">
							<div class="form-group" style="text-align:center	;">
							<h4 class="mb-4">Programar Visita (Administrador)</h4>
							</div>
							<div class="form-group">
							<a id="open" class="btn btn-primary py-1 px-4" style="color:white;display: flex;justify-content: center;">Buscar</a>
							</div>
							<div class="form-group">
							<input type="text" style="width:300px;"
										class="form-control" placeholder="Id Cliente" id="id"
										name="idcliente" required>
							</div>
							<div class="form-group">
							<input type="text" class="form-control"
										placeholder="Nombre Cliente" id="nombre" required >
							</div>
							<div class="form-group">
								<input type="text" class="form-control"
									placeholder="Observaciones" name="observaciones" required>
							</div>
							<div class="form-group">
								<select name="tipo" class="form-control">
									<option class="mb-4" value="Envio de Ropa" selected>Envio
										de ropa</option>
									<option class="mb-4" value="Recojo de Ropa">Recojo de
										ropa</option>
									<option class="mb-4" value="Otro">Otro</option>
								</select>
							</div>
							Chofer
							<div class="form-group">
								<select name="idchofer" class="form-control">
									<%
									for (ProgramaVisita u : lst) {
									%>
									<option class="mb-4" value=<%=u.getIdChofer()%>><%=u.getNombreChofer()%></option>
									<%
									}
									%>
								</select>
							</div>
							Vehículo	
							<div class="form-group">
								<select name="idvehiculo" class="form-control">
									<%
									for (ProgramaVisita u2 : lstVehiculo) {
									%>
									<option class="mb-4" value=<%=u2.getIdVehiculo()%>><%=u2.getNombreVehiculo()%></option>
									<%
									}
									%>
								</select>
							</div>
							<div class="form-group">
								<input class="form-control" type="datetime-local" id="start"
									name="fecha" value="2022-09-01T08:00" min="2022-09-01T08:00"
									max="2023-01-01T18:00">
							</div>

							<div class="form-group">
								<input type="submit" value="Registrar Visita"
									class="btn btn-primary py-3 px-5">
							</div>
						</form>

					
					</td><td>
					
					
				<table class="" style="position:absolute;top:15%;">
						<tr>
							<td class="cabeceraProgracionVisitas" >Id</td>
							<td class="cabeceraProgracionVisitas">Cliente</td>
							<td class="cabeceraProgracionVisitas">Dirección</td>
							<td class="cabeceraProgracionVisitas">Fecha</td>
							<td class="cabeceraProgracionVisitas">Tipo</td>
							<td class="cabeceraProgracionVisitas">Chofer</td>
				
						</tr>
						<%
						for (ProgramaVisita u : lstTodos) {
						%>
						<tr>
							<td class="celdasProgracionVisitas"><%=u.getId()%></td>
							<td class="celdasProgracionVisitas"><%=u.getNombreCliente()%></td>
							<td class="celdasProgracionVisitas"><%=u.getDireccion()%></td>
							<td class="celdasProgracionVisitas"><%=u.getFecha()%></td>
							<td class="celdasProgracionVisitas"><%=u.getEstado()%></td>
							<td class="celdasProgracionVisitas"><%=u.getNombreChofer()%></td>
						
						</tr>
						<%
						}
						%>
					</table>
					</td><td>
					
					</td></tr></table>
					
				</div>
			</div>
		</section>

		<div id="modal_container" class="modal-container">
			<div class="modal-cliente">
			
			<center>
			<table><tr><td>
			<input type="text" id="formulario" class="form-control manUsuForm btn-primary" style="">
			</td><td><button id="boton" class="btn manUsuForm btn-primary py-2 px-4" style="border-radius:0px;">Buscar</button>
			</td></tr></table></center>
			<ul id="resultado"> </ul>

			</div>
	<script>
				
	const productos = [
		
		<%
		for (ProgramaVisita u : lstCliente) {
		%>
		{nombre: '<%=u.getNombreCliente()%>', Valor: '<%=u.getIdCliente()%>'},
		<%
		}
		%>
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
		</div>
	</div>

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
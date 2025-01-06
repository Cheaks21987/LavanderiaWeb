<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<meta http-equiv=”Content-Type” content=”text/html;
	charset=UTF-8″ />
<!-- header.jsp -->
<%@ include file="../header.jsp"%>
<script>
	//Cuadro de diálogo de confirmación en JavaScript
	function confirmarAccesoURL() {
		return confirm("¿Seguro de eliminar?");
	}
</script>
<body>


	<section class="ftco-section contact-section ftco-degree-bg" style="margin:0px;padding:0px;">
			<div class="cuerpo-matenimiento-usuarios" >
				<%@ page import="pe.edu.universidad.proc.paginasServlet.*"%>
				<%@ page import="java.util.List"%>
				<%@ page import="pe.edu.universidad.entidades.jdbc.*"%>
				<%
				BOGestionCategoria bo = new BOGestionCategoria();
				List<Categoria> lst = bo.consultarCategorias();
				
				BOComprobanteServicio bo2 = new BOComprobanteServicio();
				List<ComprobanteServicio> lst2 = bo2.consultarComprobantes();
				%>
				<div style="display:flex;justify-content:center;">
				<table border=0 style="text-align:center;width:90%;">
					<tr>
						<td colspan="7"><h1>COMPROBANTES</h1></td>
					</tr>
					

					<tr>

						<td class="cabeceraProgracionVisitas"
							style="width:10%">Id</td>
						<td class="cabeceraProgracionVisitas"
							style="width:30%">Cliente</td>
						<td class="cabeceraProgracionVisitas"
							style="width:15%">Fecha</td>
						<td class="cabeceraProgracionVisitas"
							style="width:10%">Tipo</td>
						<td class="cabeceraProgracionVisitas"
							style="width:10%">Estado</td>
						<td class="cabeceraProgracionVisitas"
							style="width:10%">Total</td>
						<td class="cabeceraProgracionVisitas"
							style="width:10%">Guardar</td>

					</tr>
					
					<%
					for (ComprobanteServicio u : lst2) {
					%>
					<tr>
						<td><%=u.getIdComprobante()%></td>
						<td><%=u.getNombrePersona()%></td>
						<td><%=u.getFecha()%></td>
						<td><%=u.getTipo()%></td>
						
						<td><%=u.getEstadoTF()%></td>
						<td>S/. <%=u.getTotal()%></td>
						<td><a style="background-color:red;font-size:10px;border-color:red;" class="btn manUsuForm btn-primary py-1 px-1" href="<%=request.getContextPath()%>/ServletMantenimientoComprobanteServicio?action=editarEstadoComprobante&idC=<%=u.getIdComprobante()%>&estado=Finalizado">FINALIZAR</a></td>
					</tr>
					<%
					}
					%>
				</table>


			</div>

		</div>

	</section>

	<!-- footer.jsp -->


</body>
</html>
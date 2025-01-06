<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" >
<!-- header.jsp -->
<%@ include file="../header.jsp"%>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<script>
	//Cuadro de diÃ¡logo de confirmaciÃ³n en JavaScript
	function confirmarAccesoURL() {
		return confirm("Â¿Seguro de eliminar?");
	}
</script>
<body onload="buscarPrueba();" >
	<!-- END nav -->
	<%@ page
		import="pe.edu.universidad.proc.paginasServlet.ServletMantenimientoComprobanteServicio"%>
	<%@ page
		import="pe.edu.universidad.proc.paginasServlet.BOComprobanteServicio"%>
	<%@ page import="java.util.List"%>
	<%@ page import="pe.edu.universidad.entidades.jdbc.ComprobanteServicio"%>
	<%@ page import="pe.edu.universidad.proc.paginasServlet.*"%>
	<%@ page import="java.util.List"%>
	<%@ page import="pe.edu.universidad.entidades.jdbc.Persona"%>

	<%
	BOComprobanteServicio bo = new BOComprobanteServicio();

	List<ComprobanteServicio> lstComprobante = bo.consultarComprobante();
	List<ComprobanteServicio> lstPrenda = bo.consultarPrenda();
	List<ComprobanteServicio> lstServicio = bo.consultarServicio();
	List<ComprobanteServicio> lstPersona = bo.consultarPersona();
	%>
	<br>
	<section class="ftco-section contact-section ftco-degree-bg" style="margin:0px;padding:0px;">
		<div style="display: flex; justify-content: center;">
			<table border=0 style="width:90%;text-align:center;">
				<tr>
					<td colspan="5" style="color:red;"></td>
				</tr>
				<tr style="height:55px;">
					<td style="width:7%;background-color:#191970;font-weight: bold;font-size:20px;color:white;">
						Cliente:
					</td><td style="width:10%;">
						<input style="font-weight: bold;font-size:20px;" class="form-control manUsuForm btn-primary" type="text" id="txtBuscar" placeholder="Buscar" onkeyup="buscar()"
						onkeypress="captureEnter();" >
					</td><td style="width:75%;">	
					
						
						<div id="resultado"></div> <script
							src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js"></script>
						<script>
        				
		            	function buscar(){
		            	var tf = document.getElementById('txtBuscar'); 
		              // lo que el usuario escribi�
		                var txtFiltro = $("#txtBuscar").val();
		                
		                tf.onkeypress = function(e){
		                if (e.charCode === 13) {
		                $.ajax({
		                    url: "<%=request.getContextPath()%>/ServletMantenimientoPersona?action=buscarJ",
															data : {
																filtro : txtFiltro
															},
															success : function(result) {
																$("#resultado").html(
																		result);
															}
														})
											}
										};
									}
		            	
		            	function buscarPrueba(){
			            
			                $.ajax({
			                    url: "<%=request.getContextPath()%>/ServletMantenimientoPersona?action=buscarJ",
																data : {
																	filtro : "ucas"
																},
																success : function(result) {
																	$("#resultado").html(
																			result);
																}
															});
										}
		            	
		            	
		            	
		            	function buscar3(){
			            	var tf = document.getElementById('txtBuscar'); 
			              // lo que el usuario escribi�
			                var txtFiltro = "cas";
			                
			                tf.onkeypress = function(e){
			                if (e.charCode === 13) {
			                $.ajax({
			                    url: "<%=request.getContextPath()%>/ServletMantenimientoPersona?action=buscarJ",
																data : {
																	filtro : txtFiltro
																},
																success : function(result) {
																	$("#resultado").html(
																			result);
																}
															})
												}
											};
										}
						</script></td>
						
						<td>
						<td style="width:20%;"></td>
						
						</tr>
						
						<tr style="height:300px">
						<td colspan="5">
						
						<div id="resultado2"></div> <script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js"></script>

					    	
						
						
						<script>		
						function buscar2(){
						const btn2 = document.querySelector('#btn2');
				        btn2.onclick = (event) => {
				        var txtFiltro2 = document.getElementById("framework2").options[document.getElementById("framework2").selectedIndex].value
				        $.ajax({
		                    url: "<%=request.getContextPath()%>/ServletMantenimientoPersona?action=buscarCF",
															data : {
																filtro : txtFiltro2
																
															},
															success : function(result) {
																$("#resultado2").html(
																		result);
															}
														})
										;
									}}
				        
						</script>
						
						
						<script>		
						function actualizarC(num1){		        
				        var txtFiltroAC = num1;
				        $.ajax({
		                    url: "<%=request.getContextPath()%>/ServletMantenimientoPersona?action=buscarCF",
															data : {
																filtro : txtFiltroAC
																
															},
															success : function(result) {
																$("#resultado2").html(
																		result);
															}
														})
										;
									}
				        
						</script>
						
						<script>		
						function buscar4(){
						const btn3 = document.querySelector('#btn3');
				        btn3.onclick = (event) => {


				        	alert (" Hello World \n Welcome to the javaTpoint.com \n This is an alert dialog box ");  }}

						window.onload=buscarPrueba;
						</script>
						</td>
						
					</td>	
				</tr>
			</table>
		</div>
	</section>
	
	<center>
	<a href="<%=request.getContextPath()%>/paginas/comprobanteServicio/comprobantes.jsp" style="margin: 10px;" class="btn manUsuForm btn-primary py-2 px-4">Guardar Comprobante</a>
	</center>


	

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@page import="net.sf.jasperreports.engine.JasperRunManager" %>
<%@page import="net.sf.jasperreports.*"%>
<%@page import="java.util.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.*"%>

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
	<!-- navbar.jsp -->
	<%@ include file="../navbar.jsp"%>
	<!-- END nav -->



	ESTE ES EL REPORTE FINAL
	
	<!-- footer.jsp -->
	<%@ include file="../footer.jsp"%>

</body>
</html>
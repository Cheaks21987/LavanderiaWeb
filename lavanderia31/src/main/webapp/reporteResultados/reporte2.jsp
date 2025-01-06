<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%> 
<%@ page import="java.io.File"%>
<%@page import="java.util.HashMap"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.File"%>
<%@ page import="java.sql.*"%>
<%@ page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@ page import="net.sf.jasperreports.engine.design.JRJavacCompiler"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="javax.naming.NamingException"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="javax.naming.Context"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.sql.DataSource"%>

<%@ page import="pe.edu.universidad.proc.cone.Conectar"%>
<%@ page import="pe.edu.universidad.entidades.jdbc.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<c:forEach items="${lstReporte}" var="reporte">%${reporte.NombreCategoria}%</c:forEach>

<%

//coneccion base datos
	/*Connection cnx = null;

	try {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("/jdbc/dblavanderiautp");
		cnx = ds.getConnection();
	} catch (SQLException e) {
	
		throw new RuntimeException(e);
	} catch (NamingException e) {
		
		throw new RuntimeException(e);
	}*/

//---------------------------
		int idC  =Integer. parseInt(request.getParameter("idCliente").trim());
		Double m1  =Double.valueOf(request.getParameter("monto1").trim());
		Double m2  =Double.valueOf(request.getParameter("monto2").trim());
		String f1  =request.getParameter("fecha1").trim();
		String f2  =request.getParameter("fecha2").trim();
	
		
   		
        Conectar nn = new Conectar();
        Connection cnx = nn.establecerConexion();

        File reportFile = new File(application.getRealPath("paginas/reporteD/reporte3.jasper"));
        
          Map parameters = new HashMap();
          parameters.clear();
          parameters.put("Pip",idC);
          parameters.put("Pf1",f1);
          parameters.put("Pf2",f2);
          parameters.put("Pm1",m1);
          parameters.put("Pm2",m2);
          
          
          byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, cnx);

          response.setContentType("application/pdf");
          response.setContentLength(bytes.length);

          ServletOutputStream outputStream = response.getOutputStream();
          outputStream.write(bytes, 0, bytes.length);
          outputStream.flush();
          outputStream.close();
%>

</body>
</html>
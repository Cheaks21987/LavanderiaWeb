<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
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
	<%@ page import="pe.edu.universidad.proc.paginasServlet.ServletMantenimientoComprobanteServicio"%>
	<%@ page import="pe.edu.universidad.proc.paginasServlet.BOComprobanteServicio"%>
	<%@ page import="java.util.List"%>
	<%@ page import="pe.edu.universidad.entidades.jdbc.ComprobanteServicio"%>
	<%
	BOComprobanteServicio bo = new BOComprobanteServicio();

	List<ComprobanteServicio> lstComprobante = bo.consultarComprobante();
	List<ComprobanteServicio> lstPrenda = bo.consultarPrenda();
	List<ComprobanteServicio> lstServicio = bo.consultarServicio();
	List<ComprobanteServicio> lstPersona = bo.consultarPersona();
	%>
	<div class="hero-wrap hero-wrap-2"
		style="background-image: url('../../../../../uwin-lavanderia-lib/images/bg_2.png')'); background-attachment: fixed;">
		<div class="overlay"></div>
		<div class="container">
			<div class="row no-gutters slider-text justify-content-center"
				data-scrollax-parent="true">
				<div class="col-md-8 ftco-animate text-center">
					<br>
					<h1 class="mb-3 bread">
						<br>Ingresar Ropa	
					</h1>
				</div>
			</div>
		</div>
	</div>
	
	<center>
    <table border=1>
      <tr>
          <td>Buscar Cliente</td>
          <td><input type="text"></td>
          <td><input type="button" value="Buscar"></td>
          <td>NOMBRE CLIENTE</td>
          <td>------------------</td>
          <td>Buscar Pedido</td>
          <td><input type="text"></td>
          <td><input type="button" value="Buscar"></td>
          <td>N�MERO PEDIDO</td>
          <td><a href="ljdpsaijdwq.com">Nuevo</a></td>
      </tr>
      <tr>
        <td>Agregar<br>

        </td>
        <td colspan="9">



          <table border="1" style="align-content: right; text-align:right;display: inline-block; margin-left: 60%;">
            <tr>
              <td>Id</td>
              <td>Prenda</td>
              <td>Servicio</td>
              <td>SubTotal</td>
              <td>Editar</td>
              <td>Eliminar</td>
            </tr>
            <tr>
                <td>01</td>
                <td>Camisa</td>
                <td>Planchado</td>
                <td>3000.00</td>
                <td><a href="laskmdsa">Editar</a></td>
                <td><a href="laskmdsa">Eliminar</a></td>
            </tr>
            <tr>
                <td>01</td>
                <td>Camisa</td>
                <td>Planchado</td>
                <td>3000.00</td>
                <td><a href="laskmdsa">Editar</a></td>
                <td><a href="laskmdsa">Eliminar</a></td>
            </tr>
            <tr>
                <td>01</td>
                <td>Camisa</td>
                <td>Planchado</td>
                <td>3000.00</td>
                <td><a href="laskmdsa">Editar</a></td>
                <td><a href="laskmdsa">Eliminar</a></td>
            </tr>
            <tr>
                <td>01</td>
                <td>Camisa</td>
                <td>Planchado</td>
                <td>3000.00</td>
                <td><a href="laskmdsa">Editar</a></td>
                <td><a href="laskmdsa">Eliminar</a></td>
            </tr>
            <tr>
                <td>01</td>
                <td>Camisa</td>
                <td>Planchado</td>
                <td>3000.00</td>
                <td><a href="laskmdsa">Editar</a></td>
                <td><a href="laskmdsa">Eliminar</a></td>
            </tr>

          </table>

        </td>
      </tr>

      <tr>
          <td colspan="10" style="text-align: right;">Total: 1000000.000</td>
      </tr>

      </table>
    </center>

	
	<!-- footer.jsp -->
	<%@ include file="../footer.jsp"%>

</body>
</html>
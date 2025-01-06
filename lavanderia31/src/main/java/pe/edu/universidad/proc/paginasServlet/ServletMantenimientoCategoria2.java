package pe.edu.universidad.proc.paginasServlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import pe.edu.universidad.dao.DaoGenerico;
import pe.edu.universidad.entidades.jdbc.Categoria;

@WebServlet(name="ServletMantenimientoCategoria2", urlPatterns={"ServletMantenimientoCategoria2"})

public class ServletMantenimientoCategoria2 extends javax.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletMantenimientoCategoria2() {
		super();
	}
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equals("editar")) {

			String planId = request.getParameter("planId");
			BOGestionCategoria bo = new BOGestionCategoria();
			List<Categoria> lst = bo.editarCategoria(planId);
			request.getSession().setAttribute("lstResultadosCategoria", lst);
			request.getRequestDispatcher("paginas/categoria/editarCategoria.jsp").forward(request, response);

		} else if (action.equals("eliminar")) {

			String planId = request.getParameter("idUsuarioEliminar");
			BOGestionCategoria bo = new BOGestionCategoria();
			bo.eliminarCategoria(planId);
			request.getRequestDispatcher("paginas/categoria/mantenimientoCategoria.jsp").forward(request, response);

		}else if (action.equals("reporte2")) {

			
			//coneccion base datos
			Connection cnx = null;
			try {
				Context ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup("java:/jdbc/dblavanderiautp");
				cnx = ds.getConnection();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} catch (NamingException e) {
				throw new RuntimeException(e);
			}
			//---------------------------
			/*
			ServletOutputStream out = response.getOutputStream();
			try {
	            InputStream logoEmpresa = this.getServletConfig()
	                    .getServletContext()
	                    .getResourceAsStream("reportesJasper/img/logoAlexanderStore.png"),
	                    logoFooter = this.getServletConfig()
	                            .getServletContext()
	                            .getResourceAsStream("reportesJasper/img/check.png"),
	                    reporteEmpleado = this.getServletConfig()
	                            .getServletContext()
	                            .getResourceAsStream("paginas/reporte/ReporteEmpleados.jasper");
	            
	            if (reporteEmpleado != null) {
	                String jsonEmpleados = request.getParameter("lista"); //OJO
	                Gson gson = new Gson();
	                List<Empleado> reportesEmpleados = new ArrayList<>();
	                List<Empleado> reportesEmpleados2 = new ArrayList<>();

	                reportesEmpleados.add(new Empleado());
	                reportesEmpleados2 = gson.fromJson(jsonEmpleados, new das<List<Empleado>>() {
	                }.getType());
	                reportesEmpleados.addAll(reportesEmpleados2);

	                JasperReport report = (JasperReport) JRLoader.loadObject(reporteEmpleado);
	                JRBeanArrayDataSource ds = new JRBeanArrayDataSource(reportesEmpleados.toArray());

	                Map<String, Object> parameters = new HashMap();
	                parameters.put("ds", ds);
	                parameters.put("logoEmpresa", logoEmpresa);
	                parameters.put("imagenAlternativa", logoFooter);
	                response.setContentType("application/pdf");
	                response.addHeader("Content-disposition", "inline; filename=ReportesEmpleados.pdf");
	                JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, ds);
	                JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	                out.flush();
	                out.close();
	            } else {
	                response.setContentType("text/plain");
	                out.println("no se pudo generar el reporte");
	                out.println("esto puede debrse a que la lista de datos no fue recibida o el archivo plantilla del reporte no se ha encontrado");
	                out.println("contacte a soporte");
	            }
	        } catch (Exception e) {
	            response.setContentType("text/plain");
	            out.print("ocurrió un error al intentar generar el reporte:" + e.getMessage());
	            e.printStackTrace();
	        }
			*/		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			/*
				
			JasperReport reporte;
			try {
				reporte = JasperCompileManager.compileReport("paginas/reporte/reporte2.jrxml");
				JasperPrint  jp = JasperFillManager.fillReport(reporte,null,cnx);
				JasperViewer.viewReport(jp,true);
			} catch (Exception e) {
				// TODO: handle exception
			}
	        File reportFile = new File(application.getRealPath("reportes/reporte.jasper"));
	        Map parameters = new HashMap();
	          
	        //parameters.put("nombre_del_parametro_jasper", "valor que se manda");
	        parameters.put("id",4);
	        
	        
	        byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, cnx);
	        response.setContentType("application/pdf");
	        response.setContentLength(bytes.length);
	        ServletOutputStream outputStream = response.getOutputStream();
	        outputStream.write(bytes, 0, bytes.length);
	        outputStream.flush();
	        outputStream.close();

			
			
			request.getRequestDispatcher("paginas/reporte/reporte2.jsp").forward(request, response);
			*/
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("guardarNuevo")) {
			String nombre = request.getParameter("nombres");
			String estadoTF = request.getParameter("estadoTF");
			BOGestionCategoria bo = new BOGestionCategoria();
			Categoria categoria = new Categoria();
			categoria.setNombreCategoria(nombre);
			categoria.setEstadoTF(estadoTF);
			bo.registrarCategoria(categoria);
			request.getRequestDispatcher("paginas/categoria/mantenimientoCategoria.jsp").include(request, response);

		} else if (action.equals("guardarModificado")) {

			String id = request.getParameter("idd");
			String nombre = request.getParameter("nombres");
			String estadoTF = request.getParameter("estadoTF");
			BOGestionCategoria bo = new BOGestionCategoria();
			Categoria categoria = new Categoria();

			categoria.setId(Integer.parseInt(id));
			categoria.setNombreCategoria(nombre);
			categoria.setEstadoTF(estadoTF);

			bo.guardarModificadoCategoria(categoria);

			request.getRequestDispatcher("paginas/categoria/mantenimientoCategoria.jsp").include(request, response);

		} else if (action.equals("buscar")) {
			DaoGenerico cnx = new DaoGenerico();
			Connection con = cnx.obtenerConexion();

			String cadenaBusqueda = request.getParameter("cadenaBusqueda");
			BOGestionCategoria bo = new BOGestionCategoria();
			List<Categoria> lst = bo.consultarCategorias(cadenaBusqueda);
			request.getSession().setAttribute("lstResultadosCategoria", lst);
			request.getRequestDispatcher("paginas/categoria/busquedaCategoria.jsp").forward(request, response);

			/*
			 File jasperFile = new File(application.getRealPath("categoria/report.jasper"));
			byte[] bytes = JasperRunManager.runReportToPdf(jasperFile.getPath(), null, con);
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream output = response.getOutputStream();
			response.getOutputStream();
			output.write(bytes, 0, bytes.length);
			output.flush();
			output.close();*/
		}else if (action.equals("reporte2")) {

			
			//coneccion base datos
			Connection cnx = null;
			try {
				Context ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup("java:/jdbc/dblavanderiautp");
				cnx = ds.getConnection();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} catch (NamingException e) {
				throw new RuntimeException(e);
			}
			//---------------------------
			
			/*ServletOutputStream out = response.getOutputStream();
			try {
	            InputStream logoEmpresa = this.getServletConfig()
	                    .getServletContext()
	                    .getResourceAsStream("reportesJasper/img/logoAlexanderStore.png"),
	                    logoFooter = this.getServletConfig()
	                            .getServletContext()
	                            .getResourceAsStream("reportesJasper/img/check.png"),
	                    reporteEmpleado = this.getServletConfig()
	                            .getServletContext()
	                            .getResourceAsStream("paginas/reporte/ReporteEmpleados.jasper");
	            
	            if (reporteEmpleado != null) {
	                String jsonEmpleados = request.getParameter("lista"); //OJO
	                Gson gson = new Gson();
	                List<Empleado> reportesEmpleados = new ArrayList<>();
	                List<Empleado> reportesEmpleados2 = new ArrayList<>();

	                reportesEmpleados.add(new Empleado());
	                reportesEmpleados2 = gson.fromJson(jsonEmpleados, new dsadsa<List<Empleado>>() {
	                }.getType());
	                reportesEmpleados.addAll(reportesEmpleados2);

	                JasperReport report = (JasperReport) JRLoader.loadObject(reporteEmpleado);
	                JRBeanArrayDataSource ds = new JRBeanArrayDataSource(reportesEmpleados.toArray());

	                Map<String, Object> parameters = new HashMap();
	                parameters.put("ds", ds);
	                parameters.put("logoEmpresa", logoEmpresa);
	                parameters.put("imagenAlternativa", logoFooter);
	                response.setContentType("application/pdf");
	                response.addHeader("Content-disposition", "inline; filename=ReportesEmpleados.pdf");
	                JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, ds);
	                JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	                out.flush();
	                out.close();
	            } else {
	                response.setContentType("text/plain");
	                out.println("no se pudo generar el reporte");
	                out.println("esto puede debrse a que la lista de datos no fue recibida o el archivo plantilla del reporte no se ha encontrado");
	                out.println("contacte a soporte");
	            }
	        } catch (Exception e) {
	            response.setContentType("text/plain");
	            out.print("ocurrió un error al intentar generar el reporte:" + e.getMessage());
	            e.printStackTrace();
	        }*/
			}
	}

}

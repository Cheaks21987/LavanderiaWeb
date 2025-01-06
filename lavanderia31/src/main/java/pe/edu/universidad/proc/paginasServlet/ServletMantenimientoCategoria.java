package pe.edu.universidad.proc.paginasServlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import pe.edu.universidad.dao.DaoGenerico;
import pe.edu.universidad.entidades.jdbc.Categoria;

import pe.edu.universidad.entidades.jdbc.reporte;
import java.sql.Connection;

@WebServlet(name="ServletMantenimientoCategoria", urlPatterns={"ServletMantenimientoCategoria"})

public class ServletMantenimientoCategoria extends javax.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletMantenimientoCategoria() {
		super();
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String filtro = request.getParameter("filtro");
        try (PrintWriter out = response.getWriter()) {	            
            out.println("ñam 	"+ filtro);  
        } catch (Exception e) {
           
        }
        
     
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
			
			

		}

	}

}

package pe.edu.universidad.proc.paginasServlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.universidad.entidades.jdbc.Categoria;
import pe.edu.universidad.entidades.jdbc.ProgramaVisita;


@WebServlet("/ServletMantenimientoProgramaVisita")
public class ServletMantenimientoProgramaVisita extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletMantenimientoProgramaVisita() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action  =request.getParameter("action");
		
		if (action.equals("editar")) {
    		
    		String planId  =request.getParameter("planId");
    		BOGestionCategoria bo = new BOGestionCategoria();
	        List<Categoria> lst = bo.editarCategoria(planId);
	        request.getSession().setAttribute("lstResultadosCategoria", lst);     
	        request.getRequestDispatcher("paginas/categoria/editarCategoria.jsp").forward(request, response);
	        
    	} else if (action.equals("eliminar")) {
    		
    		String planId  =request.getParameter("idUsuarioEliminar");
    		BOGestionCategoria bo = new BOGestionCategoria();
	        bo.eliminarCategoria(planId); 
	        request.getRequestDispatcher("paginas/categoria/mantenimientoCategoria.jsp").forward(request, response);
	        
    	}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action  =request.getParameter("action");
		
		if (action.equals("guardarNuevo")) {
			
	        int idcliente = Integer. parseInt(request.getParameter("idcliente"));
	        String observaciones = request.getParameter("observaciones");
	        String tipo = request.getParameter("tipo");
	        int idchofer = Integer.parseInt(request.getParameter("idchofer"));
	        int idvehiculo = Integer.parseInt(request.getParameter("idvehiculo"));
	        String fecha = request.getParameter("fecha");
	        
	        
	        BOProgramaVisita bo = new BOProgramaVisita();
	        ProgramaVisita programavisita=new ProgramaVisita();
	        programavisita.setIdCliente(idcliente);
	        programavisita.setObservaciones(observaciones);
	        programavisita.setEstadoServicio(tipo);
	        programavisita.setIdChofer(idchofer);
	        programavisita.setIdVehiculo(idvehiculo);
	        programavisita.setFecha(fecha);

	        bo.registrarProgramaVisita(programavisita);
	        request.getRequestDispatcher("paginas/programaVisita/programaVisita.jsp").include(request, response);    
    	
	        
	        
			}else if (action.equals("guardarModificado")) {
				
				String id = request.getParameter("idd");
	    		String nombre = request.getParameter("nombres");
	    		String estadoTF = request.getParameter("estadoTF");
	    		BOGestionCategoria bo = new BOGestionCategoria();
	            Categoria categoria = new Categoria();
	            
	            categoria.setId(Integer. parseInt(id));
	            categoria.setNombreCategoria(nombre);
		        categoria.setEstadoTF(estadoTF);
	            
	            bo.guardarModificadoCategoria(categoria);

	            request.getRequestDispatcher("paginas/categoria/mantenimientoCategoria.jsp").include(request, response);
	            	
	    	}else if (action.equals("buscar")) {
	    		
	    		String cadenaBusqueda = request.getParameter("cadenaBusqueda");  
	    		BOGestionCategoria bo = new BOGestionCategoria();
		        List<Categoria> lst = bo.consultarCategorias(cadenaBusqueda);
		        request.getSession().setAttribute("lstResultadosCategoria", lst);
		        request.getRequestDispatcher("paginas/categoria/busquedaCategoria.jsp").forward(request, response);
	    			
	    	}	
	}

}

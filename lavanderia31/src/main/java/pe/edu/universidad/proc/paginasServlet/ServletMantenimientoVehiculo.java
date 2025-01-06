package pe.edu.universidad.proc.paginasServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.universidad.entidades.jdbc.Vehiculo;

/**
 * Servlet implementation class ServletMantenimientoCliente
 */
@WebServlet("/ServletMantenimientoVehiculo")
public class ServletMantenimientoVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletMantenimientoVehiculo() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action  =request.getParameter("action");
			
			if (action.equals("editar")) {
	    		
	    		int planId  =Integer.parseInt(request.getParameter("planId"));
		        BOGestionVehiculo bo = new BOGestionVehiculo();
		        List<Vehiculo> lst = bo.editarVehiculo(planId);
		        request.getSession().setAttribute("lstResultadosUsuario", lst);     
		        request.getRequestDispatcher("paginas/vehiculo/editarVehiculo.jsp").forward(request, response);     
	    	}else if (action.equals("eliminar")) {
	    		String planId  =request.getParameter("idUsuarioEliminar");
	    		BOGestionVehiculo bo = new BOGestionVehiculo();
		        bo.eliminarVehiculo(planId); 
		        request.getRequestDispatcher("paginas/vehiculo/mantenimientoVehiculo.jsp").forward(request, response);
		        
	    	}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action  =request.getParameter("action");
			if (action.equals("guardarNuevo")) {
	        String nombre = request.getParameter("nombres");
	        int idModelo = Integer.parseInt(request.getParameter("idModelo"));
	        String placa = request.getParameter("placa");
	        String estado = request.getParameter("estado");
	        BOGestionVehiculo bo = new BOGestionVehiculo();
	        Vehiculo vehiculo = new Vehiculo();
	        vehiculo.setNombre(nombre);
	        vehiculo.setIdModelo(idModelo);
	        vehiculo.setPlaca(placa);
	        vehiculo.setEstado(estado);
	        bo.registrarVehiculo(vehiculo);
	        request.getRequestDispatcher("paginas/vehiculo/mantenimientoVehiculo.jsp").include(request, response);    
    	
			}else if (action.equals("buscar")) {
    		
    		String cadenaBusqueda = request.getParameter("cadenaBusqueda");  
	        BOGestionVehiculo bo = new BOGestionVehiculo();
	        List<Vehiculo> lst = bo.consultarVehiculo(cadenaBusqueda);
	        request.getSession().setAttribute("lstResultadosUsuario", lst);
	        request.getRequestDispatcher("paginas/vehiculo/busquedaVehiculo.jsp").forward(request, response);
    			
    	}	else if (action.equals("guardarModificado")) {
    		
    		int id = Integer.parseInt(request.getParameter("id"));
	        String nombre = request.getParameter("nombres");
	        int idModelo = Integer.parseInt(request.getParameter("idModelo"));
	        String placa = request.getParameter("placa");
	        String estado = request.getParameter("estado");
            
            BOGestionVehiculo bo = new BOGestionVehiculo();
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setIdVehiculo(id);
	        vehiculo.setNombre(nombre);
	        vehiculo.setIdModelo(idModelo);
	        vehiculo.setPlaca(placa);
	        vehiculo.setEstado(estado);
	        
	        bo.guardarModificadoVehiculo(vehiculo);

            request.getRequestDispatcher("paginas/vehiculo/mantenimientoVehiculo.jsp").include(request, response);
            	
    	}
			
			
			
	}

}

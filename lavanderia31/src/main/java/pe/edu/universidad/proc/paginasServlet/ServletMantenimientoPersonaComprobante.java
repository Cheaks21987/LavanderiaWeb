package pe.edu.universidad.proc.paginasServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.universidad.entidades.jdbc.Persona;
import pe.edu.universidad.entidades.jdbc.PersonaComprobante;



@WebServlet("/ServletMantenimientoPersonaComprobante")
public class ServletMantenimientoPersonaComprobante extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletMantenimientoPersonaComprobante() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action  =request.getParameter("action");
			
			if (action.equals("editar22")) {
	    		
	    		int planId  =Integer.parseInt(request.getParameter("planId"));
		        BOGestionPersona bo = new BOGestionPersona();
		        List<Persona> lst = bo.editarPersona(planId);
		        request.getSession().setAttribute("lstResultadosPersona", lst);     
		        request.getRequestDispatcher("paginas/persona/editarPersona.jsp").forward(request, response);
		        
	    	} else if (action.equals("eliminar")) {
	    		
	    		String planId  =request.getParameter("idPersonaEliminar");
		        BOGestionPersona bo = new BOGestionPersona();
		        bo.eliminarPersona(planId); 
		        request.getRequestDispatcher("paginas/persona/mantenimientoPersona.jsp").forward(request, response);
		        
	    	}else if (action.equals("servicio")) {
	    		String idPersona  =request.getParameter("idPersona");
	    		 
		        BOGestionPersona bo = new BOGestionPersona();
		        List<PersonaComprobante> lst = bo.buscarPersonaComprobante(idPersona);
		        request.getSession().setAttribute("lstResultadosComprobante", lst);
		        //request.getRequestDispatcher("paginas/comprobanteServicio/mantenimientoComSer1.jsp").forward(request, response);
	    
	    				
	    	}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action  =request.getParameter("action");
			
			if (action.equals("guardarNuevo")) {
			
			int idPersona = Integer.parseInt(request.getParameter("idPersona"));
	        String nombrePersona = request.getParameter("nombrePersona");
	        String apellidoPaterno = request.getParameter("apellidoPaterno");
	        String apellidoMaterno = request.getParameter("apellidoMaterno");
	        int dni = Integer.parseInt(request.getParameter("dni"));
	        String direccion = request.getParameter("direccion");
	        int idDistrito = Integer.parseInt(request.getParameter("idDistrito"));
	        String correo = request.getParameter("correo");  
	        String estadoTF = request.getParameter("estadoTF");
	        String tipo = request.getParameter("tipo");
	        String fechaNacimiento = request.getParameter("fechaNacimiento");
	        
	        BOGestionPersona bo = new BOGestionPersona();
	        Persona persona = new Persona();
	        
	        persona.setIdPersona(idPersona);
	        persona.setNombrePersona(nombrePersona);
	        persona.setApellidoPaterno(apellidoPaterno);
	        persona.setApellidoMaterno(apellidoMaterno);
	        persona.setDni(dni);
	        persona.setDireccion(direccion);
	        persona.setIdDistrito(idDistrito);
	        persona.setCorreo(correo);
	        persona.setEstadoTF(estadoTF);
	        persona.setTipo(tipo);
	        persona.setFechaNacimiento(fechaNacimiento);
	        bo.registrarPersona(persona);
	        request.getRequestDispatcher("paginas/persona/mantenimientoPersona.jsp").include(request, response);    
    	
			}else if (action.equals("buscar")) {
    		
    		String cadenaBusqueda = request.getParameter("cadenaBusqueda");  
	        BOGestionPersona bo = new BOGestionPersona();
	        List<Persona> lst = bo.buscarPersona(cadenaBusqueda);
	        request.getSession().setAttribute("lstResultadosPersona", lst);
	        request.getRequestDispatcher("paginas/persona/busquedaPersona.jsp").forward(request, response);
    			
    	}	else if (action.equals("guardarModificado")) {
    		
    		int idPersona = Integer.parseInt(request.getParameter("idPersona"));
	        String nombrePersona = request.getParameter("nombrePersona");
	        String apellidoPaterno = request.getParameter("apellidoPaterno");
	        String apellidoMaterno = request.getParameter("apellidoMaterno");
	        int dni = Integer.parseInt(request.getParameter("dni"));
	        String direccion = request.getParameter("direccion");
	        int idDistrito = Integer.parseInt(request.getParameter("idDistrito"));
	        String correo = request.getParameter("correo");  
	        String estadoTF = request.getParameter("estadoTF");
	        String tipo = request.getParameter("tipo");
	        String fechaNacimiento = request.getParameter("fechaNacimiento");
            
            BOGestionPersona bo = new BOGestionPersona();
            Persona persona = new Persona();
            persona.setIdPersona(idPersona);
	        persona.setNombrePersona(nombrePersona);
	        persona.setApellidoPaterno(apellidoPaterno);
	        persona.setApellidoMaterno(apellidoMaterno);
	        persona.setDni(dni);
	        persona.setDireccion(direccion);
	        persona.setIdDistrito(idDistrito);
	        persona.setCorreo(correo);
	        persona.setEstadoTF(estadoTF);
	        persona.setTipo(tipo);
	        persona.setFechaNacimiento(fechaNacimiento);
           
            
            bo.guardarModificadoPersona(persona);

            request.getRequestDispatcher("paginas/persona/mantenimientoPersona.jsp").include(request, response);
            	
    	}
			
			
			
	}

}

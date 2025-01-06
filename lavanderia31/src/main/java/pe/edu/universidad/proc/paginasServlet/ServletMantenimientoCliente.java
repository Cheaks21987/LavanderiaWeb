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

import pe.edu.universidad.entidades.jdbc.Usuario;

/**
 * Servlet implementation class ServletMantenimientoCliente
 */
@WebServlet("/ServletMantenimientoCliente")
public class ServletMantenimientoCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletMantenimientoCliente() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action  =request.getParameter("action");
			
			if (action.equals("editar")) {
	    		
	    		String planId  =request.getParameter("planId");
		        BOGestionUsuario bo = new BOGestionUsuario();
		        List<Usuario> lst = bo.editarUsuarios(planId);
		        request.getSession().setAttribute("lstResultadosUsuario", lst);     
		        request.getRequestDispatcher("paginas/usuario/editarUsuario.jsp").forward(request, response);
		        
	    	} else if (action.equals("eliminar")) {
	    		
	    		String planId  =request.getParameter("idUsuarioEliminar");
		        BOGestionUsuario bo = new BOGestionUsuario();
		        bo.eliminarUsuario(planId); 
		        request.getRequestDispatcher("paginas/usuario/mantenimientoUsuario.jsp").forward(request, response);
		        
	    	}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action  =request.getParameter("action");
			
			if (action.equals("guardarNuevo")) {
	        String nombre = request.getParameter("nombres");
	        String apePat = request.getParameter("apePat");
	        String apeMat = request.getParameter("apeMat");
	        String direccion = request.getParameter("direccion");
	        int telefono = Integer.parseInt(request.getParameter("telefono"));
	        String fecha0 = request.getParameter("fechaNac");  
	        String correo = request.getParameter("correo");
	        int dni = Integer.parseInt(request.getParameter("dni"));  
	        BOGestionUsuario bo = new BOGestionUsuario();
	        Usuario usuario = new Usuario();
	        usuario.setIdUsuario("c"+String.valueOf(dni));
	        usuario.setNombre(nombre);
	        usuario.setApePat(apePat);
	        usuario.setApeMat(apeMat);
	        usuario.setDireccion(direccion);
	        usuario.setTelefono(telefono);
	        try {
				SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yy"); 
				Date fecha1 = formato.parse(fecha0);
				usuario.setFecha(fecha1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        
	        usuario.setCorreo(correo);
	        usuario.setDni(dni);
	        bo.registrarUsuario(usuario );
	        request.getRequestDispatcher("paginas/usuario/mantenimientoUsuario.jsp").include(request, response);    
    	
			}else if (action.equals("buscar")) {
    		
    		String cadenaBusqueda = request.getParameter("cadenaBusqueda");  
	        BOGestionUsuario bo = new BOGestionUsuario();
	        List<Usuario> lst = bo.consultarUsuarios(cadenaBusqueda);
	        request.getSession().setAttribute("lstResultadosUsuario", lst);
	        request.getRequestDispatcher("paginas/usuario/busquedaUsuario.jsp").forward(request, response);
    			
    	}	else if (action.equals("guardarModificado")) {
    		
    		String nombre = request.getParameter("nombres");
            String apePat = request.getParameter("apePat");
            String apeMat = request.getParameter("apeMat");
            String direccion = request.getParameter("direccion");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            String fecha0 = request.getParameter("fechaNac");  
            String correo = request.getParameter("correo");
            int dni = Integer.parseInt(request.getParameter("dni"));
            
            BOGestionUsuario bo = new BOGestionUsuario();
            Usuario usuario = new Usuario();
            usuario.setIdUsuario("c"+String.valueOf(dni));
            usuario.setNombre(nombre);
            usuario.setApePat(apePat);
            usuario.setApeMat(apeMat);
            usuario.setDireccion(direccion);
            usuario.setTelefono(telefono);
            try {
    			SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yy"); 
    			Date fecha1 = formato.parse(fecha0);
    			usuario.setFecha(fecha1);
    		} catch (ParseException e) {
    			e.printStackTrace();
    		}
            
            usuario.setCorreo(correo);
            usuario.setDni(dni);
            
            bo.guardarModificadoUsuario(usuario);

            request.getRequestDispatcher("paginas/usuario/mantenimientoUsuario.jsp").include(request, response);
            	
    	}
			
			
			
	}

}

package pe.edu.universidad.proc.paginasServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.universidad.entidades.jdbc.Servicio;



@WebServlet("/ServletMantenimientoServicio")
public class ServletMantenimientoServicio extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletMantenimientoServicio() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action  =request.getParameter("action");
        
        if (action.equals("editar")) {
            
            int planId  =Integer.parseInt(request.getParameter("planId"));
            BOGestionServicio bo = new BOGestionServicio();
            List<Servicio> lst = bo.editarServicio(planId);
            request.getSession().setAttribute("lstResultadosUsuario", lst);     
            request.getRequestDispatcher("paginas/servicio/editarServicio.jsp").forward(request, response);
        } else if (action.equals("eliminar")) {
    		String planId  =request.getParameter("idUsuarioEliminar");
    		BOGestionServicio bo = new BOGestionServicio();
	        bo.eliminarServicio(planId); 
	        request.getRequestDispatcher("paginas/servicio/mantenimientoServicio.jsp").forward(request, response);
	        
    	}
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("guardarNuevo")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String estado = request.getParameter("estado");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
            String nombre = request.getParameter("nombreServicio");
           
            BOGestionServicio bo = new BOGestionServicio();
            Servicio servicio = new Servicio();
            
            servicio.setIdServicio(id);
            servicio.setPrecio(precio);
            servicio.setIdCategoria(idCategoria);
            servicio.setEstado(estado);
            servicio.setNombreServicio(nombre);

            bo.registrarServicio(servicio);
            request.getRequestDispatcher("paginas/servicio/mantenimientoServicio.jsp").include(request, response);    
        
            }else if (action.equals("guardarModificado")) {
                
            	int id = Integer.parseInt(request.getParameter("id"));
                String estado = request.getParameter("estado");
                Double precio = Double.parseDouble(request.getParameter("precio"));
                int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
                String nombre = request.getParameter("nombreServicio");

                BOGestionServicio bo = new BOGestionServicio();
                Servicio servicio = new Servicio();
                
                servicio.setIdServicio(id);
                servicio.setPrecio(precio);
                servicio.setIdCategoria(idCategoria);
                servicio.setEstado(estado);
                servicio.setNombreServicio(nombre);
                bo.guardarModificadoServicio(servicio);

                request.getRequestDispatcher("paginas/servicio/mantenimientoServicio.jsp").include(request, response);
                    
            }
            else if (action.equals("buscar")) {
        
                String cadenaBusqueda = request.getParameter("cadenaBusqueda");
                BOGestionServicio bo = new BOGestionServicio();
                List<Servicio> lst = bo.buscarServicio(cadenaBusqueda);
                request.getSession().setAttribute("lstResultadosUsuario", lst);
                request.getRequestDispatcher("paginas/servicio/busquedaServicio.jsp").forward(request, response);
                
            }
    }

}

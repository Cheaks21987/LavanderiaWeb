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

import pe.edu.universidad.entidades.jdbc.SerPro;

@WebServlet("/ServletMantenimientoSerPro")
public class ServletMantenimientoSerPro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletMantenimientoSerPro() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action  =request.getParameter("action");
		
		if (action.equals("editar")) {
    		
    		String SerPro  =request.getParameter("planId");
	        BOGestionSerPro bo = new BOGestionSerPro();
	        List<SerPro> lst = bo.editarSerPro(SerPro);
	        request.getSession().setAttribute("lstResultadosSerPro", lst);     
	        request.getRequestDispatcher("paginas/controlServicio/editarSerPro.jsp").forward(request, response);
	        
    	}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action  =request.getParameter("action");
		
		if (action.equals("guardarNuevo")) {
	        String comprobanteDelivery = request.getParameter("comprobanteDelivery");
	        String estadoDelivery = request.getParameter("estadoDelivery");
	        String comprobanteServicio = request.getParameter("comprobanteServicio");
	        String estadoServicio = request.getParameter("estadoServicio");
	        Double total = Double.parseDouble(request.getParameter("total"));
	        String idCliente = request.getParameter("idCliente");  
	        String idAdministrador = request.getParameter("idAdministrador");
	        String idChofer = request.getParameter("idChofer");  
	        String idVehiculo = request.getParameter("idVehiculo");

	        BOGestionSerPro bo = new BOGestionSerPro();
	        SerPro serpro = new SerPro();
	        serpro.setComprobanteDelivery(comprobanteDelivery);
	        serpro.setEstadoDelivery(estadoDelivery);
	        serpro.setComprobanteServicio(comprobanteServicio);
	        serpro.setEstadoServicio(estadoServicio);
	        serpro.setTotal(total);
	        serpro.setIdCl(idCliente);
	        serpro.setIdAd(Integer.parseInt(idAdministrador));
	        serpro.setIdCh(Integer.parseInt(idChofer));
	        serpro.setIdVe(Integer.parseInt(idVehiculo));

	        bo.registrarSerPro(serpro);
	        
	        request.getRequestDispatcher("paginas/controlServicio/mantenimientoSerPro.jsp").include(request, response);    
    	
			}else if (action.equals("buscar")) {
	    		
	    		String cadenaBusqueda = request.getParameter("cadenaBusqueda");  
		        BOGestionSerPro bo = new BOGestionSerPro();
		        List<SerPro> lst = bo.buscarSerPro(cadenaBusqueda);
		        request.getSession().setAttribute("lstResultadosUsuario", lst);
		        request.getRequestDispatcher("paginas/controlServicio/busquedaSerPro.jsp").forward(request, response);
	    			
	    	}
	}

}

package pe.edu.universidad.proc.paginasServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import pe.edu.universidad.entidades.jdbc.ComprobanteServicio;




@WebServlet("/ServletMantenimientoComprobanteServicio")
public class ServletMantenimientoComprobanteServicio extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletMantenimientoComprobanteServicio() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("guardarNuevo")) {
        	
            int idC = Integer.parseInt(request.getParameter("idC"));
            int idP = Integer.parseInt(request.getParameter("idP"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            int idS = Integer.parseInt(request.getParameter("idS"));
            int idPe = Integer.parseInt(request.getParameter("idPe"));
            String estado = request.getParameter("estado");
            
            BOComprobanteServicio bo = new BOComprobanteServicio();
            ComprobanteServicio comprobanteServicio = new ComprobanteServicio();
            
            comprobanteServicio.setIdComprobante(idC);
            comprobanteServicio.setIdPrenda(idP);
            comprobanteServicio.setCantidad(cantidad);
            comprobanteServicio.setIdServicio(idS);
            comprobanteServicio.setEstadoTF(estado);
            comprobanteServicio.setIdPersona(idPe);

            bo.registrarComprobanteServicio(comprobanteServicio);
            request.getRequestDispatcher("paginas/comprobanteServicio/mantenimientoComSer.jsp").include(request, response);    
        
            }else if (action.equals("buscar")) {
        
                int cadenaBusqueda = Integer.parseInt(request.getParameter("cadenaBusqueda"));
                BOComprobanteServicio bo = new BOComprobanteServicio();
                List<ComprobanteServicio> lst = bo.buscarComprobanteServicio(cadenaBusqueda);
                request.getSession().setAttribute("lstResultadosUsuario", lst);
                request.getRequestDispatcher("paginas/comprobanteServicio/busquedaComSer.jsp").forward(request, response);
            }else if (action.equals("calcularTotal")) {
            	int idPe = Integer.parseInt(request.getParameter("idPe"));
            	BOComprobanteServicio bo = new BOComprobanteServicio();
                List<ComprobanteServicio> lst = bo.calcularTotal(idPe);
                ComprobanteServicio comprobanteServicio = new ComprobanteServicio();
                
                comprobanteServicio.setIdPersona(idPe);
                request.getSession().setAttribute("lstResultadosUsuario", lst);
                request.getRequestDispatcher("paginas/comprobanteServicio/busquedaComSer.jsp").forward(request, response);
            
            }else if (action.equals("buscarServicio")) {//para el comprobante
        
                int idComprobante = Integer.parseInt(request.getParameter("idComprobante"));
                BOComprobanteServicio bo = new BOComprobanteServicio();
                List<ComprobanteServicio> lst = bo.buscarComprobanteServicioRopa(idComprobante);
                List<ComprobanteServicio> lstTotal = bo.buscarTotal(idComprobante);
                List<ComprobanteServicio> lstPrendaComprobante = bo.PrendaComprobante(idComprobante);
                request.getSession().setAttribute("lstPrendaComprobante", lstPrendaComprobante);
                request.getSession().setAttribute("lstTotal", lstTotal);
                request.getSession().setAttribute("lstCSR", lst);
                ComprobanteServicio u = new ComprobanteServicio();
                u.setIdComprobante(idComprobante);
                List<ComprobanteServicio> lst2 = new ArrayList<ComprobanteServicio>();
                lst2.add(u);
                request.getSession().setAttribute("num26", lst2);
                request.getRequestDispatcher("paginas/comprobanteServicio/mantenimientoComSer2.jsp").forward(request, response);
            
            }else if (action.equals("guardarComprobanteServicio")) {
                
            	int idC = Integer.parseInt(request.getParameter("idComprobante"));
                int idS = Integer.parseInt(request.getParameter("idServicio"));
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                int idP = Integer.parseInt(request.getParameter("idPrenda"));
                
                
                BOComprobanteServicio bo = new BOComprobanteServicio();
                ComprobanteServicio comprobanteServicio = new ComprobanteServicio();
                
                comprobanteServicio.setIdComprobante(idC);
                comprobanteServicio.setIdPrenda(idP);
                comprobanteServicio.setCantidad(cantidad);
                comprobanteServicio.setIdServicio(idS);
                bo.guardarComprobanteServicio(comprobanteServicio);
                
                int idComprobante = idC;

                List<ComprobanteServicio> lst = bo.buscarComprobanteServicioRopa(idComprobante);
                List<ComprobanteServicio> lstTotal = bo.buscarTotal(idComprobante);
                List<ComprobanteServicio> lstPrendaComprobante = bo.PrendaComprobante(idComprobante);
                request.getSession().setAttribute("lstPrendaComprobante", lstPrendaComprobante);
                request.getSession().setAttribute("lstTotal", lstTotal);
                request.getSession().setAttribute("lstCSR", lst);
                ComprobanteServicio u = new ComprobanteServicio();
                u.setIdComprobante(idComprobante);
                List<ComprobanteServicio> lst2 = new ArrayList<ComprobanteServicio>();
                lst2.add(u);
                request.getSession().setAttribute("num26", lst2);
                request.getRequestDispatcher("paginas/comprobanteServicio/cerrar.jsp").forward(request, response);
             
            }else if (action.equals("generarReporte1")) {
                             
                request.getSession().setAttribute("nCategoria", request.getParameter("nCategoria").trim());
                request.getSession().setAttribute("nServicio", request.getParameter("nServicio").trim());
                request.getSession().setAttribute("fecha1", request.getParameter("fecha1").trim());
                request.getSession().setAttribute("fecha2", request.getParameter("fecha2").trim());
                
                request.getRequestDispatcher("reporteResultados/reporte.jsp").forward(request, response);
                
        	}else if (action.equals("generarReporte2")) {
                
			   request.getSession().setAttribute("idCliente", request.getParameter("idCliente").trim());
			   request.getSession().setAttribute("monto1", request.getParameter("monto1").trim());
			   request.getSession().setAttribute("monto2", request.getParameter("monto2").trim());
			   request.getSession().setAttribute("fecha1", request.getParameter("fecha1").trim());
			   request.getSession().setAttribute("fecha2", request.getParameter("fecha2").trim());
			   
			   request.getRequestDispatcher("reporteResultados/reporte2.jsp").forward(request, response);
			   
			}else if (action.equals("editarEstadoComprobante")) {
        
                int idC = Integer.parseInt(request.getParameter("idC"));
                String estado = request.getParameter("estado");
                
                BOComprobanteServicio bo = new BOComprobanteServicio();
                ComprobanteServicio comprobanteServicio = new ComprobanteServicio();
                
                comprobanteServicio.setIdComprobante(idC);
                comprobanteServicio.setEstadoTF(estado);
                bo.editarComprobanteEstado(comprobanteServicio);
                request.getRequestDispatcher("paginas/comprobanteServicio/comprobantes.jsp").include(request, response);    
               }
        
        
    }
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String action  =request.getParameter("action");
    
    if (action.equals("editar")) {
        
        int planId  = Integer.parseInt(request.getParameter("planId"));
        BOComprobanteServicio bo = new BOComprobanteServicio();
        List<ComprobanteServicio> lst = bo.editarComprobanteServicios(planId);
        request.getSession().setAttribute("lstResultadosUsuario", lst);     
        request.getRequestDispatcher("paginas/comprobanteServicio/editarComSer.jsp").forward(request, response);
        
    } else if (action.equals("guardarModificado")) {
        
    	int idC = Integer.parseInt(request.getParameter("idC"));
        int idP = Integer.parseInt(request.getParameter("idP"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        int idS = Integer.parseInt(request.getParameter("idS"));
        String estado = request.getParameter("estado");
        int idPe = Integer.parseInt(request.getParameter("idPe"));
        
        
        BOComprobanteServicio bo = new BOComprobanteServicio();
        ComprobanteServicio comprobanteServicio = new ComprobanteServicio();
        
        comprobanteServicio.setIdComprobante(idC);
        comprobanteServicio.setIdPrenda(idP);
        comprobanteServicio.setCantidad(cantidad);
        comprobanteServicio.setIdServicio(idS);
        comprobanteServicio.setEstadoTF(estado);
        comprobanteServicio.setIdPersona(idPe);
        
        bo.guardarModificadoComprobanteServicio(comprobanteServicio);

        request.getRequestDispatcher("paginas/comprobanteServicio/mantenimientoComSer.jsp").include(request, response);
            
    }else if (action.equals("editarEstadoComprobante")) {
        
        int idC = Integer.parseInt(request.getParameter("idC"));
        String estado = request.getParameter("estado");
        
        BOComprobanteServicio bo = new BOComprobanteServicio();
        ComprobanteServicio comprobanteServicio = new ComprobanteServicio();
        
        comprobanteServicio.setIdComprobante(idC);
        comprobanteServicio.setEstadoTF(estado);
        bo.editarComprobanteEstado(comprobanteServicio);
        request.getRequestDispatcher("paginas/comprobanteServicio/comprobantes.jsp").include(request, response);    
       
    } else if (action.equals("eliminar")) {
		String planId  =request.getParameter("idComprobanteEliminar");
		BOComprobanteServicio bo = new BOComprobanteServicio();
        bo.eliminarComprobanteServicio(planId); 
        request.getRequestDispatcher("paginas/comprobanteServicio/mantenimientoComSer.jsp").forward(request, response);
        
	}else if (action.equals("eliminarSs")) {
    	int idC  =Integer.parseInt(request.getParameter("idComprobante"));
    	int idS  =Integer.parseInt(request.getParameter("idServicio"));
    	int idP  =Integer.parseInt(request.getParameter("idPrenda"));
		BOComprobanteServicio bo = new BOComprobanteServicio();
        bo.eliminarSs(idC,idS,idP); 

        int idComprobante = idC;
        
        List<ComprobanteServicio> lst = bo.buscarComprobanteServicioRopa(idComprobante);
        List<ComprobanteServicio> lstTotal = bo.buscarTotal(idComprobante);
        List<ComprobanteServicio> lstPrendaComprobante = bo.PrendaComprobante(idComprobante);
        request.getSession().setAttribute("lstPrendaComprobante", lstPrendaComprobante);
        request.getSession().setAttribute("lstTotal", lstTotal);
        request.getSession().setAttribute("lstCSR", lst);
        ComprobanteServicio u = new ComprobanteServicio();
        u.setIdComprobante(idComprobante);
        List<ComprobanteServicio> lst2 = new ArrayList<ComprobanteServicio>();
        lst2.add(u);
        request.getSession().setAttribute("num26", lst2);
        request.getRequestDispatcher("paginas/comprobanteServicio/cerrar.jsp").forward(request, response);
     
	}else if (action.equals("nuevoR")) {
        
        int idComprobante  = Integer.parseInt(request.getParameter("idCliente"));//idCleinte=comprobante
        
        List<ComprobanteServicio> lst = new ArrayList<ComprobanteServicio>();
        ComprobanteServicio u = new ComprobanteServicio();
        u.setIdPersona(idComprobante);
        lst.add(u);
        request.getSession().setAttribute("lstCliente", lst);     
        request.getRequestDispatcher("paginas/prenda/registrarNuevoPrenda.jsp").forward(request, response);
        
        
	}else if (action.equals("comprobantes")) {
        
        int idComprobante  = Integer.parseInt(request.getParameter("idCliente"));//idCleinte=comprobante
        
        List<ComprobanteServicio> lst = new ArrayList<ComprobanteServicio>();
        ComprobanteServicio u = new ComprobanteServicio();
        u.setIdPersona(idComprobante);
        lst.add(u);
        request.getSession().setAttribute("lstCliente", lst);     
        request.getRequestDispatcher("paginas/prenda/registrarNuevoPrenda.jsp").forward(request, response);
	
	}
    
        
	}
}



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
import pe.edu.universidad.entidades.jdbc.Prenda;


/**
 * Servlet implementation class ServletMantenimientoPrenda
 */
@WebServlet("/ServletMantenimientoPrenda")
public class ServletMantenimientoPrenda extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletMantenimientoPrenda() {
        super();
    }
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action  =request.getParameter("action");
            
            if (action.equals("editar")) {
                
                String planId  =request.getParameter("planId");
                BOGestionPrenda bo = new BOGestionPrenda();
                List<Prenda> lst = bo.editarPrenda(planId);
                request.getSession().setAttribute("lstResultadosPrenda", lst);     
                request.getRequestDispatcher("paginas/prenda/editarPrenda.jsp").forward(request, response);
                
            } else if (action.equals("eliminar")) {
                
                String planId  =request.getParameter("idPrendaEliminar");
                BOGestionPrenda bo = new BOGestionPrenda();
                bo.eliminarPrenda(planId); 
                request.getRequestDispatcher("paginas/prenda/mantenimientoPrenda.jsp").forward(request, response);
                
            }
        
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action  =request.getParameter("action");
            if (action.equals("guardarNuevo")) {
            String nombrePrenda = request.getParameter("nombrePrenda");
            int idMarca = Integer.parseInt(request.getParameter("idMarca"));
            int idMaterial = Integer.parseInt(request.getParameter("idMaterial"));
            int idColor = Integer.parseInt(request.getParameter("idColor"));
            String observacion = request.getParameter("observacion");  
            String estadoTF = request.getParameter("estadoTF");  
            
            int idC = Integer.parseInt(request.getParameter("idCliente"));
            int idS = Integer.parseInt(request.getParameter("idServicio"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            
            BOGestionPrenda bo = new BOGestionPrenda();
            Prenda prenda = new Prenda();
            
            prenda.setNombrePrenda(nombrePrenda); 
            prenda.setIdMarca(idMarca);
            prenda.setIdMaterial(idMaterial);
            prenda.setIdColor(idColor);
            prenda.setObservacion(observacion);
            prenda.setEstadoTF(estadoTF);
            
            prenda.setIdC(idC);
            prenda.setIdS(idS);
            prenda.setCantidad(cantidad);
                   
            bo.registrarPrenda(prenda);
            
            BOComprobanteServicio bo2 = new BOComprobanteServicio();
            
            int idComprobante = idC;
            
            List<ComprobanteServicio> lst = bo2.buscarComprobanteServicioRopa(idComprobante);
            List<ComprobanteServicio> lstTotal = bo2.buscarTotal(idComprobante);
            List<ComprobanteServicio> lstPrendaComprobante = bo2.PrendaComprobante(idComprobante);
            request.getSession().setAttribute("lstPrendaComprobante", lstPrendaComprobante);
            request.getSession().setAttribute("lstTotal", lstTotal);
            request.getSession().setAttribute("lstCSR", lst);
            ComprobanteServicio u = new ComprobanteServicio();
            u.setIdComprobante(idComprobante);
            List<ComprobanteServicio> lst2 = new ArrayList<ComprobanteServicio>();
            lst2.add(u);
            request.getRequestDispatcher("paginas/comprobanteServicio/cerrar.jsp").include(request, response);
            
        
            }else if (action.equals("buscar")) {
            
            String cadenaBusqueda = request.getParameter("cadenaBusqueda");  
            BOGestionPrenda bo = new BOGestionPrenda();
            List<Prenda> lst = bo.buscarPrenda(cadenaBusqueda);
            request.getSession().setAttribute("lstResultadosPrenda", lst);
            request.getRequestDispatcher("paginas/prenda/busquedaPrenda.jsp").forward(request, response);
                
        }   else if (action.equals("guardarModificado")) {
            
            int idPrenda = Integer.parseInt(request.getParameter("idPrenda"));
            String nombrePrenda = request.getParameter("nombrePrenda");
            int idMarca = Integer.parseInt(request.getParameter("idMarca"));
            int idMaterial = Integer.parseInt(request.getParameter("idMaterial"));
            int idColor = Integer.parseInt(request.getParameter("idColor"));
            String observacion = request.getParameter("observacion");  
            String estadoTF = request.getParameter("estadoTF");
            
            
            BOGestionPrenda bo = new BOGestionPrenda();
            Prenda prenda = new Prenda();
            
            prenda.setIdPrenda(idPrenda);
            prenda.setNombrePrenda(nombrePrenda);
            prenda.setIdMarca(idMarca);
            prenda.setIdMaterial(idMaterial);
            prenda.setIdColor(idColor);
            prenda.setObservacion(observacion);
            prenda.setEstadoTF(estadoTF);
            
           
             
            bo.guardarModificadoPrenda(prenda);

            request.getRequestDispatcher("paginas/prenda/mantenimientoPrenda.jsp").include(request, response);
                
        }
            
            
            
    }

}

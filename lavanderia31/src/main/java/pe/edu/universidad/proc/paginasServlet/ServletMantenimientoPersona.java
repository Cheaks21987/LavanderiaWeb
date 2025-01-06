package pe.edu.universidad.proc.paginasServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.universidad.entidades.jdbc.ComprobanteServicio;
import pe.edu.universidad.entidades.jdbc.Persona;
import pe.edu.universidad.entidades.jdbc.PersonaComprobante;
import pe.edu.universidad.entidades.jdbc.ProgramaVisita;
import pe.edu.universidad.entidades.jdbc.Servicio;

/**
 * Servlet implementation class ServletMantenimientoCliente
 */


@WebServlet(name="ServletMantenimientoPersona", urlPatterns={"ServletMantenimientoPersona"})
public class ServletMantenimientoPersona extends javax.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int idClienteActivo=0;

    public ServletMantenimientoPersona() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String action  =request.getParameter("action");
			
			if (action.equals("buscarJ")) {
				
			response.setContentType("text/html;charset=UTF-8");
			
	        try (PrintWriter out = response.getWriter()) {
	        	
	        	String filtro = request.getParameter("filtro");

		        BOGestionPersona bo = new BOGestionPersona();
		        List<Persona> lst = bo.buscarPersona(filtro);
		        request.getSession().setAttribute("lstResultadosPersona", lst);
		        
		        for (Persona u : lst) {
		        out.println("<table border=0><td style=\"width:10%;background-color:#191970;font-weight: bold;font-size:20px;color:white;\">");
		        out.println("Id:"+"</td><td style=\"width:10%;font-weight: bold;font-size:20px\">"+ u.getIdPersona());
		        out.println("</td><td style=\"width:15%;background-color:#191970;font-weight: bold;font-size:20px;color:white;\">");
		        idClienteActivo=u.getIdPersona();
		        out.println("Nombre:</td><td style=\"width:35%;font-weight: bold;font-size:20px\">"+ u.getNombrePersona()+" "+u.getApellidoPaterno()+" "+u.getApellidoMaterno()+"<br>");
		        
		        out.println("");
		        int idPersona  =u.getIdPersona(); 
		        List<PersonaComprobante> lst2 = bo.buscarPersonaComprobante(String.valueOf(idPersona));
		        request.getSession().setAttribute("lstResultadosComprobante", lst2);
		        out.println("</td><td style=\"width:20%;background-color:#191970;font-weight: bold;font-size:20px;color:white;\">");
		        out.println("Comprobante:");
		        out.println("</td><td style=\"width:18%\">");
		        out.println(" <select id=\"framework2\" class=\"form-control manUsuForm btn-primary\" style=\"width:100px;\">");
		        for (PersonaComprobante u2 : lst2) {
		        	out.println("<option class=\"form-control\" value="+u2.getIdComprobante()+">"+ u2.getIdComprobante());	
		        }
		        out.println("</select>\r\n");
		        
		        out.println("<td>");
		        out.println("<button id=\"btn2\" onclick=\"setTimeout(buscar2,0)\" class=\"btn manUsuForm btn-primary py-2 px-4\">Buscar</button>");
		        out.println("</td>");
		        out.println("</td></table>");
		        //--------------------------------------- js ---------------------------------------
		    
		        
		        out.println("");
		       
		        
		        //--------------------------------------- -- ---------------------------------------
		        }
	            
	        } catch (Exception e) {
	           
	        }
	        
			}else if (action.equals("buscarClienteLavanderia")) {
				
			response.setContentType("text/html;charset=UTF-8");
			
	        try (PrintWriter out = response.getWriter()) {
	        	
	        	String filtro = request.getParameter("filtro");

		        BOGestionPersona bo = new BOGestionPersona();
		        List<Persona> lst = bo.buscarPersona(filtro);
		        request.getSession().setAttribute("lstResultadosPersona", lst);
		        
		        for (Persona u : lst) {
		        out.println("<table border=0><td style=\"width:10%;background-color:#191970;font-weight: bold;font-size:20px;color:white;\">");
		        out.println("Id:"+"</td><td style=\"width:10%;font-weight: bold;font-size:20px\"><input type=\"text\" id=\"idCliente\" value="+ u.getIdPersona()+" />");
		        out.println("</td><td style=\"width:15%;background-color:#191970;font-weight: bold;font-size:20px;color:white;\">");
		        idClienteActivo=u.getIdPersona();
		        out.println("Nombre:</td><td style=\"width:35%;font-weight: bold;font-size:20px\">"+ u.getNombrePersona()+" "+u.getApellidoPaterno()+" "+u.getApellidoMaterno()+"<br>");
		        
		        out.println("");
		        int idPersona  =u.getIdPersona(); 
		        List<PersonaComprobante> lst2 = bo.buscarPersonaComprobante(String.valueOf(idPersona));
		        request.getSession().setAttribute("lstResultadosComprobante", lst2);
		        out.println("</td>");
		       
		        
		        out.println("<td>");
		        out.println("<button id=\"btn2\" onclick=\"setTimeout(buscarCrear,0)\" class=\"btn manUsuForm btn-primary py-2 px-4\">Nuevo</button>");
		        out.println("</td>");
		        out.println("</td></table>");
		        //--------------------------------------- js ---------------------------------------
		    
		        
		        out.println("");
		       
		        
		        //--------------------------------------- -- ---------------------------------------
		        }
	            
	        } catch (Exception e) {
	           
	        }
	        	} else if (action.equals("editar")) {
	    		
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
		        
	    	} else if (action.equals("buscarCF")) {
	    		
	    		int idComprobante = Integer.parseInt(request.getParameter("filtro"));
	    		
                BOComprobanteServicio bo = new BOComprobanteServicio();
                List<ComprobanteServicio> lst = bo.buscarComprobanteServicioRopa(idComprobante);
                List<ComprobanteServicio> lstTotal = bo.buscarTotal(idComprobante);
                List<ComprobanteServicio> lstPrendaComprobante = bo.PrendaComprobante(idComprobante);
                request.getSession().setAttribute("lstPrendaComprobante", lstPrendaComprobante);
                request.getSession().setAttribute("lstTotal", lstTotal);
                request.getSession().setAttribute("lstCSR", lst);
                
                BOGestionServicio bo3 = new BOGestionServicio();
            	List<Servicio> lst3 = bo3.consultarServicio();
                
                ComprobanteServicio u = new ComprobanteServicio();
                u.setIdComprobante(idComprobante);
                List<ComprobanteServicio> lst2 = new ArrayList<ComprobanteServicio>();
                lst2.add(u);
                request.getSession().setAttribute("num26", lst2);
                
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                	
                out.println("<center><form action=\"../../ServletMantenimientoComprobanteServicio?action=guardarComprobanteServicio&idComprobante="+idComprobante+"\"  target=\"_blank\"   method=\"post\">");
                out.println("<br><center><h2>Ingreso de Ropa</h2></center><table border=1 style=\"width:85%\">\r\n"
                		+ "					<tr>\r\n"
                		+ "						<td class=\"cabeceraProgracionVisitas\" style=\"width: 24%;\">Servicio</td>\r\n"
                		+ "						<td class=\"cabeceraProgracionVisitas\" style=\"width: 24%;\" colspan=\"2\">Prenda</td>\r\n"
                		+ "						<td class=\"cabeceraProgracionVisitas\" style=\"width: 24%;\" >Cantidad</td>\r\n"
                		+ "						<td class=\"cabeceraProgracionVisitas\" style=\"width: 24%;\" ></td>\r\n"
                		+ "\r\n"
                		+ "					</tr>");
                
                out.println("<tr>\r\n"
                		+ "	<td><select name=\"idServicio\" class=\"form-control\" style=\"width: 90%;\">");
                
                //Lista de servicios
                for (Servicio u3 : lst3) {
                out.println("<option value="+u3.getIdServicio()+" >"+u3.getNombreServicio()+" S/."+u3.getPrecio()+"");
                }
                out.println("</option>");
                out.println("</select></td>");
                
                //lista de prendas para el cliente
                out.println("<td><select name=\"idPrenda\" class=\"form-control\" style=\"width: 90%;\">");
                for (ComprobanteServicio u4 : lstPrendaComprobante) {
                out.println("<option value="+u4.getIdPrenda()+" >"+u4.getNombrePrenda()+"</option>");
                }
                out.println("");
                out.println("</select></td>");
                
                out.println("");
                
                //agregar nueva prenda para el cliente
                out.println("<td><a\r\n"
                		+ "									href=\"../../ServletMantenimientoComprobanteServicio?action=nuevoR&idCliente="+idComprobante+"\"\r\n"
                		+ "									 target=\"_blank\" class=\"btn btn-primary py-2 px-3\"\r\n"
                		+ "									style=\"background-color: #57a639; border-color: #57a639;\">\r\n"
                		+ "									<b>+</b>\r\n"
                		+ "								</a></td>");
                
                //cantidad
                out.println("<td><input type=\"number\" class=\"form-control\" placeholder=\"\"\r\n"
                		+ "							name=\"cantidad\" style=\"width: 100%;\" required></td>");
                
                //boton para nuevo
                out.println("<td><button id=\"btn2\" class=\"btn manUsuForm btn-primary py-2 px-4\" onclick=\"buscarPrueba();\">Agregar</button> <input type=\"button\" class=\"btn manUsuForm btn-primary py-2 px-4\" value=\"Actualizar\" onclick=\"actualizarC("+idComprobante+");\"> </td>");
                
               																					
                
                out.println("</tr>");
                out.println("</table>");
                out.println("</form>");
                
                
                out.println("<br><center><h2>Comprobante</h2></center><table  style=\"width:85%\" border=1 style=\"display: flex; justify-content: center; text-align: center;\">\r\n"
                		+ "								<tr>\r\n"
                		+ "									<td class=\"cabeceraProgracionVisitas\" style=\"width: 200px;\">Servicio</td>\r\n"
                		+ "									<td class=\"cabeceraProgracionVisitas\" style=\"width: 200px;\">Prenda</td>\r\n"
                		+ "									<td class=\"cabeceraProgracionVisitas\">Cantidad</td>\r\n"
                		+ "									<td class=\"cabeceraProgracionVisitas\" style=\"width: 200px;\">Subtotal</td>\r\n"

                		+ "									<td class=\"cabeceraProgracionVisitas\">Quitar</td>\r\n"
                		+ "								</tr>");
                
                for (ComprobanteServicio r : lst) {
                out.println("");
                out.println("<tr>\r\n"
                		+ "										<td>"+r.getNombreServicio()+"</td>\r\n"
                		+ "										<td>"+r.getNombrePrenda()+"</td>\r\n"
                		+ "										<td>"+r.getCantidad()+"</td>\r\n"
                		+ "										<td>"+r.getSubtotal()+"</td>\r\n"

                		+ "										<td><a\r\n"
                		+ "											target=\"_blank\" href=\"../../ServletMantenimientoComprobanteServicio?action=eliminarSs&idComprobante="+r.getIdComprobante()+"&idServicio="+r.getIdServicio()+"&idPrenda="+r.getIdPrenda()+"\">eliminar</a></td>\r\n"
                		+ "									</tr>");
                //total
                }
                for (ComprobanteServicio t : lstTotal) {
                out.println("<tr>\r\n"
                		+ "									<td colspan=\"3\" class=\"cabeceraProgracionVisitas\">Total</td>\r\n"
                		+ "									<td colspan=\"\"	style=\"background-color: #e8d8ff\"><h4>S/. "+t.getTotal()+"</h4>\r\n"
                		+ "									</td>\r\n"
                		+ "								</tr>");
                }
                
                
                out.println("</table></center>	");
                
                }
	    		
	    	}else if(action.equals("crearBuscar")){

	    		int nuevoComprobante = Integer.parseInt(request.getParameter("filtro"));
	    		int idComprobante =0;
	    		
	    		BOProgramaVisita boCrearComprobante = new BOProgramaVisita();
		        ProgramaVisita programavisita=new ProgramaVisita();
		        programavisita.setIdCliente(nuevoComprobante);
		        programavisita.setObservaciones("");
		        programavisita.setEstadoServicio("Atencion en lavanderia");
		        programavisita.setFecha("2022-12-17");
		        
		        idComprobante = boCrearComprobante.registrarComprobante(programavisita);
	    		
                BOComprobanteServicio bo = new BOComprobanteServicio();
                List<ComprobanteServicio> lst = bo.buscarComprobanteServicioRopa(idComprobante);
                List<ComprobanteServicio> lstTotal = bo.buscarTotal(idComprobante);
                List<ComprobanteServicio> lstPrendaComprobante = bo.PrendaComprobante(idComprobante);
                request.getSession().setAttribute("lstPrendaComprobante", lstPrendaComprobante);
                request.getSession().setAttribute("lstTotal", lstTotal);
                request.getSession().setAttribute("lstCSR", lst);
                
                BOGestionServicio bo3 = new BOGestionServicio();
            	List<Servicio> lst3 = bo3.consultarServicio();
                
                ComprobanteServicio u = new ComprobanteServicio();
                u.setIdComprobante(idComprobante);
                List<ComprobanteServicio> lst2 = new ArrayList<ComprobanteServicio>();
                lst2.add(u);
                request.getSession().setAttribute("num26", lst2);
                
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                	
                out.println("<center><form action=\"../../ServletMantenimientoComprobanteServicio?action=guardarComprobanteServicio&idComprobante="+idComprobante+"\"  target=\"_blank\"   method=\"post\">");
                out.println("<br><center><h2>Ingreso de Ropa</h2></center><table border=1 style=\"width:85%\">\r\n"
                		+ "					<tr>\r\n"
                		+ "						<td class=\"cabeceraProgracionVisitas\" style=\"width: 24%;\">Servicio</td>\r\n"
                		+ "						<td class=\"cabeceraProgracionVisitas\" style=\"width: 24%;\" colspan=\"2\">Prenda</td>\r\n"
                		+ "						<td class=\"cabeceraProgracionVisitas\" style=\"width: 24%;\" >Cantidad</td>\r\n"
                		+ "						<td class=\"cabeceraProgracionVisitas\" style=\"width: 24%;\" ></td>\r\n"
                		+ "\r\n"
                		+ "					</tr>");
                
                out.println("<tr>\r\n"
                		+ "	<td><select name=\"idServicio\" class=\"form-control\" style=\"width: 90%;\">");
                
                //Lista de servicios
                for (Servicio u3 : lst3) {
                out.println("<option value="+u3.getIdServicio()+" >"+u3.getNombreServicio()+" S/."+u3.getPrecio()+"");
                }
                out.println("</option>");
                out.println("</select></td>");
                
                //lista de prendas para el cliente
                out.println("<td><select name=\"idPrenda\" class=\"form-control\" style=\"width: 90%;\">");
                for (ComprobanteServicio u4 : lstPrendaComprobante) {
                out.println("<option value="+u4.getIdPrenda()+" >"+u4.getNombrePrenda()+"</option>");
                }
                out.println("");
                out.println("</select></td>");
                
                out.println("");
                
                //agregar nueva prenda para el cliente
                out.println("<td><a\r\n"
                		+ "									href=\"../../ServletMantenimientoComprobanteServicio?action=nuevoR&idCliente="+idComprobante+"\"\r\n"
                		+ "									 target=\"_blank\" class=\"btn btn-primary py-2 px-3\"\r\n"
                		+ "									style=\"background-color: #57a639; border-color: #57a639;\">\r\n"
                		+ "									<b>+</b>\r\n"
                		+ "								</a></td>");
                
                //cantidad
                out.println("<td><input type=\"number\" class=\"form-control\" placeholder=\"\"\r\n"
                		+ "							name=\"cantidad\" style=\"width: 100%;\" required></td>");
                
                //boton para nuevo
                out.println("<td><button id=\"btn2\" class=\"btn manUsuForm btn-primary py-2 px-4\" onclick=\"buscarPrueba();\">Agregar</button> <input type=\"button\" class=\"btn manUsuForm btn-primary py-2 px-4\" value=\"Actualizar\" onclick=\"actualizarC("+idComprobante+");\"></td> ");
                
               																					
                
                out.println("</tr>");
                out.println("</table>");
                out.println("</form>");
                
                
                out.println("<br><center><h2>Comprobante</h2></center><table  style=\"width:85%\" border=1 style=\"display: flex; justify-content: center; text-align: center;\">\r\n"
                		+ "								<tr>\r\n"
                		+ "									<td class=\"cabeceraProgracionVisitas\" style=\"width: 200px;\">Servicio</td>\r\n"
                		+ "									<td class=\"cabeceraProgracionVisitas\" style=\"width: 200px;\">Prenda</td>\r\n"
                		+ "									<td class=\"cabeceraProgracionVisitas\">Cantidad</td>\r\n"
                		+ "									<td class=\"cabeceraProgracionVisitas\" style=\"width: 200px;\">Subtotal</td>\r\n"

                		+ "									<td class=\"cabeceraProgracionVisitas\">Quitar</td>\r\n"
                		+ "								</tr>");
                
                for (ComprobanteServicio r : lst) {
                out.println("");
                out.println("<tr>\r\n"
                		+ "										<td>"+r.getNombreServicio()+"</td>\r\n"
                		+ "										<td>"+r.getNombrePrenda()+"</td>\r\n"
                		+ "										<td>"+r.getCantidad()+"</td>\r\n"
                		+ "										<td>"+r.getSubtotal()+"</td>\r\n"

                		+ "										<td><a\r\n"
                		+ "											target=\"_blank\" href=\"../../ServletMantenimientoComprobanteServicio?action=eliminarSs&idComprobante="+r.getIdComprobante()+"&idServicio="+r.getIdServicio()+"&idPrenda="+r.getIdPrenda()+"\">eliminar</a></td>\r\n"
                		+ "									</tr>");
                //total
                }
                for (ComprobanteServicio t : lstTotal) {
                out.println("<tr>\r\n"
                		+ "									<td colspan=\"3\" class=\"cabeceraProgracionVisitas\">Total</td>\r\n"
                		+ "									<td colspan=\"\"	style=\"background-color: #e8d8ff\"><h4>S/. "+t.getTotal()+"</h4>\r\n"
                		+ "									</td>\r\n"
                		+ "								</tr>");
                }
                
                
                out.println("</table></center>	");
                
                }
                
	    		
	    	
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
	        String fechaNacimiento = request.getParameter("fecha");
	        
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
	        String fechaNacimiento = request.getParameter("fecha");
            
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

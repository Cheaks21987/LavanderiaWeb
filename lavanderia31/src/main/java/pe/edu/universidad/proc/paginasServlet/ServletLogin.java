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
import pe.edu.universidad.entidades.jdbc.Login;


@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action  =request.getParameter("action");
		
		if (action.equals("guardarNuevo")) {
	        String usuario = request.getParameter("usuario");
	        String contrasenia = request.getParameter("contrasenia");
	        BOGestionLogin bo = new BOGestionLogin();
	        Login login = new Login();
	        login.setUsuario(usuario);
	        login.setContrasenia(contrasenia);
	        bo.registrarLogin(login);
	        request.getRequestDispatcher("index.jsp").forward(request, response);   
    	
			}else if (action.equals("buscar")) {
	    		
	    		String usuario = request.getParameter("usuario");  
	    		String contrasenia = request.getParameter("contrasenia");
	    		BOGestionLogin bo = new BOGestionLogin();
		        int verificar = bo.consultarLogin(usuario,contrasenia);
		        
		        if (verificar==1) {
		        request.getRequestDispatcher("paginas/inicio/inicio.jsp").forward(request, response);
		        }else {
		        request.getRequestDispatcher("paginas/login/login2.jsp").forward(request, response);
		        }
	    			
	    	}	
	}

}

package pe.edu.universidad.proc.paginasServlet;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


import net.sf.jasperreports.engine.JasperRunManager;
import pe.edu.universidad.proc.cone.Conectar;

import java.sql.Connection;

@WebServlet(name="ServletReporte", urlPatterns={"ServletReporte"})

public class ServletReporte extends javax.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletReporte() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		/*Conectar nn = new Conectar();
		nn.establecerConexion();*/
		request.getRequestDispatcher("reporte/reporte.jsp").forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}

}

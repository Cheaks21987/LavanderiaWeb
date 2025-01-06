package pe.edu.universidad.proc.paginasServlet;

import java.util.List;

import pe.edu.universidad.dao.*;
import pe.edu.universidad.entidades.jdbc.*;

public class BOProgramaVisita {
	
	public List<ProgramaVisita> consultarProgramaVisita(){
		DaoProgramaVisita dao=new DaoProgramaVisita();
		return dao.consultarProgramaVisita();
	}
	
	public List<ProgramaVisita> consultarCliente(){
		DaoProgramaVisita dao=new DaoProgramaVisita();
		return dao.consultarCliente();
	}
	
    public void registrarProgramaVisita(ProgramaVisita programaVisita) {
    	DaoProgramaVisita dao = new DaoProgramaVisita();
        dao.registrarProgramaVisita(programaVisita);
    } 
    public int registrarComprobante(ProgramaVisita programaVisita) {
    	DaoProgramaVisita dao = new DaoProgramaVisita();
        int idC =dao.registrarComprobante(programaVisita);
        return idC;
    } 
    
    public List<ProgramaVisita> consultarTodos(){
		DaoProgramaVisita dao=new DaoProgramaVisita();
		return dao.consultarTodos();
	}
    
    public List<ProgramaVisita> consultarVehiculo(){
		DaoProgramaVisita dao=new DaoProgramaVisita();
		return dao.consultarVehiculo();
	}
    
    
    
    public List<Categoria> editarCategoria(String cadenaBusqueda) {
    	DaoCategoria dao = new DaoCategoria();
        return dao.editarCategoria(cadenaBusqueda);
    }
    public void guardarModificadoCategoria(Categoria categoria) {
    	DaoCategoria dao = new DaoCategoria();
        dao.guardarModificadoCategoria(categoria);
    }
    
    public void eliminarCategoria(String cadenaBusqueda) {
    	DaoCategoria dao = new DaoCategoria();
        dao.eliminarCategoria(cadenaBusqueda);
    }
    
    public List<Categoria> consultarCategorias(String cadenaBusqueda) {
        DaoCategoria dao = new DaoCategoria();
        return dao.consultarCategorias(cadenaBusqueda);
    }
}

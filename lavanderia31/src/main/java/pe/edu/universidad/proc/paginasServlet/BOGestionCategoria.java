package pe.edu.universidad.proc.paginasServlet;

import java.util.List;

import pe.edu.universidad.dao.*;
import pe.edu.universidad.entidades.jdbc.*;

public class BOGestionCategoria {
	
	public List<Categoria> consultarCategorias(){
		DaoCategoria dao=new DaoCategoria();
		return dao.consultarCategorias();
	}
	
    public void registrarCategoria(Categoria categoria) {
        DaoCategoria dao = new DaoCategoria();
        dao.registrarCategoria(categoria);
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

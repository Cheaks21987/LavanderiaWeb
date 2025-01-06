package pe.edu.universidad.proc.paginasServlet;

import java.util.List;

import pe.edu.universidad.dao.*;
import pe.edu.universidad.entidades.jdbc.*;

public class BOGestionLogin {
	
	public List<Categoria> consultarCategorias(){
		DaoCategoria dao=new DaoCategoria();
		return dao.consultarCategorias();
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
    
    //--login
    public int consultarLogin(String usuario,String contrasenia) {
        DaoLogin dao = new DaoLogin();
        return dao.consultarLogin(usuario,contrasenia);
    }
    public void registrarLogin(Login login) {
        DaoLogin dao = new DaoLogin();
        dao.registrarLogin(login);
    }
}

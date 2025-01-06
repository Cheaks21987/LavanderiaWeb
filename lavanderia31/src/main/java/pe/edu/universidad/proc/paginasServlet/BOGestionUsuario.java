package pe.edu.universidad.proc.paginasServlet;

import java.util.List;

import pe.edu.universidad.dao.DaoUsuario;
import pe.edu.universidad.entidades.jdbc.Usuario;

public class BOGestionUsuario {
	
	public List<Usuario> consultarUsuarios(){
		DaoUsuario dao=new DaoUsuario();
		return dao.consultarTodos();
	}
    public void registrarUsuario(Usuario usuario) {
        DaoUsuario dao = new DaoUsuario();
        dao.registrar(usuario);
    }
    
    public List<Usuario> consultarUsuarios(String cadenaBusqueda) {
        DaoUsuario dao = new DaoUsuario();
        return dao.consultarUsuario(cadenaBusqueda);
    }
    
    public List<Usuario> editarUsuarios(String cadenaBusqueda) {
        DaoUsuario dao = new DaoUsuario();
        return dao.editarUsuario(cadenaBusqueda);
    }
    public void guardarModificadoUsuario(Usuario usuario) {
        DaoUsuario dao = new DaoUsuario();
        dao.guardarModificadoUsuario(usuario);
    }
    
    public void eliminarUsuario(String cadenaBusqueda) {
        DaoUsuario dao = new DaoUsuario();
        dao.eliminarUsuario(cadenaBusqueda);
    }
}

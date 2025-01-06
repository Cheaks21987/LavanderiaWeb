package pe.edu.universidad.proc.paginasServlet;

import java.util.List;

import pe.edu.universidad.dao.*;
import pe.edu.universidad.entidades.jdbc.*;

public class BOGestionSerPro {
	
	public List<SerPro> consultarSerPro(){
		DaoSerPro dao=new DaoSerPro();
		return dao.consultarSerPro();
	}
	
    public void registrarSerPro(SerPro serpro) { 
    	DaoSerPro dao = new DaoSerPro();
        dao.registrarSerPro(serpro);
    }
    
    public List<SerPro> buscarSerPro(String cadenaBusqueda) {
        DaoSerPro dao = new DaoSerPro();
        return dao.buscarSerPro(cadenaBusqueda);
    }
    
    public List<SerPro> editarSerPro(String cadenaBusqueda) {
    	DaoSerPro dao = new DaoSerPro();
        return dao.editarSerPro(cadenaBusqueda);
    }
    public void guardarModificadoSerPro(SerPro serpro) {
    	DaoSerPro dao = new DaoSerPro();
        dao.guardarModificadoSerPro(serpro);
    }
    

}

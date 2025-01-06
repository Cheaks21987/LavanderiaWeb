package pe.edu.universidad.proc.paginasServlet;

import java.util.List;

import pe.edu.universidad.dao.*;
import pe.edu.universidad.entidades.jdbc.*;

public class BOGestionServicio {
	
	public List<Servicio> consultarServicio(){
		DaoServicio dao=new DaoServicio();
		return dao.consultarServicio();
	}
    public void registrarServicio(Servicio servicio) {
        DaoServicio dao = new DaoServicio();
        dao.registrarServicio(servicio);
    }
    public List<Servicio> editarServicio(int cadenaBusqueda) {
    	DaoServicio dao = new DaoServicio();
        return dao.editarServicio(cadenaBusqueda);
    }
    public void guardarModificadoServicio(Servicio servicio) {
    	DaoServicio dao = new DaoServicio();
        dao.guardarModificadoServicio(servicio);
    }
    public List<Servicio> buscarServicio(String cadenaBusqueda) {
    	DaoServicio dao = new DaoServicio();
        return dao.buscarServicio(cadenaBusqueda);
    }
    public void eliminarServicio(String cadenaBusqueda) {
    	DaoServicio dao = new DaoServicio();
        dao.eliminarServicio(cadenaBusqueda);
    }
    public List<Servicio> consultarServicios(String cadenaBusqueda) {
        DaoServicio dao = new DaoServicio();
        return dao.consultarServicios(cadenaBusqueda);
    }
    public List<Servicio> consultarCategoria() {
    	DaoServicio dao = new DaoServicio();
        return dao.consultarCategoria();
    }
}
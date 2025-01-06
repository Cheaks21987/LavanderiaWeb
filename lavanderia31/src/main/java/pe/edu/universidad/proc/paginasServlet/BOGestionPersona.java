package pe.edu.universidad.proc.paginasServlet;

import java.util.List;

import pe.edu.universidad.dao.DaoPersona;
import pe.edu.universidad.dao.DaoServicio;
import pe.edu.universidad.entidades.jdbc.Persona;
import pe.edu.universidad.entidades.jdbc.PersonaComprobante;
import pe.edu.universidad.entidades.jdbc.Servicio;

public class BOGestionPersona {
	
	public List<Persona> consultarPersona(){
		DaoPersona dao=new DaoPersona();
		return dao.consultarTodos();
	}
    public void registrarPersona(Persona persona) {
        DaoPersona dao = new DaoPersona();
        dao.registrar(persona);
    }
    
    public List<Persona> consultarPersona(String cadenaBusqueda) {
        DaoPersona dao = new DaoPersona();
        return dao.consultarPersona(cadenaBusqueda);
    }
    
    public List<Persona> editarPersona(int cadenaBusqueda) {
        DaoPersona dao = new DaoPersona();
        return dao.editarPersona(cadenaBusqueda);
    }
    public void guardarModificadoPersona(Persona persona) {
        DaoPersona dao = new DaoPersona();
        dao.guardarModificadoPersona(persona);
    }
    
    public void eliminarPersona(String cadenaBusqueda) {
        DaoPersona dao = new DaoPersona();
        dao.eliminarPersona(cadenaBusqueda);
    }
    public List<Persona> consultarDistrito() {
    	DaoPersona dao = new DaoPersona();
        return dao.consultarDistrito();
    }
    public List<Persona> buscarPersona(String cadenaBusqueda) {
    	DaoPersona dao = new DaoPersona();
        return dao.buscarPersona(cadenaBusqueda);
    }
    public List<PersonaComprobante> buscarPersonaComprobante(String cadenaBusqueda) {
    	DaoPersona dao = new DaoPersona();
        return dao.buscarPersonaComprobante(cadenaBusqueda);
    }
}

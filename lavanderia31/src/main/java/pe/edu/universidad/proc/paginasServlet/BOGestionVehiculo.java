package pe.edu.universidad.proc.paginasServlet;

import java.util.List;

import pe.edu.universidad.dao.DaoVehiculo;
import pe.edu.universidad.dao.DaoVehiculo;
import pe.edu.universidad.entidades.jdbc.Vehiculo;

public class BOGestionVehiculo {
	
	public List<Vehiculo> consultarVehiculo(){
		DaoVehiculo dao=new DaoVehiculo();
		return dao.consultarTodos();
	}
    public void registrarVehiculo(Vehiculo vehiculo) {
        DaoVehiculo dao = new DaoVehiculo();
        dao.registrar(vehiculo);
    }
    
    public List<Vehiculo> consultarVehiculo(String cadenaBusqueda) {
        DaoVehiculo dao = new DaoVehiculo();
        return dao.consultarVehiculo(cadenaBusqueda);
    }
    
    public List<Vehiculo> editarVehiculo(int cadenaBusqueda) {
        DaoVehiculo dao = new DaoVehiculo();
        return dao.editarVehiculo(cadenaBusqueda);
    }
    public void guardarModificadoVehiculo(Vehiculo vehiculo) {
        DaoVehiculo dao = new DaoVehiculo();
        dao.guardarModificadoVehiculo(vehiculo);
    }
    public void eliminarVehiculo(String cadenaBusqueda) {
    	DaoVehiculo dao = new DaoVehiculo();
        dao.eliminarVehiculo(cadenaBusqueda);
    }
    public List<Vehiculo> consultarModelo() {
    	DaoVehiculo dao=new DaoVehiculo();
		return dao.consultarModelo();
    }
}

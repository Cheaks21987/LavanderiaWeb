package pe.edu.universidad.proc.paginasServlet;

import java.util.List;

import pe.edu.universidad.dao.DaoPrenda;
import pe.edu.universidad.dao.DaoServicio;
import pe.edu.universidad.entidades.jdbc.Prenda;
import pe.edu.universidad.entidades.jdbc.Servicio;

public class BOGestionPrenda {
    
    public List<Prenda> consultarPrenda(){
        DaoPrenda dao=new DaoPrenda();
        return dao.consultarPrenda();
    }
    public void registrarPrenda(Prenda prenda) {
        DaoPrenda dao = new DaoPrenda();
        dao.registrarPrenda(prenda);
    }
    public List<Prenda> consultarPrenda(String cadenaBusqueda) {
        DaoPrenda dao = new DaoPrenda();
        return dao.consultarPrenda(cadenaBusqueda);
    }
    public List<Prenda> editarPrenda(String cadenaBusqueda) {
        DaoPrenda dao = new DaoPrenda();
        return dao.editarPrenda(cadenaBusqueda);
    }
    public void guardarModificadoPrenda(Prenda prenda) {
        DaoPrenda dao = new DaoPrenda();
        dao.guardarModificadoPrenda(prenda);
    }
    public List<Prenda> buscarPrenda(String cadenaBusqueda) {
    	DaoPrenda dao = new DaoPrenda();
        return dao.buscarPrenda(cadenaBusqueda);
    }
    public void eliminarPrenda(String cadenaBusqueda) {
        DaoPrenda dao = new DaoPrenda();
        	dao.eliminarPrenda(cadenaBusqueda);
    }
    public List<Prenda> consultarMarca(){
    	DaoPrenda dao = new DaoPrenda();
    	return dao.consultarMarca();
    }
    public List<Prenda> consultarMaterial(){
    	DaoPrenda dao = new DaoPrenda();
    	return dao.consultarMaterial();
    }
    public List<Prenda> consultarColor(){
    	DaoPrenda dao = new DaoPrenda();
    	return dao.consultarColor();
    }
}

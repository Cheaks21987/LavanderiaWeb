package pe.edu.universidad.proc.paginasServlet;

import java.util.List;

import pe.edu.universidad.dao.DaoComprobanteServicio;
import pe.edu.universidad.dao.DaoPrenda;
import pe.edu.universidad.dao.DaoServicio;
import pe.edu.universidad.entidades.jdbc.ComprobanteServicio;
import pe.edu.universidad.entidades.jdbc.Prenda;

public class BOComprobanteServicio {
	public List<ComprobanteServicio> consultarComprobanteServicio(){
		DaoComprobanteServicio dao=new DaoComprobanteServicio();
		return dao.consultarComprobanteServicio();
	}
    public void registrarComprobanteServicio(ComprobanteServicio comprobanteServicio) {
        DaoComprobanteServicio dao = new DaoComprobanteServicio();
        dao.registrarComprobanteServicio(comprobanteServicio);
    }
    public void editarComprobanteEstado(ComprobanteServicio comprobanteServicio) {
        DaoComprobanteServicio dao = new DaoComprobanteServicio();
        dao.editarComprobanteEstado(comprobanteServicio);
    }
    public List<ComprobanteServicio> buscarComprobanteServicio(int cadenaBusqueda) {
    	DaoComprobanteServicio dao = new DaoComprobanteServicio();
        return dao.buscarComprobanteServicio(cadenaBusqueda);
    }
    public List<ComprobanteServicio> buscarComprobanteServicioRopa(int cadenaBusqueda) {
    	DaoComprobanteServicio dao = new DaoComprobanteServicio();
        return dao.buscarComprobanteServicioRopa(cadenaBusqueda);
    }
    public List<ComprobanteServicio> consultarComprobante() {
    	DaoComprobanteServicio dao = new DaoComprobanteServicio();
        return dao.consultarComprobante();
    }
    public List<ComprobanteServicio> consultarPrenda() {
    	DaoComprobanteServicio dao = new DaoComprobanteServicio();
        return dao.consultarPrenda();
    }
    public List<ComprobanteServicio> consultarServicio() {
    	DaoComprobanteServicio dao = new DaoComprobanteServicio();
        return dao.consultarServicio();
    }
    public List<ComprobanteServicio> consultarPersona() {
    	DaoComprobanteServicio dao = new DaoComprobanteServicio();
        return dao.consultarPersona();
    }
    public List<ComprobanteServicio> editarComprobanteServicios(int cadenaBusqueda) {
    	DaoComprobanteServicio dao = new DaoComprobanteServicio();
    	return dao.editarComprobanteServicio(cadenaBusqueda);
    }
    public void guardarModificadoComprobanteServicio(ComprobanteServicio comprobanteServicio) {
        DaoComprobanteServicio dao = new DaoComprobanteServicio();
        dao.guardarModificadoComprobanteServicio(comprobanteServicio);
    }
    public void eliminarComprobanteServicio(String cadenaBusqueda) {
    	DaoComprobanteServicio dao = new DaoComprobanteServicio();
        dao.eliminarComprobanteServicio(cadenaBusqueda);
    }
    public List<ComprobanteServicio> calcularTotal(int cadenaBusqueda) {
    	DaoComprobanteServicio dao = new DaoComprobanteServicio();
        return dao.calcularTotal(cadenaBusqueda);
    }
    
    public List<ComprobanteServicio> buscarTotal(int cadenaBusqueda) {
    	DaoComprobanteServicio dao = new DaoComprobanteServicio();
        return dao.buscarTotal(cadenaBusqueda);
    }
    public List<ComprobanteServicio> PrendaComprobante(int cadenaBusqueda) {
    	DaoComprobanteServicio dao = new DaoComprobanteServicio();
        return dao.PrendaComprobante(cadenaBusqueda);
    }
    public void guardarComprobanteServicio(ComprobanteServicio comprobanteServicio) {
        DaoComprobanteServicio dao = new DaoComprobanteServicio();
        dao.guardarComprobanteServicio(comprobanteServicio);
    }
    public void eliminarSs(int num1,int num2,int num3) {
    	DaoComprobanteServicio dao = new DaoComprobanteServicio();
        dao.eliminarSs(num1,num2,num3);
    }
    public List<ComprobanteServicio> consultarComprobantes() {
    	DaoComprobanteServicio dao = new DaoComprobanteServicio();
        return dao.consultarComprobantes();
    }
    public List<ComprobanteServicio> generarComprobante() {
    	DaoComprobanteServicio dao = new DaoComprobanteServicio();
        return dao.generarComprobante();
    }
}

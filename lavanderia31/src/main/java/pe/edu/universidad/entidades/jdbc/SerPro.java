package pe.edu.universidad.entidades.jdbc;

public class SerPro {

	
	private int id,idAd,idVe,idCh;
	private String idCl,estadoServicio,estadoDelivery,comprobanteServicio,comprobanteDelivery;
	private Double Total;
	private String nAd,nCl,nCh,nVe;
	public String getnAd() {
		return nAd;
	}
	public void setnAd(String nAd) {
		this.nAd = nAd;
	}
	public String getnCl() {
		return nCl;
	}
	public void setnCl(String nCl) {
		this.nCl = nCl;
	}
	public String getnCh() {
		return nCh;
	}
	public void setnCh(String nCh) {
		this.nCh = nCh;
	}
	public String getnVe() {
		return nVe;
	}
	public void setnVe(String nVe) {
		this.nVe = nVe;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdAd() {
		return idAd;
	}
	public void setIdAd(int idAd) {
		this.idAd = idAd;
	}
	public int getIdVe() {
		return idVe;
	}
	public void setIdVe(int idVe) {
		this.idVe = idVe;
	}
	public int getIdCh() {
		return idCh;
	}
	public void setIdCh(int idCh) {
		this.idCh = idCh;
	}
	public String getIdCl() {
		return idCl;
	}
	public void setIdCl(String idCl) {
		this.idCl = idCl;
	}
	public String getEstadoServicio() {
		return estadoServicio;
	}
	public void setEstadoServicio(String estadoServicio) {
		this.estadoServicio = estadoServicio;
	}
	public String getEstadoDelivery() {
		return estadoDelivery;
	}
	public void setEstadoDelivery(String estadoDelivery) {
		this.estadoDelivery = estadoDelivery;
	}
	public String getComprobanteServicio() {
		return comprobanteServicio;
	}
	public void setComprobanteServicio(String comprobanteServicio) {
		this.comprobanteServicio = comprobanteServicio;
	}
	public String getComprobanteDelivery() {
		return comprobanteDelivery;
	}
	public void setComprobanteDelivery(String comprobanteDelivery) {
		this.comprobanteDelivery = comprobanteDelivery;
	}
	public Double getTotal() {
		return Total;
	}
	public void setTotal(Double total) {
		Total = total;
	}
	
	
}

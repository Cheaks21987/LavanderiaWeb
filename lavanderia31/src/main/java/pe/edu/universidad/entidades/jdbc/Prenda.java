package pe.edu.universidad.entidades.jdbc;



public class Prenda {
    
    private int idPrenda,idMarca,idMaterial,idColor;
    private int cantidad,idC,idS;
    private String nombrePrenda,observacion,estadoTF, nombreMarca, nombreMaterial, nombreColor;
    public void setEstadoTF(String estadoTF) {
		this.estadoTF = estadoTF;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getIdC() {
		return idC;
	}
	public void setIdC(int idC) {
		this.idC = idC;
	}
	public int getIdS() {
		return idS;
	}
	public void setIdS(int idS) {
		this.idS = idS;
	}
	
    public int getIdPrenda() {
        return idPrenda;
    }
    public void setIdPrenda(int idPrenda) {
        this.idPrenda = idPrenda;
    }
    public int getIdMarca() {
        return idMarca;
    }
    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }
    public int getIdMaterial() {
        return idMaterial;
    }
    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }
    public int getIdColor() {
        return idColor;
    }
    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }
    public String getNombrePrenda() {
        return nombrePrenda;
    }
    public void setNombrePrenda(String nombrePrenda) {
        this.nombrePrenda = nombrePrenda;
    }
    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public String getEstadoTF() {
        return estadoTF;
    }
    public void idC(String estadoTF) {
        this.estadoTF = estadoTF;
    }
	public String getNombreMarca() {
		return nombreMarca;
	}
	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}
	public String getNombreMaterial() {
		return nombreMaterial;
	}
	public void setNombreMaterial(String nombreMaterial) {
		this.nombreMaterial = nombreMaterial;
	}
	public String getNombreColor() {
		return nombreColor;
	}
	public void setNombreColor(String nombreColor) {
		this.nombreColor = nombreColor;
	}
    
    
    
    

}
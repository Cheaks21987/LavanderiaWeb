package pe.edu.universidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import pe.edu.universidad.entidades.jdbc.Categoria;
import pe.edu.universidad.entidades.jdbc.SerPro;

public class DaoSerPro extends DaoGenerico {

    public List<SerPro> consultarSerPro() {
        List<SerPro> lst = new ArrayList<SerPro>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT public.\"serpro\".\"idserpro\",public.\"serpro\".\"comprobanteDelivery\",public.\"serpro\".\"estadoDelivery\",\r\n"
        		+ "		public.\"serpro\".\"comprobanteServicio\",public.\"serpro\".\"estadoServicio\",public.\"serpro\".\"Total\",\r\n"
        		+ "		public.\"Cliente\".\"nombre\",public.\"Administrador\".\"nombre\",public.\"Chofer\".\"nombre\",\r\n"
        		+ "		public.\"Vehiculo\".\"Modelo\"\r\n"
        		+ "		FROM public.\"serpro\"\r\n"
        		+ "INNER JOIN public.\"Cliente\" ON \"serpro\".\"idCliente\" =\"Cliente\".\"idCliente\"\r\n"
        		+ "INNER JOIN public.\"Administrador\" ON \"serpro\".\"idAdministrador\" =\"Administrador\".\"idAdministrador\"\r\n"
        		+ "INNER JOIN public.\"Chofer\" ON \"serpro\".\"idChofer\" =\"Chofer\".\"idChofer\"\r\n"
        		+ "INNER JOIN public.\"Vehiculo\" ON \"serpro\".\"idVehiculo\" =\"Vehiculo\".\"idVehiculo\"";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	SerPro u = new SerPro();
                u.setId(rs.getInt(1));
                u.setComprobanteDelivery(rs.getString(2));
                u.setEstadoDelivery(rs.getString(3));
                u.setComprobanteServicio(rs.getString(4));
                u.setEstadoServicio(rs.getString(5));
                u.setTotal(rs.getDouble(6));
                u.setIdCl(rs.getString(7));
                u.setnAd(rs.getString(8));
                u.setnCh(rs.getString(9));
                u.setnVe(rs.getString(10));
                lst.add(u);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return lst;
    }
    
    
    
    public void registrarSerPro(SerPro serpro) {
    	
        Connection cnx = obtenerConexion();
        String sql = "INSERT INTO public.serpro(\r\n"
        		+ "	idserpro, \"comprobanteDelivery\", \"estadoDelivery\", \"comprobanteServicio\", \"estadoServicio\", \"Total\", \"idCliente\", \"idAdministrador\", \"idChofer\", \"idVehiculo\")\r\n"
        		+ "	VALUES (nextval('seq_serpro'), ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setString(1, serpro.getComprobanteDelivery());
            stm.setString(2, serpro.getEstadoDelivery());
            stm.setString(3, serpro.getComprobanteServicio());
            stm.setString(4, serpro.getEstadoServicio());
            stm.setDouble(5, serpro.getTotal());
            
            stm.setString(6, serpro.getIdCl());
            stm.setInt(7, serpro.getIdAd());
            stm.setInt(8, serpro.getIdCh());
            stm.setInt(9, serpro.getIdVe());

            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    public List<SerPro> buscarSerPro(String cadenaBusqueda) {
        List<SerPro> lst = new ArrayList<SerPro>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT 	public.\"serpro\".\"idserpro\",public.\"serpro\".\"comprobanteDelivery\",public.\"serpro\".\"estadoDelivery\",\r\n"
        		+ "public.\"serpro\".\"comprobanteServicio\",public.\"serpro\".\"estadoServicio\",public.\"serpro\".\"Total\",\r\n"
        		+ "public.\"Cliente\".\"nombre\",public.\"Administrador\".\"nombre\",public.\"Chofer\".\"nombre\",\r\n"
        		+ "public.\"Vehiculo\".\"Modelo\"\r\n"
        		+ "FROM public.\"serpro\"\r\n"
        		+ "INNER JOIN public.\"Cliente\" ON \"serpro\".\"idCliente\" =\"Cliente\".\"idCliente\"\r\n"
        		+ "INNER JOIN public.\"Administrador\" ON \"serpro\".\"idAdministrador\" =\"Administrador\".\"idAdministrador\"\r\n"
        		+ "INNER JOIN public.\"Chofer\" ON \"serpro\".\"idChofer\" =\"Chofer\".\"idChofer\"\r\n"
        		+ "INNER JOIN public.\"Vehiculo\" ON \"serpro\".\"idVehiculo\" =\"Vehiculo\".\"idVehiculo\"\r\n"
        		+ "WHERE upper(public.\"Cliente\".\"nombre\") LIKE upper(?);";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setString(1, "%" + cadenaBusqueda + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	SerPro u = new SerPro();
            	u.setId(rs.getInt(1));
                u.setComprobanteDelivery(rs.getString(2));
                u.setEstadoDelivery(rs.getString(3));
                u.setComprobanteServicio(rs.getString(4));
                u.setEstadoServicio(rs.getString(5));
                u.setTotal(rs.getDouble(6));
                u.setnCl(rs.getString(7));
                u.setnAd(rs.getString(8));
                u.setnCh(rs.getString(9));
                u.setnVe(rs.getString(10));
                lst.add(u);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return lst;
    }
    
    public List<SerPro> editarSerPro(String cadenaBusqueda) {
    	
        List<SerPro> lst = new ArrayList<SerPro>();
        Connection cnx = obtenerConexion();
        String sql = "	SELECT 	public.\"serpro\".\"comprobanteDelivery\",public.\"serpro\".\"estadoDelivery\",\r\n"
        		+ "	public.\"serpro\".\"comprobanteServicio\",public.\"serpro\".\"estadoServicio\",public.\"serpro\".\"Total\",\r\n"
        		+ "	public.\"Cliente\".\"idCliente\",public.\"Administrador\".\"idAdministrador\",public.\"Chofer\".\"idChofer\",\r\n"
        		+ "	public.\"Vehiculo\".\"idVehiculo\"\r\n"
        		+ "	FROM public.\"serpro\"\r\n"
        		+ "	INNER JOIN public.\"Cliente\" ON \"serpro\".\"idCliente\" =\"Cliente\".\"idCliente\"\r\n"
        		+ "	INNER JOIN public.\"Administrador\" ON \"serpro\".\"idAdministrador\" =\"Administrador\".\"idAdministrador\"\r\n"
        		+ "	INNER JOIN public.\"Chofer\" ON \"serpro\".\"idChofer\" =\"Chofer\".\"idChofer\"\r\n"
        		+ "	INNER JOIN public.\"Vehiculo\" ON \"serpro\".\"idVehiculo\" =\"Vehiculo\".\"idVehiculo\"\r\n"
        		+ "WHERE public.\"serpro\".\"idserpro\" = ?;";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            
            stm.setInt(1,Integer.parseInt(cadenaBusqueda));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	SerPro u = new SerPro();
            	
                u.setComprobanteDelivery(rs.getString(1));
                u.setEstadoDelivery(rs.getString(2));
                u.setComprobanteServicio(rs.getString(3));
                u.setEstadoServicio(rs.getString(4));
                u.setTotal(rs.getDouble(5));
                u.setIdCl(rs.getString(6));
                u.setIdAd(rs.getInt(7));
                u.setIdCh(rs.getInt(8));
                u.setIdVe(rs.getInt(9));
                lst.add(u);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return lst;
    }
    
    
    	public void guardarModificadoSerPro(SerPro serpro) {
    	
        Connection cnx = obtenerConexion();
        String sql = "UPDATE public.serpro SET idserpro=?, \"comprobanteDelivery\"=?, \"estadoDelivery\"=?, \"comprobanteServicio\"=?, \"estadoServicio\"=?, \"Total\"=?, \"idCliente\"=?, \"idAdministrador\"=?, \"idChofer\"=?, \"idVehiculo\"=? WHERE \"idserpro\" = ? ;";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setString(1, serpro.getComprobanteDelivery());
            stm.setString(2, serpro.getEstadoDelivery());
            stm.setString(3, serpro.getComprobanteServicio());
            stm.setString(4, serpro.getEstadoServicio());
            stm.setDouble(5, serpro.getTotal());
            
            stm.setString(6, serpro.getIdCl());
            stm.setInt(7, serpro.getIdAd());
            stm.setInt(8, serpro.getIdCh());
            stm.setInt(9, serpro.getIdVe());
            stm.setInt(10, serpro.getId());
            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                cnx.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    	
    	
  
}
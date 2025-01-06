package pe.edu.universidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.universidad.entidades.jdbc.Vehiculo;


public class DaoVehiculo extends DaoGenerico {

    public List<Vehiculo> consultarTodos() {
        List<Vehiculo> lst = new ArrayList<Vehiculo>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"idVehiculo\", nombre, \"Modelo\".\"nombreModelo\", placa, \"estadoTF\" FROM public.\"Vehiculo\" \r\n"
        		+ "INNER JOIN public.\"Modelo\" \r\n"
        		+ "ON \"Modelo\".\"idModelo\" = \"Vehiculo\".\"idModelo\""
        		+ "WHERE \"estadoTF\"='T'";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Vehiculo u = new Vehiculo();
                u.setIdVehiculo(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setNombreModelo(rs.getString(3));
                u.setPlaca(rs.getString(4));
                u.setEstado(rs.getString(5));
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
    
    
    
    public void registrar(Vehiculo vehiculo) {
    	
        Connection cnx = obtenerConexion();
        String sql = "INSERT INTO public.\"Vehiculo\"( \"idVehiculo\", nombre, \"idModelo\", placa, \"estadoTF\") VALUES (nextval('seq_vehiculo'), ?, ?, ?, ?);";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setString(1, vehiculo.getNombre());
            stm.setInt(2, vehiculo.getIdModelo());
            stm.setString(3, vehiculo.getPlaca());
            stm.setString(4, vehiculo.getEstado());
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
    
    public List<Vehiculo> consultarVehiculo(String cadenaBusqueda) {
        List<Vehiculo> lst = new ArrayList<Vehiculo>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"idVehiculo\", nombre, \"Modelo\".\"nombreModelo\", placa, \"estadoTF\" FROM public.\"Vehiculo\" "
        		+ "INNER JOIN public.\"Modelo\" \r\n"
        		+ "ON \"Modelo\".\"idModelo\" = \"Vehiculo\".\"idModelo\""
        		+ "WHERE nombre LIKE ? and \"estadoTF\"='T'";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setString(1, "%" + cadenaBusqueda + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Vehiculo u = new Vehiculo();
                u.setIdVehiculo(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setNombreModelo(rs.getString(3));
                u.setPlaca(rs.getString(4));
                u.setEstado(rs.getString(5));
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
    
    public List<Vehiculo> editarVehiculo(int cadenaBusqueda) {
    	
        List<Vehiculo> lst = new ArrayList<Vehiculo>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"idVehiculo\", nombre, \"Vehiculo\".\"idModelo\", placa, \"estadoTF\", \"Modelo\".\"nombreModelo\" FROM public.\"Vehiculo\" \r\n"
        		+ "INNER JOIN public.\"Modelo\" \r\n"
        		+ "ON \"Modelo\".\"idModelo\" = \"Vehiculo\".\"idModelo\" \r\n"
        		+ "WHERE \"Vehiculo\".\"idVehiculo\" = ?";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setInt(1,cadenaBusqueda);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	Vehiculo u = new Vehiculo();
                u.setIdVehiculo(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setIdModelo(rs.getInt(3));
                u.setPlaca(rs.getString(4));
                u.setEstado(rs.getString(5));
                u.setNombreModelo(rs.getString(6));
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
    
    
    	public void guardarModificadoVehiculo(Vehiculo vehiculo) {
    	
        Connection cnx = obtenerConexion();
        String sql = "UPDATE public.\"Vehiculo\" SET nombre=?, \"idModelo\"=?, placa=? WHERE \"idVehiculo\" = ? ;";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setString(1, vehiculo.getNombre());
            stm.setInt(2, vehiculo.getIdModelo());
            stm.setString(3, vehiculo.getPlaca());
            stm.setInt(4, vehiculo.getIdVehiculo());
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
	public void eliminarVehiculo(String cadenaBusqueda) {
    	
        Connection cnx = obtenerConexion();
        String sql = "UPDATE public.\"Vehiculo\" SET \"estadoTF\"='F' WHERE \"idVehiculo\" = ?;";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setInt(1,Integer. parseInt(cadenaBusqueda));        
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
	public List<Vehiculo> consultarModelo() {
        List<Vehiculo> lst = new ArrayList<Vehiculo>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"idModelo\", \"nombreModelo\" FROM public.\"Modelo\";";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	Vehiculo u = new Vehiculo();
                u.setIdModelo(rs.getInt(1));
                u.setNombreModelo(rs.getString(2));
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
    	
}
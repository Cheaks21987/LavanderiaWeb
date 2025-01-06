package pe.edu.universidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.universidad.entidades.jdbc.Servicio;
import pe.edu.universidad.entidades.jdbc.Servicio;
import pe.edu.universidad.entidades.jdbc.Servicio;

public class DaoServicio extends DaoGenerico {

    public List<Servicio> consultarServicio() {
        List<Servicio> lst = new ArrayList<Servicio>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"idServicio\", precio, \"Categoria\".\"nombreCategoria\", \"Servicio\".\"estadoTF\", \"nombreServicio\" FROM public.\"Servicio\"\r\n"
        		+ "INNER JOIN public.\"Categoria\" \r\n"
        		+ "ON \"Categoria\".\"idCategoria\" = \"Servicio\".\"idCategoria\" \r\n"
        		+ "WHERE \"Servicio\".\"estadoTF\"='T';";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Servicio u = new Servicio();
                u.setIdServicio(rs.getInt(1));
                u.setPrecio(rs.getDouble(2));
                u.setNombreCategoria(rs.getString(3));
                u.setEstado(rs.getString(4));
                u.setNombreServicio(rs.getString(5));               
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
    public List<Servicio> buscarServicio(String cadenaBusqueda) {
        List<Servicio> lst = new ArrayList<Servicio>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"idServicio\", precio, \"Categoria\".\"nombreCategoria\", \"Servicio\".\"estadoTF\", \"nombreServicio\" FROM public.\"Servicio\" \r\n"
        		+ "INNER JOIN public.\"Categoria\" \r\n"
        		+ "ON \"Categoria\".\"idCategoria\" = \"Servicio\".\"idCategoria\" \r\n"
        		+ "WHERE \"nombreServicio\" LIKE ? and \"Servicio\".\"estadoTF\"='T'";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setString(1, "%" + cadenaBusqueda + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Servicio u = new Servicio();
                u.setIdServicio(rs.getInt(1));
                u.setPrecio(rs.getDouble(2));
                u.setNombreCategoria(rs.getString(3));
                u.setEstado(rs.getString(4));
                u.setNombreServicio(rs.getString(5));
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
    
    public void registrarServicio(Servicio servicio) {
        
        Connection cnx = obtenerConexion();
        String sql = "INSERT INTO public.\"Servicio\"(\"idServicio\", precio, \"idCategoria\", \"estadoTF\", \"nombreServicio\") VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setInt(1, servicio.getIdServicio());
            stm.setDouble(2, servicio.getPrecio());
            stm.setInt(3, servicio.getIdCategoria());
            stm.setString(4, servicio.getEstado());
            stm.setString(5, servicio.getNombreServicio());
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
    
   
    
    public List<Servicio> editarServicio(int cadenaBusqueda) {
        
        //System.out.println(cadenaBusqueda);
        
        List<Servicio> lst = new ArrayList<Servicio>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"idServicio\", precio, \"idCategoria\", \"estadoTF\", \"nombreServicio\" FROM public.\"Servicio\" WHERE \"idServicio\" = ?";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setInt(1,cadenaBusqueda);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Servicio u = new Servicio();
                u.setIdServicio(rs.getInt(1));
                u.setPrecio(rs.getDouble(2));
                u.setIdCategoria(rs.getInt(3));
                u.setEstado(rs.getString(4));
                u.setNombreServicio(rs.getString(5));
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
    
    
        public void guardarModificadoServicio(Servicio servicio) {
        
        Connection cnx = obtenerConexion();
        String sql = "UPDATE public.\"Servicio\" SET \"idServicio\"=?, precio=?, \"idCategoria\"=?, \"nombreServicio\"=? WHERE \"idServicio\" = ?;";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setInt(1, servicio.getIdServicio());
            stm.setDouble(2, servicio.getPrecio());
            stm.setInt(3, servicio.getIdCategoria());
            stm.setString(4, servicio.getNombreServicio());
            stm.setInt(5, servicio.getIdServicio());
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
        public void eliminarServicio(String cadenaBusqueda) {
        	
        Connection cnx = obtenerConexion();
        String sql = "UPDATE public.\"Servicio\" SET \"estadoTF\"='F' WHERE \"idServicio\" = ?;";
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
        public List<Servicio> consultarServicios(String cadenaBusqueda) {
            List<Servicio> lst = new ArrayList<Servicio>();
            Connection cnx = obtenerConexion();
            String sql = "SELECT \"idServicio\", precio, \"idCategoria\", \"nombreServicio\" FROM public.\"Servicio\" WHERE upper(\"nombreServicio\") LIKE upper(?) and \"estadoTF\"='T' ; ";
            try {
                PreparedStatement stm = cnx.prepareStatement(sql);
                stm.setString(1, "%" + cadenaBusqueda + "%");
                
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                	Servicio u = new Servicio();
                    u.setIdServicio(rs.getInt(1));
                    u.setNombreServicio(rs.getString(2));
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
        public List<Servicio> consultarCategoria() {
            List<Servicio> lst = new ArrayList<Servicio>();
            Connection cnx = obtenerConexion();
            String sql = "SELECT \"idCategoria\", \"nombreCategoria\", \"estadoTF\" FROM public.\"Categoria\" WHERE \"Categoria\".\"estadoTF\"='T';";
            try {
                PreparedStatement stm = cnx.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                	Servicio u = new Servicio();
                    u.setIdCategoria(rs.getInt(1));
                    u.setNombreCategoria(rs.getString(2));
                    u.setEstado(rs.getString(3));
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
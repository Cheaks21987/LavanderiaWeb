package pe.edu.universidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.universidad.entidades.jdbc.Categoria;

public class DaoCategoria extends DaoGenerico {

    public List<Categoria> consultarCategorias() {
        List<Categoria> lst = new ArrayList<Categoria>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"idCategoria\", \"nombreCategoria\", \"estadoTF\" FROM public.\"Categoria\" WHERE \"estadoTF\"='T' ;";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Categoria u = new Categoria();
                u.setId(rs.getInt(1));
                u.setNombreCategoria(rs.getString(2));
                u.setEstadoTF(rs.getString(3));
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
    
    public void registrarCategoria(Categoria categoria) {
    	
        Connection cnx = obtenerConexion();
        String sql = "INSERT INTO public.\"Categoria\"(\"idCategoria\", \"nombreCategoria\", \"estadoTF\") VALUES (nextval('seq_categoria'), ?, ?);";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setString(1, categoria.getNombreCategoria());
            stm.setString(2, categoria.getEstadoTF());
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
    
   
    
    public List<Categoria> editarCategoria(String cadenaBusqueda) {
    	
    	//System.out.println(cadenaBusqueda);
    	
        List<Categoria> lst = new ArrayList<Categoria>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"idCategoria\", \"nombreCategoria\", \"estadoTF\" FROM public.\"Categoria\" WHERE \"idCategoria\" = ?";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setInt(1,Integer. parseInt(cadenaBusqueda));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	Categoria u = new Categoria();
            	u.setId(rs.getInt(1));
                u.setNombreCategoria(rs.getString(2));
                u.setEstadoTF(rs.getString(3));    
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
    
    
    	public void guardarModificadoCategoria(Categoria categoria) {
    	
        Connection cnx = obtenerConexion();
        String sql = "UPDATE public.\"Categoria\" SET \"nombreCategoria\"=? WHERE \"idCategoria\" = ? ;";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setInt(2, categoria.getId());
            stm.setString(1, categoria.getNombreCategoria());
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
    	
    	public void eliminarCategoria(String cadenaBusqueda) {
        	
            Connection cnx = obtenerConexion();
            String sql = "UPDATE public.\"Categoria\" SET \"estadoTF\"='F' WHERE \"idCategoria\" = ?;";
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
    	
    	public List<Categoria> consultarCategorias(String cadenaBusqueda) {
            List<Categoria> lst = new ArrayList<Categoria>();
            Connection cnx = obtenerConexion();
            String sql = "SELECT \"idCategoria\", \"nombreCategoria\" FROM public.\"Categoria\" WHERE upper(\"nombreCategoria\") LIKE upper(?) and \"estadoTF\"='T' ; ";
            try {
                PreparedStatement stm = cnx.prepareStatement(sql);
                stm.setString(1, "%" + cadenaBusqueda + "%");
                
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                	Categoria u = new Categoria();
                    u.setId(rs.getInt(1));
                    u.setNombreCategoria(rs.getString(2));
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
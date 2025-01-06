package pe.edu.universidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import pe.edu.universidad.entidades.jdbc.Categoria;
import pe.edu.universidad.entidades.jdbc.Login;

public class DaoLogin extends DaoGenerico {

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
    
    public void registrarLogin(Login login) {
    	
        Connection cnx = obtenerConexion();
        String sql = "INSERT INTO public.\"Login\"(\"idLogin\", usuario, contrasenia) VALUES ((nextval('seq_login')), ?, ?);";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setString(1, login.getUsuario());
            stm.setString(2, login.getContrasenia());
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
    	
    	
    	public int consultarLogin(String usuario, String contrasenia) {
    		
           int verificar=0;
            Connection cnx = obtenerConexion();
            String sql = "SELECT \"idLogin\", usuario, contrasenia FROM public.\"Login\" WHERE usuario = ? and contrasenia= ?;";
            try {
                PreparedStatement stm = cnx.prepareStatement(sql);
                stm.setString(1, usuario);
                stm.setString(2, contrasenia);
                
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                	
                	verificar=1;
                	
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
            return verificar;
        }
  
}
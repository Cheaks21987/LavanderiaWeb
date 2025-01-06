package pe.edu.universidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import pe.edu.universidad.entidades.jdbc.Categoria;
import pe.edu.universidad.entidades.jdbc.Usuario;

public class DaoUsuario extends DaoGenerico {

    public List<Usuario> consultarTodos() {
        List<Usuario> lst = new ArrayList<Usuario>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"idCliente\", nombre, \"apePat\", \"apeMat\", direccion, telefono, \"DNI\", \"fechaNacimiento\", correo FROM public.\"Cliente\";";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getString(1));
                u.setNombre(rs.getString(2));
                u.setApePat(rs.getString(3));
                u.setApeMat(rs.getString(4));
                u.setDireccion(rs.getString(5));
                u.setTelefono(rs.getInt(6));
                u.setDni(rs.getInt(7));
                u.setFecha(rs.getDate(8));
                u.setCorreo(rs.getString(9));
                
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
    
    
    
    public void registrar(Usuario usuario) {
    	
        Connection cnx = obtenerConexion();
        String sql = "INSERT INTO public.\"Cliente\"( \"idCliente\", nombre, \"apePat\", \"apeMat\", direccion, telefono, \"DNI\", \"fechaNacimiento\", correo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setString(1, usuario.getIdUsuario());
            stm.setString(2, usuario.getNombre());
            stm.setString(3, usuario.getApePat());
            stm.setString(4, usuario.getApeMat());
            stm.setString(5, usuario.getDireccion());
            stm.setInt(6, usuario.getTelefono());
            stm.setInt(7, usuario.getDni());
            stm.setDate(8, new java.sql.Date(usuario.getFecha().getTime()));
            stm.setString(9, usuario.getCorreo());
            
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
    
    public List<Usuario> consultarUsuario(String cadenaBusqueda) {
        List<Usuario> lst = new ArrayList<Usuario>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"idCliente\", nombre, \"apePat\", \"apeMat\", direccion, telefono, \"DNI\", \"fechaNacimiento\", correo\r\n"
        		+ "	FROM public.\"Cliente\" WHERE upper(\"nombre\") LIKE upper(?)";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setString(1, "%" + cadenaBusqueda + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getString(1));
                u.setNombre(rs.getString(2));
                u.setApePat(rs.getString(3));
                u.setApeMat(rs.getString(4));
                u.setDireccion(rs.getString(5));
                u.setTelefono(rs.getInt(6));
                u.setDni(rs.getInt(7));
                u.setFecha(rs.getDate(8));
                u.setCorreo(rs.getString(9));
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
    
    public List<Usuario> editarUsuario(String cadenaBusqueda) {
    	
        List<Usuario> lst = new ArrayList<Usuario>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"idCliente\", nombre, \"apePat\", \"apeMat\", direccion, telefono, \"DNI\", \"fechaNacimiento\", correo\r\n"
        		+ "	FROM public.\"Cliente\" WHERE upper(\"idCliente\") = upper(?)";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setString(1,cadenaBusqueda);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getString(1));
                u.setNombre(rs.getString(2));
                u.setApePat(rs.getString(3));
                u.setApeMat(rs.getString(4));
                u.setDireccion(rs.getString(5));
                u.setTelefono(rs.getInt(6));
                u.setDni(rs.getInt(7));
                u.setFecha(rs.getDate(8));
                u.setCorreo(rs.getString(9));
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
    
    
    	public void guardarModificadoUsuario(Usuario usuario) {
    	
        Connection cnx = obtenerConexion();
        String sql = "UPDATE public.\"Cliente\" SET \"idCliente\"=?, nombre=?, \"apePat\"=?, \"apeMat\"=?, direccion=?, telefono=?, \"DNI\"=?, \"fechaNacimiento\"=?, correo=? WHERE \"idCliente\" = ? ;";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setString(1, usuario.getIdUsuario());
            stm.setString(2, usuario.getNombre());
            stm.setString(3, usuario.getApePat());
            stm.setString(4, usuario.getApeMat());
            stm.setString(5, usuario.getDireccion());
            stm.setInt(6, usuario.getTelefono());
            stm.setInt(7, usuario.getDni());
            stm.setDate(8, new java.sql.Date(usuario.getFecha().getTime()));
            stm.setString(9, usuario.getCorreo());
            stm.setString(10, usuario.getIdUsuario());
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
    	
    	public void eliminarUsuario(String cadenaBusqueda) {
        	
            Connection cnx = obtenerConexion();
            String sql = "DELETE FROM public.\"Cliente\"WHERE \"idCliente\" = ?;";
            try {
                PreparedStatement stm = cnx.prepareStatement(sql);
                stm.setString(1,cadenaBusqueda);             
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
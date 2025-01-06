package pe.edu.universidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.universidad.entidades.jdbc.Persona;
import pe.edu.universidad.entidades.jdbc.PersonaComprobante;
import pe.edu.universidad.entidades.jdbc.Servicio;

public class DaoPersona extends DaoGenerico {

    public List<Persona> consultarTodos() {
        List<Persona> lst = new ArrayList<Persona>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"idPersona\", \"nombrePersona\", \"apellidoPaterno\", \"apellidoMaterno\", dni, direccion, \"Distrito\".\"nombreDistrito\", correo, \"estadoTF\", tipo, \"fechaNacimiento\"  FROM public.\"Persona\"\r\n"
        		+ "INNER JOIN public.\"Distrito\" \r\n"
        		+ "ON \"Distrito\".\"idDistrito\" = \"Persona\".\"idDistrito\" \r\n"
        		+ "WHERE \"Persona\".\"estadoTF\"='T'";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Persona u = new Persona();
                u.setIdPersona(rs.getInt(1));
                u.setNombrePersona(rs.getString(2));
                u.setApellidoPaterno(rs.getString(3));
                u.setApellidoMaterno(rs.getString(4));
                u.setDni(rs.getInt(5));
                u.setDireccion(rs.getString(6));
                u.setNombreDistrito(rs.getString(7));
                u.setCorreo(rs.getString(8));
                u.setEstadoTF(rs.getString(9));
                u.setTipo(rs.getString(10));
                u.setFechaNacimiento(rs.getString(11));
                
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
    public List<Persona> buscarPersona(String cadenaBusqueda) {
        List<Persona> lst = new ArrayList<Persona>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"idPersona\", \"nombrePersona\", \"apellidoPaterno\", \"apellidoMaterno\", dni, direccion, \"Distrito\".\"nombreDistrito\", correo, \"estadoTF\", tipo, \"fechaNacimiento\"  FROM public.\"Persona\"\r\n"
        		+ "INNER JOIN public.\"Distrito\" \r\n"
        		+ "ON \"Distrito\".\"idDistrito\" = \"Persona\".\"idDistrito\" \r\n"
        		+ "WHERE \"Persona\".\"estadoTF\"='T' and (\"nombrePersona\" LIKE ? or \"idPersona\"=?);";
        try { 
            PreparedStatement stm = cnx.prepareStatement(sql);
            
            boolean resultado;
            try {
                Integer.parseInt(cadenaBusqueda);
                //entero
                stm.setString(1, "%" + cadenaBusqueda + "%");
                stm.setInt(2, Integer.parseInt(cadenaBusqueda));
                
            } catch (NumberFormatException excepcion) {
            	//string
            	stm.setString(1, "%" + cadenaBusqueda + "%");
                stm.setInt(2, 0);
            }
            
           
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Persona u = new Persona();
                u.setIdPersona(rs.getInt(1));
                u.setNombrePersona(rs.getString(2));
                u.setApellidoPaterno(rs.getString(3));
                u.setApellidoMaterno(rs.getString(4));
                u.setDni(rs.getInt(5));
                u.setDireccion(rs.getString(6));
                u.setNombreDistrito(rs.getString(7));
                u.setCorreo(rs.getString(8));
                u.setEstadoTF(rs.getString(9));
                u.setTipo(rs.getString(10));
                u.setFechaNacimiento(rs.getString(11));
                
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
    public List<PersonaComprobante> buscarPersonaComprobante(String cadenaBusqueda) {
    	int xd=1;
        List<PersonaComprobante> lst = new ArrayList<PersonaComprobante>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"ComprobantePersona\".\"IdComprobante\", \"ComprobantePersona\".\"IdPersona\",\"Persona\".\"nombrePersona\",\"Persona\".\"apellidoPaterno\",\"Persona\".\"apellidoMaterno\"\r\n"
        		+ "	FROM public.\"ComprobantePersona\"\r\n"
        		+ "	inner join public.\"Persona\" ON \"Persona\".\"idPersona\" = \"ComprobantePersona\".\"IdPersona\" inner join public.\"Comprobante\" ON \"Comprobante\".\"idComprobante\" = \"ComprobantePersona\".\"IdComprobante\" where (\"ComprobantePersona\".\"IdPersona\" = ? or \"Persona\".\"nombrePersona\" LIKE ?) and \"Comprobante\".\"estadoTF\" like '%endiente%'";
        try { 
            PreparedStatement stm = cnx.prepareStatement(sql);
            
            boolean resultado;
            try {
                Integer.parseInt(cadenaBusqueda);
                //entero
                stm.setString(2, "%" + "null" + "%");
                stm.setInt(1, Integer.parseInt(cadenaBusqueda));
                
            } catch (NumberFormatException excepcion) {
            	//string
            	stm.setString(2, "%" + cadenaBusqueda + "%");
                stm.setInt(1, 0);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	PersonaComprobante u = new PersonaComprobante();
            	u.setIdComprobante(rs.getInt(1));
                u.setIdPersona(rs.getInt(2));
                if(xd==1) {
                u.setNombre(rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
                xd=2;
                }
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
    
    public void registrar(Persona persona) {
    	
        Connection cnx = obtenerConexion();
        String sql = "INSERT INTO public.\"Persona\"( \"idPersona\", \"nombrePersona\", \"apellidoPaterno\", \"apellidoMaterno\", dni, direccion, \"idDistrito\", correo, \"estadoTF\", tipo, \"fechaNacimiento\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setInt(1, persona.getIdPersona());
            stm.setString(2, persona.getNombrePersona());
            stm.setString(3, persona.getApellidoPaterno());
            stm.setString(4, persona.getApellidoMaterno());
            stm.setInt(5, persona.getDni());
            stm.setString(6, persona.getDireccion());
            stm.setInt(7, persona.getIdDistrito());
            stm.setString(8, persona.getCorreo());
            stm.setString(9, persona.getEstadoTF());
            stm.setString(10, persona.getTipo());
            stm.setString(11, persona.getFechaNacimiento());
            
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
    
    public List<Persona> consultarPersona(String cadenaBusqueda) {
        List<Persona> lst = new ArrayList<Persona>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"idPersona\", \"nombrePersona\", \"apellidoPaterno\", \"apellidoMaterno\", dni, direccion, \"idDistrito\", correo, \"estadoTF\", tipo, \"fechaNacimiento\"\r\n"
        		+ "	FROM public.\"Persona\" WHERE upper(\"nombrePersona\") LIKE upper(?) and \"estadoTF\"='T' ;";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setString(1, "%" + cadenaBusqueda + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Persona u = new Persona();
                u.setIdPersona(rs.getInt(1));
                u.setNombrePersona(rs.getString(2));
                u.setApellidoPaterno(rs.getString(3));
                u.setApellidoMaterno(rs.getString(4));
                u.setDni(rs.getInt(5));
                u.setDireccion(rs.getString(6));
                u.setIdDistrito(rs.getInt(7));
                u.setCorreo(rs.getString(8));
                u.setEstadoTF(rs.getString(9));
                u.setTipo(rs.getString(10));
                u.setFechaNacimiento(rs.getString(11));
                
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
    
    public List<Persona> editarPersona(int cadenaBusqueda) {
    	
        List<Persona> lst = new ArrayList<Persona>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"idPersona\", \"nombrePersona\", \"apellidoPaterno\", \"apellidoMaterno\", dni, direccion, \"idDistrito\", correo, \"estadoTF\", tipo, \"fechaNacimiento\"\r\n"
        		+ "	FROM public.\"Persona\" WHERE \"idPersona\" = ?";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setInt(1,cadenaBusqueda);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Persona u = new Persona();
                u.setIdPersona(rs.getInt(1));
                u.setNombrePersona(rs.getString(2));
                u.setApellidoPaterno(rs.getString(3));
                u.setApellidoMaterno(rs.getString(4));
                u.setDni(rs.getInt(5));
                u.setDireccion(rs.getString(6));
                u.setIdDistrito(rs.getInt(7));
                u.setCorreo(rs.getString(8));
                u.setEstadoTF(rs.getString(9));
                u.setTipo(rs.getString(10));
                u.setFechaNacimiento(rs.getString(11));
                
                
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
    
    
    	public void guardarModificadoPersona(Persona persona) {
    	
        Connection cnx = obtenerConexion();
        String sql = "UPDATE public.\"Persona\" SET \"idPersona\"=?, \"nombrePersona\"=?, \"apellidoPaterno\"=?, \"apellidoMaterno\"=?, dni=?, direccion=?, \"idDistrito\"=?, correo=?, \"estadoTF\"=?, tipo=?, \"fechaNacimiento\"=? WHERE \"idPersona\" = ? ;";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            
            stm.setInt(1, persona.getIdPersona());
            stm.setString(2, persona.getNombrePersona());
            stm.setString(3, persona.getApellidoPaterno());
            stm.setString(4, persona.getApellidoMaterno());
            stm.setInt(5, persona.getDni());
            stm.setString(6, persona.getDireccion());
            stm.setInt(7, persona.getIdDistrito());
            stm.setString(8, persona.getCorreo());
            stm.setString(9, persona.getEstadoTF());
            stm.setString(10, persona.getTipo());
            stm.setString(11, persona.getFechaNacimiento());
            stm.setInt(12, persona.getIdPersona());
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
    	
    	public void eliminarPersona(String cadenaBusqueda) {
    		Connection cnx = obtenerConexion();
            String sql = "UPDATE public.\"Persona\" SET \"estadoTF\"='F' WHERE \"idPersona\" = ?;";
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
    	public List<Persona> consultarDistrito() {
            List<Persona> lst = new ArrayList<Persona>();
            Connection cnx = obtenerConexion();
            String sql = "SELECT \"idDistrito\", \"nombreDistrito\" FROM public.\"Distrito\";";
            try {
                PreparedStatement stm = cnx.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                	Persona u = new Persona();
                    u.setIdDistrito(rs.getInt(1));
                    u.setNombreDistrito(rs.getString(2));
                    
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
package pe.edu.universidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

import pe.edu.universidad.entidades.jdbc.Categoria;
import pe.edu.universidad.entidades.jdbc.ProgramaVisita;

public class DaoProgramaVisita extends DaoGenerico {

    public List<ProgramaVisita> consultarProgramaVisita() {
        List<ProgramaVisita> lst = new ArrayList<ProgramaVisita>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"idPersona\", \"nombrePersona\", \"apellidoPaterno\" FROM public.\"Persona\" WHERE \"tipo\" = 'Chofer';";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	ProgramaVisita u = new ProgramaVisita();
                u.setIdChofer(rs.getInt(1));
                u.setNombreChofer(rs.getString(2)+" "+rs.getString(3));
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
    
    public List<ProgramaVisita> consultarCliente() {
        List<ProgramaVisita> lst = new ArrayList<ProgramaVisita>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"idPersona\",\"nombrePersona\", \"apellidoPaterno\", \"apellidoMaterno\" FROM public.\"Persona\" WHERE tipo='Cliente' and \"estadoTF\"='T'";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	ProgramaVisita u = new ProgramaVisita();
                u.setIdCliente(rs.getInt(1));
                u.setNombreCliente(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
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
    
    public void registrarProgramaVisita(ProgramaVisita programaVisita) {
    	
        Connection cnx = obtenerConexion();  
        String sql = "INSERT INTO public.\"Comprobante\"(tipo,\"idComprobante\", \"estadoServicio\",fecha, observacion,\"estadoTF\",\"idVehiculo\",total) VALUES ('Delivery',nextval('seq_programavisita'), ?, ?, ?,'pendiente',?,'0');";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setString(1, programaVisita.getEstadoServicio());
            stm.setString(2,programaVisita.getFecha());
            stm.setString(3, programaVisita.getObservaciones());
            stm.setInt(4, programaVisita.getIdVehiculo());
            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        String sql2 = "INSERT INTO public.\"ComprobantePersona\"(\"IdComprobante\", \"IdPersona\") VALUES (nextval('seq_programavisita')-1, ?);";
        try {
            PreparedStatement stm2 = cnx.prepareStatement(sql2);
            stm2.setInt(1, programaVisita.getIdCliente());
            stm2.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        String sql3 = "INSERT INTO public.\"ComprobantePersona\"(\"IdComprobante\", \"IdPersona\") VALUES (nextval('seq_programavisita')-2, ?);";
        try {
            PreparedStatement stm3 = cnx.prepareStatement(sql3);
            stm3.setInt(1, programaVisita.getIdChofer());
            stm3.executeUpdate();
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
    
public int registrarComprobante(ProgramaVisita programaVisita) {
    	
        Connection cnx = obtenerConexion();  
        String sql = "INSERT INTO public.\"Comprobante\"(tipo,\"idComprobante\", \"estadoServicio\",fecha, observacion,\"estadoTF\",total) VALUES ('Local',nextval('seq_programavisita'), ?, ?, ?,'pendiente','0');";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            stm.setString(1, programaVisita.getEstadoServicio());
            stm.setString(2,programaVisita.getFecha());
            stm.setString(3, programaVisita.getObservaciones());
           
            stm.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        String sql2 = "INSERT INTO public.\"ComprobantePersona\"(\"IdComprobante\", \"IdPersona\") VALUES (nextval('seq_programavisita')-1, ?);";
        try {
            PreparedStatement stm2 = cnx.prepareStatement(sql2);
            stm2.setInt(1, programaVisita.getIdCliente());
            stm2.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } 
        
        String sqlCN = "SELECT \"idComprobante\" FROM public.\"Comprobante\" \r\n"
        		+ "ORDER BY \"idComprobante\" DESC limit 1";
        int CN=0;
        try {
        	 
            PreparedStatement stmCN = cnx.prepareStatement(sqlCN);
            ResultSet rsCN = stmCN.executeQuery();
            while (rsCN.next()) {
            	CN=rsCN.getInt(1);
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
        
        return CN;
        
    }
    
    public List<ProgramaVisita> consultarTodos() {
        List<ProgramaVisita> lst = new ArrayList<ProgramaVisita>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"Comprobante\".\"idComprobante\", \"Vehiculo\".\"nombre\",\"Persona\".\"nombrePersona\",\"Persona\".\"apellidoPaterno\",\"Persona\".\"direccion\",\r\n"
        		+ "\"Distrito\".\"nombreDistrito\",\"Comprobante\".fecha,\"Comprobante\".\"estadoServicio\"   FROM public.\"Comprobante\"\r\n"
        		+ "INNER JOIN public.\"ComprobantePersona\" \r\n"
        		+ "ON \"ComprobantePersona\".\"IdComprobante\" = \"Comprobante\".\"idComprobante\"\r\n"
        		+ "INNER JOIN public.\"Persona\"\r\n"
        		+ "ON \"Persona\".\"idPersona\" = \"ComprobantePersona\".\"IdPersona\"\r\n"
        		+ "INNER JOIN public.\"Vehiculo\"\r\n"
        		+ "ON \"Vehiculo\".\"idVehiculo\" = \"Comprobante\".\"idVehiculo\" \r\n"
        		+ "INNER JOIN public.\"Distrito\"\r\n"
        		+ "ON \"Distrito\".\"idDistrito\" = \"Persona\".\"idDistrito\"\r\n"
        		+ "WHERE \"Persona\".tipo='Cliente'";
        try {
        	
            PreparedStatement stm = cnx.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	ProgramaVisita u = new ProgramaVisita();
                u.setId(rs.getInt(1));
                u.setNombreVehiculo(rs.getString(2));
                u.setNombreCliente(rs.getString(3)+rs.getString(4));;
                u.setDireccion(rs.getString(5)+ " - " +rs.getString(6));
                u.setFecha(rs.getString(7));
                u.setEstado(rs.getString(8));
                
                
                
                String sql2 ="SELECT  \"Persona\".\"nombrePersona\",\"Persona\".\"apellidoPaterno\"\r\n"
                		+ "FROM public.\"ComprobantePersona\"\r\n"
                		+ "INNER JOIN public.\"Persona\"\r\n"
                		+ "ON \"Persona\".\"idPersona\" = \"ComprobantePersona\".\"IdPersona\"\r\n"
                		+ "WHERE \"Persona\".\"tipo\"='Chofer' and \"ComprobantePersona\".\"IdComprobante\"=?";
                Connection cnx2 = obtenerConexion();           
                try {
                    PreparedStatement stm2 = cnx2.prepareStatement(sql2);
                    stm2.setInt(1,(rs.getInt(1)));
                    ResultSet rs2 = stm2.executeQuery();
                    while (rs2.next()) {
                    	ProgramaVisita u2 = new ProgramaVisita();
                        u.setNombreChofer(rs2.getString(1)+rs2.getString(2));
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    try {
                        cnx2.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
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
    
    public List<ProgramaVisita> consultarVehiculo() {
        List<ProgramaVisita> lst = new ArrayList<ProgramaVisita>();
        Connection cnx = obtenerConexion();
        String sql = "SELECT \"idVehiculo\", nombre FROM public.\"Vehiculo\" WHERE \"estadoTF\" = 'T';";
        try {
            PreparedStatement stm = cnx.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	ProgramaVisita u = new ProgramaVisita();
                u.setIdVehiculo(rs.getInt(1));
                u.setNombreVehiculo(rs.getString(2));
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
package pe.edu.universidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.universidad.entidades.jdbc.ComprobanteServicio;
import pe.edu.universidad.entidades.jdbc.Persona;

public class DaoComprobanteServicio extends DaoGenerico {

	public List<ComprobanteServicio> consultarComprobanteServicio() {
		List<ComprobanteServicio> lst = new ArrayList<ComprobanteServicio>();
		Connection cnx = obtenerConexion();
		String sql = "SELECT \"Comprobante\".\"idComprobante\", \"Prenda\".\"nombrePrenda\", cantidad, \"Servicio\".\"nombreServicio\", subtotal ,\"ComprobanteServicio\".\"estadoTF\", \"Persona\".\"nombrePersona\", \"Persona\".\"apellidoPaterno\" FROM public.\"ComprobanteServicio\"\r\n"
				+ "INNER JOIN public.\"Comprobante\" \r\n"
				+ "ON \"Comprobante\".\"idComprobante\" = \"ComprobanteServicio\".\"idComprobante\" \r\n"
				+ "INNER JOIN public.\"Prenda\" \r\n"
				+ "ON \"Prenda\".\"idPrenda\" = \"ComprobanteServicio\".\"idPrenda\" \r\n"
				+ "INNER JOIN public.\"Servicio\" \r\n"
				+ "ON \"Servicio\".\"idServicio\" = \"ComprobanteServicio\".\"idServicio\" \r\n"
				+ "INNER JOIN public.\"Persona\" \r\n"
				+ "ON \"Persona\".\"idPersona\" = \"ComprobanteServicio\".\"idPersona\" \r\n"
				+ "WHERE \"ComprobanteServicio\".\"estadoTF\"='T';";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ComprobanteServicio u = new ComprobanteServicio();
				u.setIdComprobante(rs.getInt(1));
				u.setNombrePrenda(rs.getString(2));
				u.setCantidad(rs.getInt(3));
				u.setNombreServicio(rs.getString(4));
				u.setSubtotal(rs.getDouble(5));
				u.setEstadoTF(rs.getString(6));
				u.setNombrePersona(rs.getString(7) + "" + rs.getString(8));
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

	public List<ComprobanteServicio> buscarComprobanteServicio(int cadenaBusqueda) {
		List<ComprobanteServicio> lst = new ArrayList<ComprobanteServicio>();
		Connection cnx = obtenerConexion();
		String sql = "SELECT \"Comprobante\".\"idComprobante\", \"Prenda\".\"nombrePrenda\", cantidad, \"Servicio\".\"nombreServicio\", subtotal, \"ComprobanteServicio\".\"estadoTF\", \"Persona\".\"nombrePersona\", \"Persona\".\"apellidoPaterno\" FROM public.\"ComprobanteServicio\"\r\n"
				+ "INNER JOIN public.\"Comprobante\" \r\n"
				+ "ON \"Comprobante\".\"idComprobante\" = \"ComprobanteServicio\".\"idComprobante\" \r\n"
				+ "INNER JOIN public.\"Prenda\" \r\n"
				+ "ON \"Prenda\".\"idPrenda\" = \"ComprobanteServicio\".\"idPrenda\" \r\n"
				+ "INNER JOIN public.\"Servicio\" \r\n"
				+ "ON \"Servicio\".\"idServicio\" = \"ComprobanteServicio\".\"idServicio\" \r\n"
				+ "INNER JOIN public.\"Persona\" \r\n"
				+ "ON \"Persona\".\"idPersona\" = \"ComprobanteServicio\".\"idPersona\" \r\n"
				+ "WHERE \"ComprobanteServicio\".\"idComprobante\" = ? and \"Persona\".\"idPersona\" = ? and \"ComprobanteServicio\".\"estadoTF\"='T';";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setInt(1, cadenaBusqueda);
			stm.setInt(2, cadenaBusqueda);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ComprobanteServicio u = new ComprobanteServicio();
				u.setIdComprobante(rs.getInt(1));
				u.setNombrePrenda(rs.getString(2));
				u.setCantidad(rs.getInt(3));
				u.setNombreServicio(rs.getString(4));
				u.setSubtotal(rs.getDouble(5));
				u.setEstadoTF(rs.getString(6));
				u.setNombrePersona(rs.getString(7) + "" + rs.getString(8));
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

	public List<ComprobanteServicio> buscarComprobanteServicioRopa(int cadenaBusqueda) {
		List<ComprobanteServicio> lst = new ArrayList<ComprobanteServicio>();
		Connection cnx = obtenerConexion();
		String sql = "SELECT \"ComprobanteServicio\".\"idComprobante\", \"ComprobanteServicio\".\"idServicio\",\"Servicio\".\"nombreServicio\", \"ComprobanteServicio\".cantidad, \"ComprobanteServicio\".\"idPrenda\",\"Prenda\".\"nombrePrenda\", \"ComprobanteServicio\".subtotal\r\n"
				+ "	FROM public.\"ComprobanteServicio\" \r\n"
				+ "	inner join public.\"Servicio\" ON \"Servicio\".\"idServicio\" = \"ComprobanteServicio\".\"idServicio\"\r\n"
				+ "	inner join public.\"Prenda\" ON \"Prenda\".\"idPrenda\" = \"ComprobanteServicio\".\"idPrenda\"\r\n"
				+ "	where \"ComprobanteServicio\".\"idComprobante\" = ?\r\n" + "	\r\n" + "	";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setInt(1, cadenaBusqueda);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ComprobanteServicio u = new ComprobanteServicio();
				u.setIdComprobante(rs.getInt(1));
				u.setIdServicio(rs.getInt(2));
				u.setNombreServicio(rs.getString(3));
				u.setCantidad(rs.getInt(4));
				u.setIdPrenda(rs.getInt(5));
				u.setNombrePrenda(rs.getString(6));
				u.setSubtotal(rs.getDouble(7));
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

	public void registrarComprobanteServicio(ComprobanteServicio comprobanteServicio) {

		Connection cnx = obtenerConexion();
		String sql = "INSERT INTO public.\"ComprobanteServicio\"(\"idComprobante\", \"idPrenda\", cantidad, \"idServicio\", subtotal, \"estadoTF\", \"idPersona\") VALUES (?, ?, ?, ?, ?, ?, ?);";
		try {
			String sql1 = "SELECT precio FROM public.\"Servicio\" WHERE \"idServicio\" = ?";
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setInt(1, comprobanteServicio.getIdComprobante());
			stm.setInt(2, comprobanteServicio.getIdPrenda());
			stm.setInt(3, comprobanteServicio.getCantidad());
			stm.setInt(4, comprobanteServicio.getIdServicio());
			try {
				PreparedStatement stm1 = cnx.prepareStatement(sql1);
				stm1.setInt(1, comprobanteServicio.getIdServicio());
				ResultSet rs = stm1.executeQuery();
				while (rs.next()) {
					ComprobanteServicio u = new ComprobanteServicio();
					u.setPrecioServicio(rs.getDouble(1));
					stm.setDouble(5, rs.getDouble(1) * comprobanteServicio.getCantidad());
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			stm.setString(6, comprobanteServicio.getEstadoTF());
			stm.setInt(7, comprobanteServicio.getIdPersona());
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
	
	public void editarComprobanteEstado(ComprobanteServicio comprobanteServicio) {

		Connection cnx = obtenerConexion();
		String sql = "UPDATE public.\"Comprobante\"\r\n"
				+ "	SET  \"estadoTF\" = ?\r\n"
				+ "	WHERE \"idComprobante\" = ?;";
		
			try {
				PreparedStatement stm = cnx.prepareStatement(sql);
				stm.setInt(2, comprobanteServicio.getIdComprobante());
				stm.setString(1, comprobanteServicio.getEstadoTF());
				ResultSet rs = stm.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public List<ComprobanteServicio> consultarComprobante() {
		List<ComprobanteServicio> lst = new ArrayList<ComprobanteServicio>();
		Connection cnx = obtenerConexion();
		String sql = "SELECT \"idComprobante\", \"estadoTF\" FROM public.\"Comprobante\" WHERE \"Comprobante\".\"estadoTF\"='T';";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ComprobanteServicio u = new ComprobanteServicio();
				u.setIdComprobante(rs.getInt(1));
				u.setEstadoTF(rs.getString(2));
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

	public List<ComprobanteServicio> consultarPrenda() {
		List<ComprobanteServicio> lst = new ArrayList<ComprobanteServicio>();
		Connection cnx = obtenerConexion();
		String sql = "SELECT \"idPrenda\", \"nombrePrenda\", \"estadoTF\" FROM public.\"Prenda\" WHERE \"Prenda\".\"estadoTF\"='T';";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ComprobanteServicio u = new ComprobanteServicio();
				u.setIdPrenda(rs.getInt(1));
				u.setNombrePrenda(rs.getString(2));
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

	public List<ComprobanteServicio> consultarServicio() {
		List<ComprobanteServicio> lst = new ArrayList<ComprobanteServicio>();
		Connection cnx = obtenerConexion();
		String sql = "SELECT \"idServicio\", \"nombreServicio\", \"estadoTF\" FROM public.\"Servicio\" WHERE \"Servicio\".\"estadoTF\"='T';";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ComprobanteServicio u = new ComprobanteServicio();
				u.setIdServicio(rs.getInt(1));
				u.setNombreServicio(rs.getString(2));
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

	public List<ComprobanteServicio> consultarPersona() {
		List<ComprobanteServicio> lst = new ArrayList<ComprobanteServicio>();
		Connection cnx = obtenerConexion();
		String sql = "SELECT \"idPersona\", \"nombrePersona\", \"apellidoPaterno\", \"estadoTF\" FROM public.\"Persona\" WHERE \"Persona\".\"estadoTF\"='T' and tipo='Cliente';";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ComprobanteServicio u = new ComprobanteServicio();
				u.setIdPersona(rs.getInt(1));
				u.setNombrePersona(rs.getString(2) + "" + rs.getString(3));
				u.setEstadoTF(rs.getString(4));
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

	public List<ComprobanteServicio> editarComprobanteServicio(int cadenaBusqueda) {
		List<ComprobanteServicio> lst = new ArrayList<ComprobanteServicio>();
		Connection cnx = obtenerConexion();
		String sql = "SELECT \"idComprobante\", \"idPrenda\", cantidad , \"idServicio\", \"estadoTF\", \"idPersona\"\r\n"
				+ "FROM public.\"ComprobanteServicio\" WHERE \"idComprobante\" = ?";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setInt(1, cadenaBusqueda);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {

				ComprobanteServicio u = new ComprobanteServicio();

				u.setIdComprobante(rs.getInt(1));
				u.setIdPrenda(rs.getInt(2));
				u.setCantidad(rs.getInt(3));
				u.setIdServicio(rs.getInt(4));
				u.setEstadoTF(rs.getString(5));
				u.setIdPersona(rs.getInt(6));

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

	public void guardarModificadoComprobanteServicio(ComprobanteServicio comprobanteServicio) {

		Connection cnx = obtenerConexion();
		String sql = "UPDATE public.\"ComprobanteServicio\" SET \"idComprobante\"=?, \"idPrenda\"=?, cantidad =?, \"idServicio\"=?, \"estadoTF\"=?, \"idPersona\"=? WHERE \"idComprobante\" = ? ;";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);

			stm.setInt(1, comprobanteServicio.getIdComprobante());
			stm.setInt(2, comprobanteServicio.getIdPrenda());
			stm.setInt(3, comprobanteServicio.getCantidad());
			stm.setInt(4, comprobanteServicio.getIdServicio());
			stm.setString(5, comprobanteServicio.getEstadoTF());
			stm.setInt(6, comprobanteServicio.getIdPersona());
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

	public void eliminarComprobanteServicio(String cadenaBusqueda) {

		Connection cnx = obtenerConexion();
		String sql = "UPDATE public.\"ComprobanteServicio\" SET \"estadoTF\"='F' WHERE \"idComprobante\" = ?;";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setInt(1, Integer.parseInt(cadenaBusqueda));
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

	public List<ComprobanteServicio> calcularTotal(int cadenaBusqueda) {
		List<ComprobanteServicio> lst = new ArrayList<ComprobanteServicio>();
		Connection cnx = obtenerConexion();
		String sql = "SELECT SUM(subtotal) FROM public.\"ComprobanteServicio\" WHERE \"idPersona\" = ?";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setInt(1, cadenaBusqueda);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ComprobanteServicio u = new ComprobanteServicio();
				u.setTotal(rs.getDouble(1));
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

	public List<ComprobanteServicio> buscarTotal(int cadenaBusqueda) {
		List<ComprobanteServicio> lst = new ArrayList<ComprobanteServicio>();
		Connection cnx = obtenerConexion();
		Double total = 111.0;

		String sql2 = "SELECT  sum(subtotal) FROM public.\"ComprobanteServicio\" where \"estadoTF\"='T' and \"idComprobante\"=?";
		try {
			PreparedStatement stm2 = cnx.prepareStatement(sql2);
			stm2.setInt(1, cadenaBusqueda);
			ResultSet rs2 = stm2.executeQuery();
			while (rs2.next()) {
				total = rs2.getDouble(1);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		String sql3 = "UPDATE public.\"Comprobante\" SET total=? WHERE \"idComprobante\"=?";
		try {
			PreparedStatement stm3 = cnx.prepareStatement(sql3);
			stm3.setDouble(1, total);
			stm3.setInt(2, cadenaBusqueda);
			stm3.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		String sql = "SELECT total FROM public.\"Comprobante\" where \"idComprobante\" = ? ;";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setInt(1, cadenaBusqueda);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ComprobanteServicio u = new ComprobanteServicio();
				u.setTotal(rs.getDouble(1));
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

	public List<ComprobanteServicio> PrendaComprobante(int cadenaBusqueda) {
		List<ComprobanteServicio> lst = new ArrayList<ComprobanteServicio>();
		Connection cnx = obtenerConexion();
		String sql = "SELECT DISTINCT  \"ComprobanteServicio\".\"idPrenda\",\"Prenda\".\"nombrePrenda\"\r\n"
				+ "	FROM public.\"Comprobante\"\r\n"
				+ "	inner join public.\"ComprobantePersona\" ON \"ComprobantePersona\".\"IdComprobante\" = \"Comprobante\".\"idComprobante\"\r\n"
				+ "	inner join public.\"Persona\" ON \"Persona\".\"idPersona\" = \"ComprobantePersona\".\"IdPersona\"\r\n"
				+ "	inner join public.\"ComprobanteServicio\" ON \"ComprobanteServicio\".\"idComprobante\" = \"Comprobante\".\"idComprobante\"\r\n"
				+ "	inner join public.\"Prenda\" ON \"Prenda\".\"idPrenda\" = \"ComprobanteServicio\".\"idPrenda\"\r\n"
				+ "	where \"Persona\".tipo='Cliente' and \"Comprobante\".\"idComprobante\"=?;";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setInt(1, cadenaBusqueda);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ComprobanteServicio u = new ComprobanteServicio();
				u.setIdPrenda(rs.getInt(1));
				u.setNombrePrenda(rs.getString(2));
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

	public void guardarComprobanteServicio(ComprobanteServicio comprobanteServicio) {

		Connection cnx = obtenerConexion();
		String sql = "INSERT INTO public.\"ComprobanteServicio\"(\r\n"
				+ "	\"idComprobante\", \"idServicio\", cantidad, \"idPrenda\", subtotal, \"estadoTF\")\r\n"
				+ "	VALUES (?, ?, ?, ?, ?, 'T');";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setInt(1, comprobanteServicio.getIdComprobante());
			stm.setInt(2, comprobanteServicio.getIdServicio());
			stm.setInt(3, comprobanteServicio.getCantidad());
			stm.setInt(4, comprobanteServicio.getIdPrenda());

			String sql2 = "SELECT precio FROM public.\"Servicio\" where \"idServicio\" = ?";
			try {
				PreparedStatement stm2 = cnx.prepareStatement(sql2);
				stm2.setInt(1, comprobanteServicio.getIdServicio());
				ResultSet rs2 = stm2.executeQuery();
				while (rs2.next()) {
					stm.setDouble(5, comprobanteServicio.getCantidad() * rs2.getDouble(1));
				}

			} catch (Exception e) {
				throw new RuntimeException(e);
			}

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

	public void eliminarSs(int cadenaBusqueda1, int cadenaBusqueda2, int cadenaBusqueda3) {

		Connection cnx = obtenerConexion();
		String sql = "DELETE FROM public.\"ComprobanteServicio\" WHERE \"idComprobante\"=? and \"idServicio\"=? and \"idPrenda\"=?";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setInt(1, cadenaBusqueda1);
			stm.setInt(2, cadenaBusqueda2);
			stm.setInt(3, cadenaBusqueda3);
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

	public List<ComprobanteServicio> consultarComprobantes() {
		List<ComprobanteServicio> lst = new ArrayList<ComprobanteServicio>();
		Connection cnx = obtenerConexion();
		String sql = "SELECT \"Comprobante\".\"idComprobante\",CONCAT(\"Persona\".\"nombrePersona\",\"Persona\".\"apellidoPaterno\") ,\"Comprobante\".fecha,  \"Comprobante\".tipo, \"Comprobante\".\"estadoTF\", \"Comprobante\".total\r\n"
				+ "FROM public.\"Comprobante\"\r\n"
				+ "INNER JOIN public.\"ComprobantePersona\" ON \"ComprobantePersona\".\"IdComprobante\" = \"Comprobante\".\"idComprobante\"\r\n"
				+ "INNER JOIN public.\"Persona\" ON \"Persona\".\"idPersona\" = \"ComprobantePersona\".\"IdPersona\"\r\n"
				+ "WHERE \"Persona\".tipo='Cliente' and \"Comprobante\".\"estadoTF\" like '%diente%' ";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ComprobanteServicio u = new ComprobanteServicio();
				
				u.setIdComprobante(rs.getInt(1));
				u.setNombrePersona(rs.getString(2));
				u.setFecha(rs.getString(3));
				u.setTipo(rs.getString(4));
				u.setEstadoTF(rs.getString(5));
				u.setTotal(rs.getDouble(6));
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
	public List<ComprobanteServicio> generarComprobante() {
		List<ComprobanteServicio> lst = new ArrayList<ComprobanteServicio>();
		Connection cnx = obtenerConexion();
		String sql = "INSERT INTO public.\"Comprobante\"(\r\n"
				+ "	\"idComprobante\", tipo, total,\"estadoServicio\", \"estadoTF\")\r\n"
				+ "	VALUES (nextval('seq_comprobante'), 'Lavanderia', 0.0,'Lavado en lavanderia', 'pendiente' );\r\n"
				+ "	";
        String sql2 = "SELECT \"idComprobante\" \r\n"
        		+ "	FROM public.\"Comprobante\"\r\n"
        		+ "	order by  \"idComprobante\" desc\r\n"
        		+ "	limit 1";
        try {
			PreparedStatement stm2 = cnx.prepareStatement(sql);
			ResultSet rs2 = stm2.executeQuery();
			while (rs2.next()) {
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
        
		try {	
			PreparedStatement stm = cnx.prepareStatement(sql2);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				ComprobanteServicio u = new ComprobanteServicio();			
				u.setIdComprobante(rs.getInt(1));
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

package pe.edu.universidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.universidad.entidades.jdbc.Prenda;

public class DaoPrenda extends DaoGenerico {

	public List<Prenda> consultarPrenda() {
		List<Prenda> lst = new ArrayList<Prenda>();
		Connection cnx = obtenerConexion();
		String sql = "SELECT \"idPrenda\", \"nombrePrenda\", \"Marca\".\"nombreMarca\", \"Material\".\"nombreMaterial\", \"Color\".\"nombreColor\", observacion, \"estadoTF\" FROM public.\"Prenda\"\r\n"
				+ "INNER JOIN public.\"Marca\" \r\n" + "ON \"Marca\".\"idMarca\" = \"Prenda\".\"idMarca\" \r\n"
				+ "INNER JOIN public.\"Material\" \r\n"
				+ "ON \"Material\".\"idMaterial\" = \"Prenda\".\"idMaterial\" \r\n" + "INNER JOIN public.\"Color\" \r\n"
				+ "ON \"Color\".\"idColor\" = \"Prenda\".\"idColor\" \r\n" + "WHERE \"estadoTF\"='T';";

		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Prenda u = new Prenda();
				u.setIdPrenda(rs.getInt(1));
				u.setNombrePrenda(rs.getString(2));
				u.setNombreMarca(rs.getString(3));
				u.setNombreMaterial(rs.getString(4));
				u.setNombreColor(rs.getString(5));
				u.setObservacion(rs.getString(6));
				u.setEstadoTF(rs.getString(7));
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

	public List<Prenda> buscarPrenda(String cadenaBusqueda) {
		List<Prenda> lst = new ArrayList<Prenda>();
		Connection cnx = obtenerConexion();
		String sql = "SELECT \"idPrenda\", \"nombrePrenda\", \"Marca\".\"nombreMarca\", \"Material\".\"nombreMaterial\", \"Color\".\"nombreColor\", observacion, \"estadoTF\" FROM public.\"Prenda\"\r\n"
				+ "INNER JOIN public.\"Marca\" \r\n" + "ON \"Marca\".\"idMarca\" = \"Prenda\".\"idMarca\" \r\n"
				+ "INNER JOIN public.\"Material\" \r\n"
				+ "ON \"Material\".\"idMaterial\" = \"Prenda\".\"idMaterial\" \r\n" + "INNER JOIN public.\"Color\" \r\n"
				+ "ON \"Color\".\"idColor\" = \"Prenda\".\"idColor\" \r\n"
				+ "WHERE \"estadoTF\"='T' and \"nombrePrenda\" LIKE ?";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setString(1, "%" + cadenaBusqueda + "%");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Prenda u = new Prenda();
				u.setIdPrenda(rs.getInt(1));
				u.setNombrePrenda(rs.getString(2));
				u.setNombreMarca(rs.getString(3));
				u.setNombreMaterial(rs.getString(4));
				u.setNombreColor(rs.getString(5));
				u.setObservacion(rs.getString(6));
				u.setEstadoTF(rs.getString(7));
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

	public void registrarPrenda(Prenda prenda) {
		
		
		Connection cnx = obtenerConexion();
		String sql = "INSERT INTO public.\"Prenda\"(\"idPrenda\", \"nombrePrenda\", \"idMarca\", \"idMaterial\", \"idColor\", observacion, \"estadoTF\") VALUES (nextval('seq_prenda'), ?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setString(1, prenda.getNombrePrenda());
			stm.setInt(2, prenda.getIdMarca());
			stm.setInt(3, prenda.getIdMaterial());
			stm.setInt(4, prenda.getIdColor());
			stm.setString(5, prenda.getObservacion());
			stm.setString(6, prenda.getEstadoTF());
			stm.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		String sql3 = "INSERT INTO public.\"ComprobanteServicio\"(\r\n"
				+ "	\"idComprobante\", \"idServicio\", cantidad, \"idPrenda\", subtotal, \"estadoTF\")\r\n"
				+ "	VALUES (?, ?, ?, nextval('seq_prenda')-1, ?, 'T');";
		try {
			PreparedStatement stm3 = cnx.prepareStatement(sql3);
			stm3.setInt(1, prenda.getIdC());
			stm3.setInt(2, prenda.getIdS());
			stm3.setInt(3, prenda.getCantidad());

			String sql2 = "SELECT precio FROM public.\"Servicio\" where \"idServicio\" = ?";
			try {
				PreparedStatement stm2 = cnx.prepareStatement(sql2);
				stm2.setInt(1, prenda.getIdS());
				ResultSet rs2 = stm2.executeQuery();
				while (rs2.next()) {
					stm3.setDouble(4, prenda.getCantidad() * rs2.getDouble(1));
				}

			} catch (Exception e) {
				throw new RuntimeException(e);
			}

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

	public List<Prenda> consultarPrenda(String cadenaBusqueda) {
		List<Prenda> lst = new ArrayList<Prenda>();
		Connection cnx = obtenerConexion();
		String sql = "SELECT \"idPrenda\", \"nombrePrenda\", \"idMarca\", \"idMaterial\", \"idColor\", observacion, \"estadoTF\"\r\n"
				+ " FROM public.\"Prenda\" WHERE upper(\"nombrePrenda\") LIKE upper(?) and \"estadoTF\"='T' ;";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setString(1, "%" + cadenaBusqueda + "%");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Prenda u = new Prenda();
				u.setIdPrenda(rs.getInt(1));
				u.setNombrePrenda(rs.getString(2));
				u.setIdMarca(rs.getInt(3));
				u.setIdMaterial(rs.getInt(4));
				u.setIdColor(rs.getInt(5));
				u.setObservacion(rs.getString(6));
				u.setEstadoTF(rs.getString(7));
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

	public List<Prenda> editarPrenda(String cadenaBusqueda) {

		List<Prenda> lst = new ArrayList<Prenda>();
		Connection cnx = obtenerConexion();
		String sql = "SELECT \"idPrenda\", \"nombrePrenda\", \"Marca\".\"idMarca\", \"Material\".\"idMaterial\", \"Color\".\"idColor\", observacion, \"estadoTF\", \"Marca\".\"nombreMarca\", \"Material\".\"nombreMaterial\", \"Color\".\"nombreColor\" FROM public.\"Prenda\" \r\n"
				+ "INNER JOIN public.\"Marca\" \r\n" + "ON \"Marca\".\"idMarca\" = \"Prenda\".\"idMarca\" \r\n"
				+ "INNER JOIN public.\"Material\" \r\n"
				+ "ON \"Material\".\"idMaterial\" = \"Prenda\".\"idMaterial\" \r\n" + "INNER JOIN public.\"Color\" \r\n"
				+ "ON \"Color\".\"idColor\" = \"Prenda\".\"idColor\" \r\n" + "WHERE \"idPrenda\" = ?";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setInt(1, Integer.parseInt(cadenaBusqueda));
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Prenda u = new Prenda();

				u.setIdPrenda(rs.getInt(1));
				u.setNombrePrenda(rs.getString(2));
				u.setIdMarca(rs.getInt(3));
				u.setIdMaterial(rs.getInt(4));
				u.setIdColor(rs.getInt(5));
				u.setObservacion(rs.getString(6));
				u.setEstadoTF(rs.getString(7));
				u.setNombreMarca(rs.getString(8));
				u.setNombreMaterial(rs.getString(9));
				u.setNombreColor(rs.getString(10));

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

	public void guardarModificadoPrenda(Prenda prenda) {

		Connection cnx = obtenerConexion();
		String sql = "UPDATE public.\"Prenda\" SET \"idPrenda\"=?, \"nombrePrenda\"=?, \"idMarca\"=?, \"idMaterial\"=?, \"idColor\"=?, observacion=?, \"estadoTF\"= ? WHERE \"idPrenda\" = ? ;";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setInt(1, prenda.getIdPrenda());
			stm.setString(2, prenda.getNombrePrenda());
			stm.setInt(3, prenda.getIdMarca());
			stm.setInt(4, prenda.getIdMaterial());
			stm.setInt(5, prenda.getIdColor());
			stm.setString(6, prenda.getObservacion());
			stm.setString(7, prenda.getEstadoTF());
			stm.setInt(8, prenda.getIdPrenda());

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

	public void eliminarPrenda(String cadenaBusqueda) {

		Connection cnx = obtenerConexion();
		String sql = "UPDATE public.\"Prenda\" SET \"estadoTF\"='F'  WHERE \"idPrenda\" = ?;";
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

	public List<Prenda> consultarMarca() {
		List<Prenda> lst = new ArrayList<Prenda>();
		Connection cnx = obtenerConexion();
		String sql = "SELECT \"idMarca\", \"nombreMarca\" FROM public.\"Marca\";";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Prenda u = new Prenda();
				u.setIdMarca(rs.getInt(1));
				u.setNombreMarca(rs.getString(2));
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

	public List<Prenda> consultarMaterial() {
		List<Prenda> lst = new ArrayList<Prenda>();
		Connection cnx = obtenerConexion();
		String sql = "SELECT \"idMaterial\", \"nombreMaterial\" FROM public.\"Material\";";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Prenda u = new Prenda();
				u.setIdMaterial(rs.getInt(1));
				u.setNombreMaterial(rs.getString(2));
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

	public List<Prenda> consultarColor() {
		List<Prenda> lst = new ArrayList<Prenda>();
		Connection cnx = obtenerConexion();
		String sql = "SELECT \"idColor\", \"nombreColor\" FROM public.\"Color\";";
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Prenda u = new Prenda();
				u.setIdColor(rs.getInt(1));
				u.setNombreColor(rs.getString(2));
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
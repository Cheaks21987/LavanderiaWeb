package pe.edu.universidad.proc.cone;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
	
	public Conectar conectar()throws SQLException, ClassNotFoundException{
		
		String url="jdbc:postgresql://127.0.0.1:5432/bet";
		String usuario="root";
		String clave="12345678";
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection(url,usuario,clave);
		
		if(conn!=null) {
			System.out.println("Se conecto a la bas");
		}else {
			System.out.println("Nooo se conecto a l");
		}
		return null;
		
		
		
	}
	
	public Connection establecerConexion() {
		Connection conectar=null;
		String usuario="postgres";
		String contra="12345678";
		String bd="dblavanderiautp";
		String ip="localhost";
		String puerto="5432";
		String cadena="jdbc:postgresql://"+ip+":"+puerto+"/"+bd;
		
		try {
			Class.forName("org.postgresql.Driver");
			conectar=DriverManager.getConnection(cadena, usuario, contra);
			System.out.println("Se conecto a la base de datos");
		} catch (Exception e) {
			System.out.println("No2 se conecto a la base de datos");
		}
		
		return conectar;
		
	}


}

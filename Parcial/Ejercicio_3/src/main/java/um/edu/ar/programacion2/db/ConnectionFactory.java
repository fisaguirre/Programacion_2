/**
 * 
 */
package um.edu.ar.programacion2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author fernando
 *
 */
public class ConnectionFactory {

	public static final String URL = "jdbc:mysql://localhost:3306/transactions";
	public static final String USER = "root";
	public static final String PASS = "root";

	// Registro de MYsql en el driver manager

	public static Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/transactions?autoReconnect=true&useSSL=false&user=" + USER + "&password=" + PASS;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			//con = DriverManager.getConnection(URL, USER, PASS);
			con = DriverManager.getConnection(url);

			if (con != null) {
				System.out.println("Conectado");
				return con;
			}
		} catch (SQLException e) {
			System.out.println("No se pudo conectar a la base de datos");
			e.printStackTrace();
		}
		return null;
	}

}

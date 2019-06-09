/**
 * 
 */
package um.edu.ar.programacion2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import um.edu.ar.programacion2.db.ConnectionFactory;
import um.edu.ar.programacion2.entidades.Persona;
import um.edu.ar.programacion2.entidades.Producto;
import um.edu.ar.programacion2.interfaces.IPersonaDao;

/**
 * @author fernando
 *
 */
public class PersonaDao implements IPersonaDao {

	protected Connection con;

	public PersonaDao() {
		Connection conect = ConnectionFactory.getConnection();
		this.con = conect;
	}

	public void insertar(Persona persona) {
		// Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;

		String sqlInsertar = "Insert into Persona VALUES (null,?,?);";

		try {

			stmt = this.con.prepareStatement(sqlInsertar);
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.execute();

			// Paso 4 - Cerrar conexión
			stmt.close();
			// this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void actualizar(Persona p) {
		// TODO Auto-generated method stub

	}

	public void borrar(Persona p) {
		// TODO Auto-generated method stub

	}

	public Persona find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> findAll(List<Persona> persona) {
		// Connection con = ConnectionFactory.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<Persona> lista_personas = new ArrayList<Persona>();

		for (int i = 0; i < persona.size(); i++) {

			String sqlBuscar = "SELECT * FROM Persona WHERE nombre = '" + persona.get(i).getNombre() + "';";

			try {
				stmt = this.con.createStatement();
				rs = stmt.executeQuery(sqlBuscar);

				if (rs.next()) {
					Integer persona_id = rs.getInt("persona_id");
					persona.get(i).setPersona_id(persona_id);
				}
				stmt.close();
				// this.con.close();
			} catch (SQLException ex) {
				// ex.printStackTrace();
			}
		}

		return persona;
	}

}

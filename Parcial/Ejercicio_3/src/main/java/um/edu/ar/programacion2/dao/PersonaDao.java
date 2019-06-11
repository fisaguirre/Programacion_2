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

	public PersonaDao(Connection conect) {
		// Connection conect = ConnectionFactory.getConnection();
		this.con = conect;
	}

	public void insertar(Persona persona) {
		// Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;

		String sqlInsertar = "Insert into Persona VALUES (null,?,?,?,?);";

		try {

			stmt = this.con.prepareStatement(sqlInsertar);
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setLong(3, persona.getDocumento());
			stmt.setBoolean(4, persona.getActivo());
			stmt.execute();

			// Paso 4 - Cerrar conexión
			stmt.close();
			// this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean actualizar(Persona p) {
		Statement stmt = null;
		String sqlModificar = "Update Persona SET nombre = '" + p.getNombre() + "', apellido = '" + p.getApellido()
				+ "' , documento = '" + p.getDocumento() + "', activo = '" + p.getActivo() + "' WHERE persona_id = '"
				+ p.getPersona_id() + "';";

		try {

			stmt = con.createStatement();
			stmt.executeUpdate(sqlModificar);

			// Paso 4 - Cerrar conexión
			stmt.close();
			return true;
			// con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean borrar(Persona p) {
		Statement stmt = null;
		String sqlBorrar = "Delete from Persona WHERE persona_id=" + p.getPersona_id() + ";";

		try {

			stmt = this.con.createStatement();
			stmt.execute(sqlBorrar);

			// Paso 4 - Cerrar conexión
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public Persona find(Integer id) {
		Statement stmt = null;
		ResultSet rs = null;

		String sqlFind = "Select * from Persona Where persona_id = '" + id + "';";

		try {
			stmt = this.con.createStatement();
			rs = stmt.executeQuery(sqlFind);
			if (rs.next()) {
				Persona per_buscada = new Persona(rs.getInt("persona_id"), rs.getString("nombre"),
						rs.getString("apellido"), rs.getLong("documento"), rs.getBoolean("activo"));
				return per_buscada;
			}
		} catch (Exception e) {
			System.out.println("Error");
			// TODO: handle exception
		}
		return null;
	}

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

	public List<Persona> findAllActivos() {
		// Connection con = ConnectionFactory.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<Persona> lista_personas = new ArrayList<Persona>();

		// for (int i = 0; i < persona.size(); i++) {

		String sqlBuscar = "SELECT * FROM Persona WHERE activo = 'true' or '1';";

		try {
			stmt = this.con.createStatement();
			rs = stmt.executeQuery(sqlBuscar);
			while (rs.next()) {
				Integer id = rs.getInt("persona_id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				Long documento = rs.getLong("documento");
				Boolean activo = rs.getBoolean("activo");
				Persona persona = new Persona(id, nombre, apellido, documento, activo);
				lista_personas.add(persona);
			}

			stmt.close();
			// this.con.close();
		} catch (SQLException ex) {
			// ex.printStackTrace();
		}
		// }

		return lista_personas;
	}

	public List<Persona> findByNombreOrApellidoLike(String nombre) {
		// Connection con = ConnectionFactory.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<Persona> lista_personas = new ArrayList<Persona>();

		// for (int i = 0; i < persona.size(); i++) {

		String sqlBuscar = "SELECT * FROM Persona WHERE nombre = '"+nombre+"' or apellido = '"+nombre+"';";

		try {
			stmt = this.con.createStatement();
			rs = stmt.executeQuery(sqlBuscar);
			while (rs.next()) {
				Integer id = rs.getInt("persona_id");
				String nombre_p = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				Long documento = rs.getLong("documento");
				Boolean activo = rs.getBoolean("activo");
				Persona persona = new Persona(id, nombre_p, apellido, documento, activo);
				lista_personas.add(persona);
			}

			stmt.close();
			// this.con.close();
		} catch (SQLException ex) {
			// ex.printStackTrace();
		}
		// }

		return lista_personas;

	}

}

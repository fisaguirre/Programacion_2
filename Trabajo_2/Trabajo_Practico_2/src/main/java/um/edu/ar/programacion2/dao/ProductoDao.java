/**
 * 
 */
package um.edu.ar.programacion2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import um.edu.ar.programacion2.db.ConnectionFactory;
import um.edu.ar.programacion2.entidades.Producto;
import um.edu.ar.programacion2.interfaces.IProductoDao;

/**
 * @author fernando
 *
 */
public class ProductoDao implements IProductoDao {

	protected Connection con;

	public ProductoDao() {
		Connection conect = ConnectionFactory.getConnection();
		this.con = conect;
	}

	public void insertar(Producto producto) {

		// Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;

		String sqlInsertar = "Insert into Producto VALUES (null,?,?,?);";

		try {

			stmt = this.con.prepareStatement(sqlInsertar);
			stmt.setString(1, producto.getNombre());
			stmt.setString(2, producto.getDescripcion());
			stmt.setLong(3, producto.getPrecio());
			stmt.execute();

			// Paso 4 - Cerrar conexión
			stmt.close();
			// this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void actualizar(Producto pr, Integer producto_id) {
		Connection con = ConnectionFactory.getConnection();

		// Paso 2 - ejecucion de SQL
		Statement stmt = null;
		String sqlModificar = "Update Producto SET nombre=" + pr.getNombre() + ", descripcion=" + pr.getDescripcion()
				+ ", precio=" + pr.getPrecio() + " WHERE producto_id=" + producto_id + ";";

		try {

			stmt = con.createStatement();

			stmt.executeUpdate(sqlModificar);

			// Paso 4 - Cerrar conexión
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void borrar(Integer producto_id) {
		Connection con = ConnectionFactory.getConnection();

		// Paso 2 - ejecucion de SQL
		Statement stmt = null;
		String sqlBorrar = "Delete from Producto WHERE producto_id=" + producto_id + ";";

		try {

			stmt = con.createStatement();
			stmt.execute(sqlBorrar);

			// Paso 4 - Cerrar conexión
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Producto find(Long id) {
		Connection con = ConnectionFactory.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		String sqlBuscar = "select * from Producto WHERE producto_id=" + id + ";";

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlBuscar);
			// Paso 3 - leer datos
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcion");
				Integer precio = rs.getInt("precio");
				System.out.println("ID: " + String.valueOf(id) + " - Nombre: " + nombre + " - Descripcion: "
						+ descripcion + " - Precio: " + precio);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public List<Producto> findAll(List<Producto> producto) {

		// Connection con = ConnectionFactory.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		for (int i = 0; i < producto.size(); i++) {

			String sqlBuscar = "SELECT * FROM Producto WHERE nombre = '" + producto.get(i).getNombre() + "';";

			try {
				stmt = this.con.createStatement();
				rs = stmt.executeQuery(sqlBuscar);

				if (rs.next()) {
				} else {
					System.out.println("se registra: " + producto.get(i).getNombre());
					this.insertar(producto.get(i));
				}
				stmt.close();
				// this.con.close();
			} catch (SQLException ex) {
				// ex.printStackTrace();
			}
		}

		ArrayList<Producto> lista_productos = new ArrayList<Producto>();

		for (int i = 0; i < producto.size(); i++) {

			String sqlBuscar = "SELECT * FROM Producto WHERE nombre = '" + producto.get(i).getNombre() + "';";

			try {
				stmt = this.con.createStatement();
				rs = stmt.executeQuery(sqlBuscar);

				if (rs.next()) {
					Integer producto_id = rs.getInt("producto_id");
					producto.get(i).setProducto_id(producto_id);
					lista_productos.add(producto.get(i));
				}
				stmt.close();
				// this.con.close();
			} catch (SQLException ex) {
				// ex.printStackTrace();
			}
		}

		return lista_productos;
	}

}

package um.edu.ar.programacion2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Exception.VentaAPersonaDesactivadaException;
import um.edu.ar.programacion2.db.ConnectionFactory;
import um.edu.ar.programacion2.entidades.Producto;
import um.edu.ar.programacion2.entidades.Ventas;
import um.edu.ar.programacion2.interfaces.IVentasDao;

public class VentasDao implements IVentasDao {

	protected Connection con;

	public VentasDao(Connection conect) {
		//Connection conect = ConnectionFactory.getConnection();
		this.con = conect;
	}

	public void insertar(Ventas venta) {

		// Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;

		String sqlInsertar = "Insert into Ventas VALUES (null,?,?,?);";

		String sqlInsertar_intermedia = "Insert into Venta_producto VALUES (null,?,?);";
		
		String sqlVerificar = "Select * from Persona WHERE persona_id = '"+venta.getPersona_id()+"';";
		
		try {
			Statement stmt_0 = null;
			ResultSet rs_0 = null;

			try {
				stmt_0 = this.con.createStatement();
				rs_0 = stmt_0.executeQuery(sqlVerificar);
				if(rs_0.next()) {
					Boolean activo = rs_0.getBoolean("activo");
					if (activo==false) {
						throw new VentaAPersonaDesactivadaException(1);
					}
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			

			stmt = this.con.prepareStatement(sqlInsertar);
			stmt.setInt(1, venta.getPersona_id());
			stmt.setString(2, venta.getDescripcion());
			stmt.setString(3, venta.getFechaVenta());
			stmt.execute();

			// Paso 4 - Cerrar conexión
			stmt.close();
			// this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sqlBuscar_id = "SELECT * FROM Ventas ORDER BY venta_id DESC Limit 1;";

		Statement stmt_2 = null;
		ResultSet rs_2 = null;

		try {
			stmt_2 = this.con.createStatement();
			rs_2 = stmt_2.executeQuery(sqlBuscar_id);

			if (rs_2.next()) {
				Integer id_venta = rs_2.getInt("venta_id");
				venta.setVenta_id(id_venta);
			}
			stmt_2.close();
			// this.con.close();
		} catch (SQLException ex) {
			// ex.printStackTrace();
		}

		ArrayList<Producto> lista_producto = new ArrayList<Producto>();
		lista_producto = (ArrayList<Producto>) venta.getProductos();
		PreparedStatement stmt_3 = null;
		for (int i = 0; i < lista_producto.size(); i++) {
			try {
				stmt_3 = this.con.prepareStatement(sqlInsertar_intermedia);
				stmt_3.setInt(1, venta.getVenta_id());
				stmt_3.setInt(2, lista_producto.get(i).getProducto_id());
				stmt_3.execute();
				stmt_3.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public void actualizar(Ventas vt, Integer venta_id) {
		// TODO Auto-generated method stub

	}

	
	public boolean borrar(Ventas venta) {
		// Paso 2 - ejecucion de SQL
		Statement stmt = null;
		String sqlBorrar = "Delete from Ventas WHERE venta_id=" + venta.getVenta_id() + ";";

		try {

			stmt = this.con.createStatement();
			stmt.execute(sqlBorrar);

			// Paso 4 - Cerrar conexión
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Statement stmt_2 = null;
		String sqlBorrar_2 = "Delete from Venta_producto WHERE venta_id=" + venta.getVenta_id() + ";";

		try {

			stmt_2 = this.con.createStatement();
			stmt_2.execute(sqlBorrar_2);

			// Paso 4 - Cerrar conexión
			stmt_2.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public Ventas find(Integer id) {
		Statement stmt = null;
		ResultSet rs = null;

		String sqlFind = "Select * from Ventas "
				+ "INNER JOIN Venta_producto ON Venta_producto.venta_id = Ventas.venta_id "
				+ "INNER JOIN Producto ON Producto.producto_id = Venta_producto.producto_id "
				+ "WHERE Ventas.venta_id = '" + id + "';";
		try {
			stmt = this.con.createStatement();
			rs = stmt.executeQuery(sqlFind);
			while (rs.next()) {
				System.out.println("una venta es: " + rs.getString("Producto.nombre"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<Ventas> findAll(List<Ventas> venta) {
		// TODO Auto-generated method stub
		return null;
	}

}

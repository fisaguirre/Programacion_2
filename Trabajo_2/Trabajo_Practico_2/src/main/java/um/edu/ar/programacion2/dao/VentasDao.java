package um.edu.ar.programacion2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import um.edu.ar.programacion2.db.ConnectionFactory;
import um.edu.ar.programacion2.entidades.Producto;
import um.edu.ar.programacion2.entidades.Ventas;
import um.edu.ar.programacion2.interfaces.IVentasDao;

public class VentasDao implements IVentasDao {

	protected Connection con;

	public VentasDao() {
		Connection conect = ConnectionFactory.getConnection();
		this.con = conect;
	}

	@Override
	public void insertar(Ventas venta) {

		// Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;

		String sqlInsertar = "Insert into Ventas VALUES (null,?,?,?);";

		String sqlInsertar_intermedia = "Insert into Venta_producto VALUES (null,?,?);";

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

		String sqlBuscar_id = "SELECT * FROM Ventas ORDER BY ventas_id DESC Limit 1;";

		Statement stmt_2 = null;
		ResultSet rs_2 = null;

		try {
			stmt_2 = this.con.createStatement();
			rs_2 = stmt_2.executeQuery(sqlBuscar_id);

			if (rs_2.next()) {
				Integer id_venta = rs_2.getInt("ventas_id");
				venta.setVenta_id(id_venta);
			}
			stmt_2.close();
			// this.con.close();
		} catch (SQLException ex) {
			// ex.printStackTrace();
		}

		ArrayList<Producto> lista_producto = new ArrayList<Producto>();
		lista_producto = (ArrayList<Producto>) venta.getProductos();

		for (int i = 0; i < lista_producto.size(); i++) {
			try {
				stmt = this.con.prepareStatement(sqlInsertar_intermedia);
				stmt.setInt(1, venta.getVenta_id());
				stmt.setInt(2, lista_producto.get(i).getProducto_id());
				stmt.execute();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public void actualizar(Ventas vt, Integer venta_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Integer venta_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Ventas find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ventas> findAll(List<Ventas> venta) {
		// TODO Auto-generated method stub
		return null;
	}

}

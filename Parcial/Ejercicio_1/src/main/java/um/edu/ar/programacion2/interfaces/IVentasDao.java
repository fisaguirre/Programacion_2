package um.edu.ar.programacion2.interfaces;

import java.util.List;

import um.edu.ar.programacion2.entidades.Ventas;

public interface IVentasDao {

	public void insertar(Ventas venta);

	public void actualizar(Ventas vt, Integer venta_id);

	public boolean borrar(Ventas venta);

	public Ventas find(Integer id);

	public List<Ventas> findAll(List<Ventas> venta);
}

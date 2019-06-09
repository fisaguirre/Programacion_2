package um.edu.ar.programacion2.interfaces;

import java.util.List;

import um.edu.ar.programacion2.entidades.Producto;

public interface IProductoDao {

	public void insertar(Producto producto);

	public boolean actualizar(Producto producto);

	public boolean borrar(Producto producto);

	public Producto find(Integer id);

	public List<Producto> findAll(List<Producto> producto);
}

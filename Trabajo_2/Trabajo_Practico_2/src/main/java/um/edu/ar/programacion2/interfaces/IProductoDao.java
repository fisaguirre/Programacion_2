package um.edu.ar.programacion2.interfaces;

import java.util.List;

import um.edu.ar.programacion2.entidades.Producto;

public interface IProductoDao {

	public void insertar(Producto producto);

	public void actualizar(Producto pr, Integer producto_id);

	public void borrar(Integer producto_id);

	public Producto find(Long id);

	public List<Producto> findAll(List<Producto> producto);
}

package um.edu.ar.programacion2.entidades;

public class Producto {

	protected Integer producto_id;
	protected String nombre;
	protected String descripcion;
	protected Integer precio;

	public Producto() {

	}

	public Producto(String nombre, String descripcion, Integer precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Producto(Integer producto_id, String nombre, String descripcion, Integer precio) {
		super();
		this.producto_id = producto_id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Integer getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(Integer producto_id) {
		this.producto_id = producto_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

}

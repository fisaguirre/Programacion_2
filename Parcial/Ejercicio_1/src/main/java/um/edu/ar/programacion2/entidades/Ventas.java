package um.edu.ar.programacion2.entidades;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import um.edu.ar.programacion2.entidades.Producto;

public class Ventas {

	protected Integer venta_id;
	protected String fechaVenta;
	protected Integer valorVenta;
	protected String descripcion;
	protected Integer persona_id;
	protected List<Producto> productos;

	public Ventas() {

	}

	public Ventas(Integer valorVenta, String descripcion) {
		super();
		this.fechaVenta = this.getFechaAhora();
		this.valorVenta = valorVenta;
		this.descripcion = descripcion;
		this.productos = new ArrayList<Producto>();

		// this.productos = this.push(producto);;
		// this.push(producto);
	}

	public Integer getVenta_id() {
		return venta_id;
	}

	public void setVenta_id(Integer venta_id) {
		this.venta_id = venta_id;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Integer getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(Integer valorVenta) {
		this.valorVenta = valorVenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public Integer getPersona_id() {
		return persona_id;
	}

	public void setPersona_id(Integer persona_id) {
		this.persona_id = persona_id;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public void push(Producto producto) throws InterruptedException {
		this.productos.add(producto);
		System.out.println("se agrego producto a la lista de ventas");
	}

	public Producto pop() {
		Producto retorno = null;
		retorno = this.productos.get(0);
		// con el get no elimino de la lista, solo la obtengo
		return retorno;
	}

	private String getFechaAhora() {
		String patron = "YYYY-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(patron);
		String fecha = sdf.format(new Date());
		return fecha;
	}

}

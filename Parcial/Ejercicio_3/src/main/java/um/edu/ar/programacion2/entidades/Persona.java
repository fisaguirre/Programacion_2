/**
 * 
 */
package um.edu.ar.programacion2.entidades;

import java.util.ArrayList;
import java.util.List;
import um.edu.ar.programacion2.entidades.Ventas;

/**
 * @author fernando
 *
 */

public class Persona {

	protected Integer persona_id;
	protected String nombre;
	protected String apellido;
	protected Long documento;
	protected Boolean activo;
	protected List<Ventas> ventas;

	public Persona() {

	}

	public Persona(String nombre, String apellido, Long documento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.activo = true;
		this.ventas = new ArrayList<Ventas>();
	}
	
	public Persona(Integer persona_id, String nombre, String apellido, Long documento, Boolean activo) {
		super();
		this.persona_id=persona_id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.activo = activo;
		this.ventas = new ArrayList<Ventas>();
	}

	public Integer getPersona_id() {
		return persona_id;
	}

	public void setPersona_id(Integer persona_id) {
		this.persona_id = persona_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getDocumento() {
		return documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public List<Ventas> getVentas() {
		return ventas;
	}

	public void setVentas(List<Ventas> ventas) {
		this.ventas = ventas;
	}

	public void push(Ventas venta) throws InterruptedException {
		this.ventas.add(venta);
		System.out.println("se agrego venta a la lista de persona");
	}

	public Ventas pop() {
		Ventas retorno = null;
		retorno = this.ventas.get(0);
		// con el get no elimino de la lista, solo la obtengo
		return retorno;
	}

}

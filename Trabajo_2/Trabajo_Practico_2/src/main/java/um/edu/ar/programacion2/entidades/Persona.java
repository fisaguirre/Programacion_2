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
	protected List<Ventas> ventas;

	public Persona() {

	}
	// para asignar datos correctamente debemos considerar el valor NULO en la base
	// de datos.
	// El valor predeterminado para primitivas java es un valor como 0 en el caso de
	// int, por lo
	// que deberíamos proporcionar un nuevo tipo de datos que pueda contener el
	// valor nulo. Podemos
	// hacerlo usando un tipo especial de objetos llamados envoltorios como Integer
	// en lugar de int.

	// una buena practica es generar el constructor vacio, el sobrecargado con todo,
	// y uno sin el id

	public Persona(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
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

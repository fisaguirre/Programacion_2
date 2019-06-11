/**
 * 
 */
package um.edu.ar.programacion2.arranque;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import um.edu.ar.programacion2.dao.PersonaDao;
import um.edu.ar.programacion2.dao.ProductoDao;
import um.edu.ar.programacion2.dao.VentasDao;
import um.edu.ar.programacion2.db.ConnectionFactory;
import um.edu.ar.programacion2.entidades.Persona;
import um.edu.ar.programacion2.entidades.Producto;
import um.edu.ar.programacion2.entidades.Ventas;
import um.edu.ar.programacion2.interfaces.IPersonaDao;
import um.edu.ar.programacion2.interfaces.IProductoDao;
import um.edu.ar.programacion2.interfaces.IVentasDao;

/**
 * @author fernando
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		Connection conect = ConnectionFactory.getConnection();

		IProductoDao producto_dao = new ProductoDao(conect);
		IPersonaDao persona_dao = new PersonaDao(conect);
		IVentasDao ventas_dao = new VentasDao(conect);

		// CREAMOS PERSONAS
		Persona persona_1 = new Persona("Fernando", "Isaguirre", 39088047L);
		Persona persona_2 = new Persona("David", "Videau", 401234567L);
		Persona persona_3 = new Persona("Jeronimo", "Taber", 50456879L);
		Persona persona_4 = new Persona("Andres", "Soria", 123456789L);
		Persona persona_5 = new Persona("Julian", "Lopez", 38948765L);
		Persona persona_6 = new Persona("Leandro", "Herrera", 555666777L);

		// LISTA DE PERSONAS CREADAS
		ArrayList<Persona> lista_personas = new ArrayList<Persona>();

		lista_personas.add(persona_1);
		lista_personas.add(persona_2);
		lista_personas.add(persona_3);
		lista_personas.add(persona_4);
		lista_personas.add(persona_5);
		lista_personas.add(persona_6);

		// AGREGAMOS LAS PERSONAS A LA BASE DE DATOS
		System.out.println("Agregando personas a la base de datos");
		persona_dao.insertar(persona_1);
		persona_dao.insertar(persona_2);
		persona_dao.insertar(persona_3);
		persona_dao.insertar(persona_4);
		persona_dao.insertar(persona_5);
		persona_dao.insertar(persona_6);

		// EN lista_personas GUARDAMOS LA LISTA DE LAS PERSONAS CON LOS IDS REGISTRADOS
		lista_personas = (ArrayList<Persona>) persona_dao.findAll(lista_personas);

		Producto producto_1 = new Producto("cocacola", "bebida", 200);
		Producto producto_2 = new Producto("lays", "solido", 300);
		Producto producto_3 = new Producto("lapiz", "utiles", 100);
		Producto producto_4 = new Producto("regla", "utiles", 100);
		Producto producto_5 = new Producto("celular", "electronica", 100);
		Producto producto_6 = new Producto("notebook", "electronica", 200);
		Producto producto_7 = new Producto("mouse", "electronica", 300);

		// CREAMOS LISTA DE PRODUCTOS
		ArrayList<Producto> lista_producto_1 = new ArrayList<Producto>();
		lista_producto_1.add(producto_1);
		lista_producto_1.add(producto_2);
		lista_producto_1.add(producto_3);
		lista_producto_1.add(producto_4);
		lista_producto_1.add(producto_5);
		lista_producto_1 = (ArrayList<Producto>) producto_dao.findAll(lista_producto_1);

		ArrayList<Producto> lista_producto_2 = new ArrayList<Producto>();
		lista_producto_2.add(producto_1);
		lista_producto_2.add(producto_2);
		lista_producto_2.add(producto_3);
		lista_producto_2.add(producto_5);
		lista_producto_2.add(producto_7);
		lista_producto_2 = (ArrayList<Producto>) producto_dao.findAll(lista_producto_2);

		// CREAMOS VENTAS
		Ventas venta_1 = new Ventas(3000, "primera venta");
		Ventas venta_2 = new Ventas(2000, "segunda venta");

		// SETEAMOS LA LISTA DE PRODUCTOS Y LA PERSONA EN CADA VENTA
		venta_1.setProductos(lista_producto_1);
		venta_1.setPersona_id(lista_personas.get(0).getPersona_id());
		ventas_dao.insertar(venta_1);

		venta_2.setProductos(lista_producto_2);
		venta_2.setPersona_id(lista_personas.get(0).getPersona_id());
		ventas_dao.insertar(venta_2);

	}

}

/**
 * 
 */
package um.edu.ar.programacion2.arranque;

import java.util.ArrayList;
import java.util.List;

import um.edu.ar.programacion2.dao.PersonaDao;
import um.edu.ar.programacion2.dao.ProductoDao;
import um.edu.ar.programacion2.dao.VentasDao;
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
		// TODO Auto-generated method stub

		// agregar venta, verificar si existe producto para esa venta, en caso de que no
		// exista, agregar
		// primero el producto y seguir con la venta, en caso de que exista el producto
		// seguir con la venta

		IProductoDao producto_dao = new ProductoDao();
		IPersonaDao persona_dao = new PersonaDao();
		IVentasDao ventas_dao = new VentasDao();

		Persona persona_1 = new Persona("Fernando", "Isaguirre");
		Persona persona_2 = new Persona("David", "Videau");
		Persona persona_3 = new Persona("Jeronimo", "Taber");
		Persona persona_4 = new Persona("Andres", "Soria");
		Persona persona_5 = new Persona("Julian", "Lopez");
		Persona persona_6 = new Persona("Leandro", "Herrera");

		ArrayList<Persona> lista_personas = new ArrayList<Persona>();

		lista_personas.add(persona_1);
		lista_personas.add(persona_2);
		lista_personas.add(persona_3);
		lista_personas.add(persona_4);
		lista_personas.add(persona_5);
		lista_personas.add(persona_6);

		persona_dao.insertar(persona_1);
		persona_dao.insertar(persona_2);
		persona_dao.insertar(persona_3);
		persona_dao.insertar(persona_4);
		persona_dao.insertar(persona_5);
		persona_dao.insertar(persona_6);

		lista_personas = (ArrayList<Persona>) persona_dao.findAll(lista_personas);
		/*
		 * System.out.println("las personas son: "); for (int i = 0; i <
		 * lista_personas.size(); i++) { System.out.println("id: " +
		 * lista_personas.get(i).getPersona_id()); System.out.println("nombre: " +
		 * lista_personas.get(i).getNombre()); System.out.println("apellido: " +
		 * lista_personas.get(i).getApellido()); }
		 */
		Producto producto_1 = new Producto("cocacola", "bebida", 200);
		Producto producto_2 = new Producto("lays", "solido", 300);
		Producto producto_3 = new Producto("lapiz", "utiles", 100);
		Producto producto_4 = new Producto("regla", "utiles", 100);
		Producto producto_5 = new Producto("celular", "electronica", 100);
		Producto producto_6 = new Producto("notebook", "electronica", 200);
		Producto producto_7 = new Producto("mouse", "electronica", 300);
		Producto producto_8 = new Producto("pendrive", "electronica", 100);
		Producto producto_9 = new Producto("monitor", "electronica", 200);
		Producto producto_10 = new Producto("teclado", "electronica", 100);

		ArrayList<Producto> lista_producto_1 = new ArrayList<Producto>();
		lista_producto_1.add(producto_1);
		lista_producto_1.add(producto_2);
		lista_producto_1.add(producto_3);
		lista_producto_1.add(producto_4);
		lista_producto_1.add(producto_5);

		ArrayList<Producto> lista_producto_2 = new ArrayList<Producto>();
		lista_producto_1.add(producto_1);
		lista_producto_1.add(producto_3);
		lista_producto_1.add(producto_5);
		lista_producto_1.add(producto_7);
		lista_producto_1.add(producto_9);

		ArrayList<Producto> lista_producto_3 = new ArrayList<Producto>();
		lista_producto_1.add(producto_2);
		lista_producto_1.add(producto_4);
		lista_producto_1.add(producto_6);
		lista_producto_1.add(producto_8);
		lista_producto_1.add(producto_10);

		ArrayList<Producto> lista_producto_4 = new ArrayList<Producto>();
		lista_producto_1.add(producto_1);
		lista_producto_1.add(producto_2);
		lista_producto_1.add(producto_5);
		lista_producto_1.add(producto_6);
		lista_producto_1.add(producto_7);

		ArrayList<Producto> lista_producto_5 = new ArrayList<Producto>();
		lista_producto_1.add(producto_5);
		lista_producto_1.add(producto_7);
		lista_producto_1.add(producto_8);
		lista_producto_1.add(producto_9);
		lista_producto_1.add(producto_10);

		// lista que se va a almacenar en la venta
		ArrayList<Producto> lista_de_productos = new ArrayList<Producto>();
		lista_de_productos = (ArrayList<Producto>) producto_dao.findAll(lista_producto_1);
		/*
		 * for (int a = 0; a < lista_de_productos.size(); a++) {
		 * System.out.println("id: " + lista_de_productos.get(a).getProducto_id());
		 * System.out.println("nombre: " + lista_de_productos.get(a).getNombre()); }
		 */

		// crear venta y setear la lista de productos en la venta
		Ventas venta_1 = new Ventas(3000, "primera venta");
		Ventas venta_2 = new Ventas(2000, "segunda venta");
		Ventas venta_3 = new Ventas(4000, "tercera venta");
		Ventas venta_4 = new Ventas(6000, "cuarta venta");
		Ventas venta_5 = new Ventas(8000, "quinta venta");
		Ventas venta_6 = new Ventas(1000, "sexta venta");

		venta_1.setProductos(lista_producto_1);
		venta_1.setPersona_id(lista_personas.get(0).getPersona_id());
		ventas_dao.insertar(venta_1);

		venta_2.setProductos(lista_producto_2);
		venta_2.setPersona_id(lista_personas.get(0).getPersona_id());
		ventas_dao.insertar(venta_2);

		venta_3.setProductos(lista_producto_2);
		venta_3.setPersona_id(lista_personas.get(1).getPersona_id());
		ventas_dao.insertar(venta_3);
		
		venta_4.setProductos(lista_producto_3);
		venta_4.setPersona_id(lista_personas.get(2).getPersona_id());
		ventas_dao.insertar(venta_4);
		
		venta_5.setProductos(lista_producto_4);
		venta_5.setPersona_id(lista_personas.get(3).getPersona_id());
		ventas_dao.insertar(venta_5);
		
		venta_6.setProductos(lista_producto_5);
		venta_6.setPersona_id(lista_personas.get(3).getPersona_id());
		ventas_dao.insertar(venta_6);
		
		//falta buscar persona
		//buscar producto
		//buscar venta
		//borrar persona
		//borrar producto
		//borrar venta
		//actualizar persona
		//actualizar producto
		//actualizar venta

	}

}

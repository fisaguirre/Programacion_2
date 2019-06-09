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
		// TODO Auto-generated method stub

		// agregar venta, verificar si existe producto para esa venta, en caso de que no
		// exista, agregar
		// primero el producto y seguir con la venta, en caso de que exista el producto
		// seguir con la venta
		
		Connection conect = ConnectionFactory.getConnection();

		IProductoDao producto_dao = new ProductoDao(conect);
		IPersonaDao persona_dao = new PersonaDao(conect);
		IVentasDao ventas_dao = new VentasDao(conect);

		// CREAMOS PERSONAS
		Persona persona_1 = new Persona("Fernando", "Isaguirre");
		Persona persona_2 = new Persona("David", "Videau");
		Persona persona_3 = new Persona("Jeronimo", "Taber");
		Persona persona_4 = new Persona("Andres", "Soria");
		Persona persona_5 = new Persona("Julian", "Lopez");
		Persona persona_6 = new Persona("Leandro", "Herrera");

		// LISTA DE PERSONAS CREADAS
		ArrayList<Persona> lista_personas = new ArrayList<Persona>();

		lista_personas.add(persona_1);
		lista_personas.add(persona_2);
		lista_personas.add(persona_3);
		lista_personas.add(persona_4);
		lista_personas.add(persona_5);
		lista_personas.add(persona_6);

		// AGREGAMOS LAS PERSONAS A LA BASE DE DATOS
		persona_dao.insertar(persona_1);
		persona_dao.insertar(persona_2);
		persona_dao.insertar(persona_3);
		persona_dao.insertar(persona_4);
		persona_dao.insertar(persona_5);
		persona_dao.insertar(persona_6);

		// EN lista_personas GUARDAMOS LA LISTA DE LAS PERSONAS CON LOS IDS REGISTRADOS
		lista_personas = (ArrayList<Persona>) persona_dao.findAll(lista_personas);

		// CREAMOS LOS PRODUCTOS
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
		lista_producto_2.add(producto_3);
		lista_producto_2.add(producto_5);
		lista_producto_2.add(producto_7);
		lista_producto_2.add(producto_9);
		lista_producto_2 = (ArrayList<Producto>) producto_dao.findAll(lista_producto_2);

		ArrayList<Producto> lista_producto_3 = new ArrayList<Producto>();
		lista_producto_3.add(producto_2);
		lista_producto_3.add(producto_4);
		lista_producto_3.add(producto_6);
		lista_producto_3.add(producto_8);
		lista_producto_3.add(producto_10);
		lista_producto_3 = (ArrayList<Producto>) producto_dao.findAll(lista_producto_3);

		ArrayList<Producto> lista_producto_4 = new ArrayList<Producto>();
		lista_producto_4.add(producto_1);
		lista_producto_4.add(producto_2);
		lista_producto_4.add(producto_5);
		lista_producto_4.add(producto_6);
		lista_producto_4.add(producto_7);
		lista_producto_4 = (ArrayList<Producto>) producto_dao.findAll(lista_producto_4);

		ArrayList<Producto> lista_producto_5 = new ArrayList<Producto>();
		lista_producto_5.add(producto_5);
		lista_producto_5.add(producto_7);
		lista_producto_5.add(producto_8);
		lista_producto_5.add(producto_9);
		lista_producto_5.add(producto_10);
		lista_producto_5 = (ArrayList<Producto>) producto_dao.findAll(lista_producto_5);

		// CREAMOS VENTAS
		Ventas venta_1 = new Ventas(3000, "primera venta");
		Ventas venta_2 = new Ventas(2000, "segunda venta");
		Ventas venta_3 = new Ventas(4000, "tercera venta");
		Ventas venta_4 = new Ventas(6000, "cuarta venta");
		Ventas venta_5 = new Ventas(8000, "quinta venta");
		Ventas venta_6 = new Ventas(1000, "sexta venta");

		// SETEAMOS LA LISTA DE PRODUCTOS Y LA PERSONA EN CADA VENTA
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

		// BUSCAMOS UNA PERSONA
		System.out.println("Buscando una persona: ");
		System.out.println("--------------------");
		persona_dao.find(lista_personas.get(0).getPersona_id());

		System.out.println("-----------------");

		// BUSCAMOS UNA VENTA
		System.out.println("Buscando una venta: ");
		System.out.println("----------------");
		ventas_dao.find(venta_2.getVenta_id());

		// BUSCAMOS UN PRODUCTO
		System.out.println("--------------------");
		System.out.println("Buscando un producto");
		Producto pro = producto_dao.find(producto_10.getProducto_id());
		System.out.println("Producto encontrado: ");
		System.out.println("Nombre: " + pro.getNombre());
		System.out.println("Descripcion: " + pro.getDescripcion());
		System.out.println("Precio: " + pro.getPrecio());

		// BORRAMOS UN PRODUCTO
		System.out.println("-----------------");
		System.out.println("Borrando un producto:");
		if (producto_dao.borrar(producto_2)) {
			System.out.println("se borro el producto: " + producto_2.getProducto_id());
		}

		// BORRAMOS UNA VENTA
		System.out.println("------------------");
		System.out.println("Borrando una venta:");
		if ( ventas_dao.borrar(venta_3) ) {
			System.out.println("Se borro la venta: "+venta_3.getVenta_id());
		}
		
		//BORRAMOS UNA PERSONA
		System.out.println("---------------");
		System.out.println("Borrando una persona:");
		if ( persona_dao.borrar(persona_4) ) {
			System.out.println("Se borro la persona: "+persona_4.getPersona_id());
		}
		
		
		//ACUTALIZAMOS UN PRODUCTO
		System.out.println("------------");
		System.out.println("Actualizando un producto");
		producto_5.setNombre("alfajor");
		producto_5.setDescripcion("comida");
		producto_5.setPrecio(100);
		if( producto_dao.actualizar(producto_5) ) {
			System.out.println("producto actualizado");
		}
		
		
		//ACTUALIZAMOS UNA VENTA
		
		// falta buscar persona
		// buscar venta
		// actualizar persona
		// actualizar venta
		
		//la tabla intermedia queda mal porque se borra un producto y la venta queda colgada de ese producto
		//tambien la tabla ventas ya que si se borra una persona queda colgada la venta con esa persona borrada

	}

}

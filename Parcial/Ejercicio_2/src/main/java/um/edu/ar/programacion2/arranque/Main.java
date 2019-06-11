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

		IPersonaDao persona_dao = new PersonaDao(conect);

		// CREAMOS PERSONAS
		Persona persona_1 = new Persona("Fernando", "Isaguirre",39088047L);
		Persona persona_2 = new Persona("David", "Videau",401234567L);
		Persona persona_3 = new Persona("Jeronimo", "Taber",50456879L);
		Persona persona_4 = new Persona("Andres", "Soria",123456789L);
		Persona persona_5 = new Persona("Julian", "Lopez",38948765L);
		Persona persona_6 = new Persona("Leandro", "Herrera",555666777L);

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
		
		System.out.println("---------------");
		// BUSCAMOS UNA PERSONA
		System.out.println("Buscando una persona: ");
		System.out.println("--------------------");
		Persona persona = persona_dao.find(lista_personas.get(0).getPersona_id());
		if(persona!=null) {
			System.out.println("Se encontro una persona:");
			System.out.println("ID:"+persona.getPersona_id());
			System.out.println("Nombre: "+persona.getNombre());
			System.out.println("Apellido: "+persona.getApellido());
			System.out.println("Documento: "+persona.getDocumento());
			System.out.println("Activo: "+persona.getActivo());
		}

		System.out.println("-----------------");

		
		//BORRAMOS UNA PERSONA
		System.out.println("---------------");
		System.out.println("Borrando una persona:");
		if ( persona_dao.borrar(persona_4) ) {
			System.out.println("Se borro la persona con ID: "+persona_4.getPersona_id());
		}
		
		//ACTUALIZANDO UNA PERSONA
		System.out.println("---------------");
		System.out.println("Actualizando una persona");
		persona_2.setNombre("Juan");
		persona_2.setApellido("Lopez");
		persona_2.setDocumento(123456789L);
		persona_2.setActivo(false);
		System.out.println("la persona: "+persona_2.getNombre());
		if ( persona_dao.actualizar(persona_2) ) {
			System.out.println("Se actualizo la persona en la base de datos con ID: "+persona_2.getPersona_id());
		}
		
		
		ArrayList<Persona> list = (ArrayList<Persona>) persona_dao.findAllActivos();
		System.out.println("------------");
		System.out.println("Buscando personas activas");
		System.out.println("------------");
		System.out.println("Personas activas:");
		for(int i=0;i<list.size();i++) {
			System.out.println("Nombre: "+list.get(i).getNombre());
		}
		
		
		System.out.println("------------------");
		System.out.println("Buscando por nombre o apellido");
		ArrayList<Persona> persona_l =  (ArrayList<Persona>) persona_dao.findByNombreOrApellidoLike(persona_1.getNombre());
		
		if(persona_l!=null) {
			System.out.println("Personas encontradas por nombre o apellido:"+persona_1.getNombre());
			for(int i=0;i<persona_l.size();i++) {
				System.out.println("ID: "+persona_l.get(i).getPersona_id());
				System.out.println("Nombre: "+persona_l.get(i).getNombre());
				System.out.println("Apellido: "+persona_l.get(i).getDocumento());
				System.out.println("Documento: "+persona_l.get(i).getDocumento());
				System.out.println("Activo: "+persona_l.get(i).getActivo());
			}
		}
		
		
	}

}

package um.edu.ar.programacion2.interfaces;

import java.util.List;

import um.edu.ar.programacion2.entidades.Persona;

public interface IPersonaDao {

	public void insertar(Persona persona);

	public void actualizar(Persona p);

	public void borrar(Persona p);

	public Persona find(Long id);
	
	public List<Persona> findAll(List<Persona> persona);

}

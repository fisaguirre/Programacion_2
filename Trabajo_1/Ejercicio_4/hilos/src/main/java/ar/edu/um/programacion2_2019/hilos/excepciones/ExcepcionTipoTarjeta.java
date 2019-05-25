package ar.edu.um.programacion2_2019.hilos.excepciones;

public class ExcepcionTipoTarjeta extends Exception{
	
	
	public ExcepcionTipoTarjeta() {
		super();
	}
	
	public String getMessage() {
		String mensaje="";
		
		mensaje="Error, el tipo de tarjeta no es valido";
		
		return mensaje;
	}

}

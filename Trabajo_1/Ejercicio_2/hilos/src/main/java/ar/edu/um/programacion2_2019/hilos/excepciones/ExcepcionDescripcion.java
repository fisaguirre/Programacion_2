package ar.edu.um.programacion2_2019.hilos.excepciones;

public class ExcepcionDescripcion extends Exception{
	
	protected int codigoError;
	
	public ExcepcionDescripcion(int codigoError) {
		super();
		this.codigoError=codigoError;
	}
	
	public String getMessage() {

		String mensaje = "";

		switch (codigoError) {
		case 1:
			mensaje = "Error, la descripcion de la venta no debe ser nula";
			break;
		case 222:
			mensaje = "Error, el numero esta entre 11 y 20";
			break;
		case 333:
			mensaje = "Error, el numero esta entre 21 y 30";
			break;
		}

		return mensaje;

	}

}

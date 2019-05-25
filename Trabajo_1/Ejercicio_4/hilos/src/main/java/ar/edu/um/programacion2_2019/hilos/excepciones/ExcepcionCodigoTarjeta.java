package ar.edu.um.programacion2_2019.hilos.excepciones;

import java.util.UUID;

import ar.edu.um.programacion2_2019.hilos.servicio.ILogeador;

public class ExcepcionCodigoTarjeta extends Exception {

	protected int codigoError;
	protected ILogeador log;
	protected UUID sesion;

	public ExcepcionCodigoTarjeta(int codigoError) {
		super();
		this.codigoError = codigoError;
		
	}

	@Override
	public String getMessage() {

		String mensaje = "";

		switch (codigoError) {
		case 1:
			mensaje = "Error, la cantidad de digitos del codigo de la tarjeta son diferentes a 3/4";
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
	
	public void getError(UUID sesion, ILogeador log) {
		String mensaje="Error, la cantidad de digitos esta mal";
		log.bloqueError(sesion, mensaje);
		
	}

}

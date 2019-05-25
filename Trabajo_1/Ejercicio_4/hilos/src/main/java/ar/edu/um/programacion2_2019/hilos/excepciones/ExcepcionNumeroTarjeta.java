package ar.edu.um.programacion2_2019.hilos.excepciones;

public class ExcepcionNumeroTarjeta extends Exception {

	protected int codigoError;

	public ExcepcionNumeroTarjeta(int codigoError) {
		super();
		this.codigoError = codigoError;
	}

	@Override
	public String getMessage() {

		String mensaje = "";

		switch (codigoError) {
		case 1:
			mensaje = "Error, la cantidad de digitos de la tarjeta son diferentes a 15/16";
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

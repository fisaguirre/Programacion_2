package Exception;

public class VentaAPersonaDesactivadaException extends Exception {

	protected int codigoError;

	public VentaAPersonaDesactivadaException(int codigoError) {
		super();
		this.codigoError = codigoError;

	}

	public String getMessage() {

		String mensaje = "";

		switch (codigoError) {
		case 1:
			mensaje = "Error, la persona no esta activa";
			break;
		case 333:
			mensaje = "Error, el numero esta entre 21 y 30";
			break;
		}

		return mensaje;

	}

}

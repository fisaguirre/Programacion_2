package ar.edu.um.programacion2_2019.hilos.servicio;

import ar.edu.um.programacion2_2019.hilos.entidades.Venta;
import ar.edu.um.programacion2_2019.hilos.excepciones.ExcepcionTipoTarjeta;

public class ProcesadorFactory {
	public static IProcesador getProcesador(Venta venta, ILogeador log) {
		try {
			if (venta.getTarjeta().getTipo().equals("VISA")) {
				return new VisaProcesador(venta, log);
			}
			if (venta.getTarjeta().getTipo().equals("MC")) {
				return new MasterCardProcesador(venta, log);
			}
			else {
				throw new ExcepcionTipoTarjeta();
			}

		} catch (ExcepcionTipoTarjeta e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		/*
		if (venta.getTarjeta().getTipo().equals("VISA")) {
			return new VisaProcesador(venta, log);
		}
		if (venta.getTarjeta().getTipo().equals("MC")) {
			return new MasterCardProcesador(venta, log);
		}*/
		return null;
	}
}

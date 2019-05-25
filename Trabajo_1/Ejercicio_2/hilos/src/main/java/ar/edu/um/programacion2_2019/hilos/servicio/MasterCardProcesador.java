package ar.edu.um.programacion2_2019.hilos.servicio;

import ar.edu.um.programacion2_2019.hilos.entidades.Venta;
import ar.edu.um.programacion2_2019.hilos.excepciones.ExcepcionCodigoTarjeta;
import ar.edu.um.programacion2_2019.hilos.excepciones.ExcepcionDescripcion;
import ar.edu.um.programacion2_2019.hilos.excepciones.ExcepcionMonto;
import ar.edu.um.programacion2_2019.hilos.excepciones.ExcepcionNombre;
import ar.edu.um.programacion2_2019.hilos.excepciones.ExcepcionNumeroTarjeta;

import java.util.UUID;

public class MasterCardProcesador implements IProcesador{
    protected Venta venta;
    protected ILogeador log;
    protected UUID sesion;

    public MasterCardProcesador() {}

    public MasterCardProcesador(Venta venta, ILogeador log) {
        this.venta = venta;
        this.log = log;
        this.sesion = log.crearSesion();
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public boolean verificarTarjeta() {
        boolean retorno = true;
        this.log.bloqueInfo(this.sesion, "Arrancando el proceso de verificar la tarjeta de credito MC");
        
        try {
			if (this.venta.getTarjeta().getNumeroTarjeta().length() != 15
					&& this.venta.getTarjeta().getNumeroTarjeta().length() != 16) {
				retorno = false;
				throw new ExcepcionNumeroTarjeta(1);
			}

			if (this.venta.getTarjeta().getCodigoTarjeta().length() != 3
					&& this.venta.getTarjeta().getCodigoTarjeta().length() != 4) {
				retorno = false;
				throw new ExcepcionCodigoTarjeta(1);
			}

			this.log.bloqueInfo(this.sesion, "Verificando tarjeta: "+this.venta.getTarjeta().getCCEnmascarada());
	        int numError = (int)(Math.random()*10);
	        if(numError==1) {
	            this.log.bloqueError(this.sesion, "Hubo un error en la verificación de la tarjeta MC");
	            this.log.bloqueInfo(this.sesion, "Finalizando proceso de venta");
	            this.log.publicarSesion(this.sesion);
	            retorno = false;
	        }
	        this.log.bloqueInfo(this.sesion, "Finalizada la verificación de la tarjeta MC");

		} catch (ExcepcionNumeroTarjeta e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionCodigoTarjeta e) {
			System.out.println(e.getMessage());
		}
        /*
        this.log.bloqueInfo(this.sesion, "Verificando tarjeta: "+this.venta.getTarjeta().getCCEnmascarada());
        int numError = (int)(Math.random()*10);
        if(numError==1) {
            this.log.bloqueError(this.sesion, "Hubo un error en la verificación de la tarjeta MC");
            this.log.bloqueInfo(this.sesion, "Finalizando proceso de venta");
            this.log.publicarSesion(this.sesion);
            retorno = false;
        }
        this.log.bloqueInfo(this.sesion, "Finalizada la verificación de la tarjeta MC");
        */
        return retorno;
    }

    public boolean autorizar() {
        boolean retorno = true;
        this.log.bloqueInfo(this.sesion, "Arrancando el proceso de autorizar la transacción MC");
        try {
			if (this.venta.getMonto() < 1) {
				retorno = false;
				throw new ExcepcionMonto(1);
			}
			if (this.venta.getTarjeta().getPersona().length() < 6) {
				retorno = false;
				throw new ExcepcionNombre(1);
			}
			if (this.venta.getDescripcion().isEmpty()) {
				retorno = false;
				throw new ExcepcionDescripcion(1);
			}

			this.log.bloqueInfo(this.sesion, "Verificando monto: "+this.venta.getMonto());
	        int numError = (int)(Math.random()*10);
	        if(numError==1) {
	            this.log.bloqueError(this.sesion, "Hubo un error en la autorización de la tarjeta MC");
	            this.log.bloqueInfo(this.sesion, "Finalizando proceso de venta");
	            this.log.publicarSesion(this.sesion);
	            retorno = false;
	        }
	        this.log.bloqueInfo(this.sesion, "Finalizado el proceso de autorización de la tarjeta MC");
	        
		} catch (ExcepcionMonto e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionNombre e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionDescripcion e) {
			System.out.println(e.getMessage());
		}
        /*
        
        this.log.bloqueInfo(this.sesion, "Verificando monto: "+this.venta.getMonto());
        int numError = (int)(Math.random()*10);
        if(numError==1) {
            this.log.bloqueError(this.sesion, "Hubo un error en la autorización de la tarjeta MC");
            this.log.bloqueInfo(this.sesion, "Finalizando proceso de venta");
            this.log.publicarSesion(this.sesion);
            retorno = false;
        }
        this.log.bloqueInfo(this.sesion, "Finalizado el proceso de autorización de la tarjeta MC");
        */
        return retorno;
    }

    public boolean capturar() {
        this.log.bloqueInfo(this.sesion, "Procesada la captura de la tarjeta MC");
        return true;
    }

    public boolean finalizar() {
        this.log.bloqueInfo(this.sesion, "Finalizado el proceso de venta de la tarjeta MC");
        this.log.publicarSesion(this.sesion);
        return true;
    }
}

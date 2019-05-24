package ar.edu.um.programacion2_2019.hilos.servicio;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import ar.edu.um.programacion2_2019.hilos.entidades.Venta;

public class ProcesarVenta implements Callable<Boolean>{
    protected AlmacenVentas almacen;
    protected ILogeador log;
    protected Venta venta;
    
    public ProcesarVenta() {}

    public ProcesarVenta(AlmacenVentas almacen, ILogeador log, Venta venta) {
        this.almacen = almacen;
        this.log = log;
        this.venta=venta;
    }

   
    
    public Boolean call() throws InterruptedException {
        IProcesador procesador;
        boolean verificarT = false;
        boolean autorizar = false;
        this.log.info("Se comienza a procesar todo");
    	
        		procesador = ProcesadorFactory.getProcesador(venta,this.log);
        		Thread.sleep(1000);

            	verificarT = procesador.verificarTarjeta();
            	Thread.sleep(1000);
            	if (verificarT) {
            		autorizar=procesador.autorizar();
            		Thread.sleep(1000);
            	}
            	if(verificarT && autorizar) {
                	procesador.capturar();
                	Thread.sleep(1000);
                	procesador.finalizar();
                	Thread.sleep(1000);
        }
        this.log.info("Finaliza el procesamiento");
        return true;
    }

    public AlmacenVentas getAlmacen() {
        return almacen;
    }

    public void setAlmacen(AlmacenVentas almacen) {
        this.almacen = almacen;
    }

    public ILogeador getLog() {
        return log;
    }

    public void setLog(ILogeador log) {
        this.log = log;
    }

	
}

package ar.edu.um.programacion2_2019.hilos.servicio;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ar.edu.um.programacion2_2019.hilos.entidades.Venta;

public class HiloProcesar implements Runnable {

	protected ILogeador log;
    AlmacenVentas almacen;

    
	public HiloProcesar(ILogeador log,AlmacenVentas almacen) {
		super();
        this.log = log;
        this.almacen = almacen;

        
	}
	public void ProcesarHilo(ExecutorService exs) {
		ExecutorService es = Executors.newFixedThreadPool(99);
        //outerloop:
		HiloImportarVenta hiventa = new HiloImportarVenta();
		System.out.println("hola");
		
        while(!almacen.estaVacio() || !exs.isTerminated()) {
        	System.out.println("nuevos hilos");
       		 if(!almacen.estaVacio()) {
        		Venta venta = almacen.pop();
                ProcesarVenta procesar = new ProcesarVenta(almacen,log,venta);
                es.submit(procesar);
       		 }
            }
            
            //es.shutdown();
        //this.log.info("Finaliza el procesamiento de todo");
    
		
	}
	public void run() {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}

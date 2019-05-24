package ar.edu.um.programacion2_2019.hilos.servicio;

import ar.edu.um.programacion2_2019.hilos.entidades.Venta;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class AlmacenVentas {
    protected BlockingQueue<Venta> cola;
    //<Venta> es el tipo de elemento contenido en la blockingqueue(una cola), que en este caso es
    //de tipo Venta
    protected ILogeador log;
    public Boolean vacio=false;

    public AlmacenVentas() {
        this.cola = new LinkedBlockingQueue<Venta>();
    }

    public AlmacenVentas(ILogeador log) {
        this.log = log;
        this.cola = new LinkedBlockingQueue<Venta>();
    }

    public void push(Venta venta) {
        try {
            this.cola.put(venta);
            this.log.info("Almacenada venta: "+venta);
            System.out.println("\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Venta pop() {
        Venta retorno = null;
        try {
            retorno=this.cola.take();
            this.log.info("Recuperada venta: "+retorno);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public boolean estaVacio() {
        if(this.cola.isEmpty()) {
            return true;
        }
        return false;
    }
    
    public void ponerFinalAlmacen() {
    	this.vacio=true;
    	System.out.println("no hay mas importaciones");
    }
    
    public boolean verificarFinalAlmacen() {
		if(this.vacio) {
			System.out.println("vacio true es: "+this.vacio);
			return true;
		}
		System.out.println("vacio es: "+this.vacio);
		return false;
    }

    public ILogeador getLog() {
        return log;
    }

    public void setLog(ILogeador log) {
        this.log = log;
    }
}

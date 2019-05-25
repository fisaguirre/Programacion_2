package ar.edu.um.programacion2_2019.hilos.servicio;

import ar.edu.um.programacion2_2019.hilos.entidades.TarjetaCredito;
import ar.edu.um.programacion2_2019.hilos.entidades.Venta;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class ImportarVenta implements Callable<Boolean> {

	protected String archivo;
	protected ILogeador log;
	protected AlmacenVentas almacen;
	protected String linea;

	public ImportarVenta() {
	}
	
	public ImportarVenta(String linea, ILogeador log, AlmacenVentas almacen) {
		this.linea = linea;
		this.log = log;
		this.almacen=almacen;
	}

	public Boolean call() throws InterruptedException {
		//Thread.sleep(4000);
		log.info("Recuperado del archivo: "+linea);
        String[] datos = linea.split(";");
        TarjetaCredito tarjeta = new TarjetaCredito(datos[0],datos[1],datos[2],datos[3]);
        Venta venta = new Venta(datos[4], Float.valueOf(datos[5]), tarjeta);
        almacen.push(venta);
        
		return true;
		
		
	}
	
	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public ILogeador getLog() {
		return log;
	}

	public void setLog(ILogeador log) {
		this.log = log;
	}


}

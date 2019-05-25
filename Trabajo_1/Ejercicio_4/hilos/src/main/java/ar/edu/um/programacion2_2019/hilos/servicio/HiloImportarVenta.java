package ar.edu.um.programacion2_2019.hilos.servicio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HiloImportarVenta implements Callable<Boolean>{
	
	protected String archivo;
	protected ILogeador log;
	protected AlmacenVentas almacen;
    static ExecutorService es;
    static Boolean fin;
    //static Boolean shutHilos=false;
    
    public HiloImportarVenta() {
    	
    }

	
	
	public HiloImportarVenta(String archivo, ILogeador log, AlmacenVentas almacen) {
		this.archivo = archivo;
		this.log = log;
		this.almacen=almacen;
		fin=false;
	}

	public Boolean call() throws IOException {
		return true;
	}
	
	public void ImportarHilo() throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new FileReader(this.archivo));
        String linea;
        es = Executors.newFixedThreadPool(99);
        while ((linea = br.readLine()) != null) {
        	
        	ImportarVenta iv = new ImportarVenta(linea,log,almacen);
        	es.submit(iv);
        }
        //this.shutHilos=true;
        
        es.shutdown();
        
	}
	
	public static Boolean finArchivo() {
        if(fin == true) {
            return true;
        }
        return false;
    }
	public ExecutorService setExecutor() {
		System.out.println("se retorna exe");
    	return es;
    }
	/*
	public Boolean verificarShutHilos() {
		if(shutHilos == true) {
			System.out.println("se cumple");
			return true;
		}
		System.out.println("no se cumple");
		return false;
	}
	*/

}

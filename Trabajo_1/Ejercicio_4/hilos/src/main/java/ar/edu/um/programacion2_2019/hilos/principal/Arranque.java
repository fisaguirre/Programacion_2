package ar.edu.um.programacion2_2019.hilos.principal;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ar.edu.um.programacion2_2019.hilos.servicio.*;

public class Arranque {
	public static void main(String[] args) throws InterruptedException, IOException {
		Arranque a = new Arranque();
		a.arrancar();
	}

	public void arrancar() throws InterruptedException, IOException {
		ExecutorService exeservice = Executors.newFixedThreadPool(1);
		ILogeador log = new LogeadorConsola();
		// ILogeador log = new LogeadorArchivo("/Users/Villano/Desktop/ventas.log");
		log.info("Arrancó la aplicación\n");
		AlmacenVentas almacen = new AlmacenVentas(log);
		String archivo = "almacen.txt";
		HiloImportarVenta hiv = new HiloImportarVenta(archivo, log, almacen);
		hiv.ImportarHilo();

		ExecutorService exs = hiv.setExecutor();
		HiloProcesar hp = new HiloProcesar(log, almacen);
		hp.ProcesarHilo(exs);
		exs.shutdown();
		log.info("Terminó la aplicación");
	}

}

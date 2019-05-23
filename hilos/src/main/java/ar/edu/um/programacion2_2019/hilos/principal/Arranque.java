package ar.edu.um.programacion2_2019.hilos.principal;

import ar.edu.um.programacion2_2019.hilos.servicio.*;

public class Arranque {
    public static void main(String[] args) {
        Arranque a = new Arranque();
        a.arrancar();
    }

    public void arrancar() {
        ILogeador log = new LogeadorConsola();
        //ILogeador log = new LogeadorArchivo("/Users/Villano/Desktop/ventas.log");
        log.info("Arrancó la aplicación\n");
        AlmacenVentas almacen = new AlmacenVentas(log);
        //String datos = "/Users/Villano/Desktop/ventas1.txt";
        String datos = "almacen.txt";
        ImportarVenta imp = new ImportarVenta(datos,log);
        imp.importarVentas(almacen);
        ProcesarVenta procesar = new ProcesarVenta(almacen,log);
        procesar.procesarTodo();
        log.info("Terminó la aplicación");
    }

}

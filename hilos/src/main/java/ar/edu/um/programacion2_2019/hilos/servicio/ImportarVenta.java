package ar.edu.um.programacion2_2019.hilos.servicio;

import ar.edu.um.programacion2_2019.hilos.entidades.TarjetaCredito;
import ar.edu.um.programacion2_2019.hilos.entidades.Venta;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ImportarVenta {

    protected String archivo;
    protected ILogeador log;

    public ImportarVenta() {}

    public ImportarVenta(String archivo, ILogeador log) {
        this.archivo = archivo;
        this.log = log;
    }

    public void importarVentas(AlmacenVentas almacen) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                log.info("Recuperado del archivo: "+linea);
                String[] datos = linea.split(";");
                TarjetaCredito tarjeta = new TarjetaCredito(datos[0],datos[1],datos[2],datos[3]);
                Venta venta = new Venta(datos[4], Float.valueOf(datos[5]), tarjeta);
                almacen.push(venta);
            }
            System.out.println("\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

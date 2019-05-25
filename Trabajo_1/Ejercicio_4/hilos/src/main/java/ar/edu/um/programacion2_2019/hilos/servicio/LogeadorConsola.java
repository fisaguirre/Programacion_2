package ar.edu.um.programacion2_2019.hilos.servicio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LogeadorConsola implements ILogeador{

    protected Map<UUID,StringBuilder> sesiones;
    //map es una interfaz
    public LogeadorConsola() {
        this.sesiones = new HashMap<UUID, StringBuilder>();
        //solo crea el mapa vacio
    }

    public void info(String mensaje) {
        System.out.println(this.getFechaAhora()+" - INFO - " + mensaje);
    }

    public void error(String mensaje) {
        System.out.println(this.getFechaAhora()+" - ERROR - " + mensaje);
    }

    public UUID crearSesion() {
        StringBuilder sb = new StringBuilder();
        UUID sesion = UUID.randomUUID();
        //randomUUID() lanza un numero aleatorio criptografico
        //System.out.println("el numero es: "+sesion);
        this.sesiones.put(sesion, sb);
        //en el atributo sesiones se guarda la parte clave con un numero aleatorio y la parte del valor
        //que es de tipo StringBuilder( pero esta parte esta vacia)
        return sesion;
    }

    public void bloqueInfo(UUID sesion, String mensaje) {
        StringBuilder sb = this.sesiones.get(sesion);
        //en la variable sb que hace referencia al objeto de sesiones se obtiene la parte clave de la sesion
        sb.append(this.getFechaAhora()+" - INFO - "+mensaje+"\n");
        //al final de sb se agrega lo que esta entre parentesis
        //supongo que se agrega como la parte valor de la clave que obtuvimos antes
    }

    public void bloqueError(UUID sesion, String mensaje) {
    	System.out.println("es el bloque error");
        StringBuilder sb = this.sesiones.get(sesion);
        sb.append(this.getFechaAhora()+" - ERROR - "+mensaje+"\n");
        System.out.println();

    }

    public void publicarSesion(UUID sesion) {
        StringBuilder sb = this.sesiones.get(sesion);
        System.out.println(sb.toString());
        //this.sesiones.remove(sesion);
        //comente esto porque sino sale la excepcion porque en la otra clase quiero agarrar la sesion...
        //...y no esta, por eso me da error
    }

    private String getFechaAhora() {
        String patron = "YYYY-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(patron);
        String fecha = sdf.format(new Date());
        return fecha;
    }
}

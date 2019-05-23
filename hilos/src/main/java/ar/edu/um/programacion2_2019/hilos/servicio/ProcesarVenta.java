package ar.edu.um.programacion2_2019.hilos.servicio;

import ar.edu.um.programacion2_2019.hilos.entidades.Venta;

public class ProcesarVenta {
    protected AlmacenVentas almacen;
    protected ILogeador log;

    public ProcesarVenta() {}

    public ProcesarVenta(AlmacenVentas almacen, ILogeador log) {
        this.almacen = almacen;
        this.log = log;
    }

    public void procesarTodo() {
        IProcesador procesador;
        boolean verificarT = false;
        boolean autorizar = false;
        this.log.info("Se comienza a procesar todo\n");
        while(!almacen.estaVacio()) {
            Venta venta = almacen.pop();
            procesador = ProcesadorFactory.getProcesador(venta,this.log);
            verificarT = procesador.verificarTarjeta();
            if (verificarT) {
                autorizar=procesador.autorizar();
            }
            if(verificarT && autorizar) {
                procesador.capturar();
                procesador.finalizar();
            }
        }
        this.log.info("Finaliza el procesamiento de todo");
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

package ar.edu.ubp.das.ejemplo11.refact;

public class EmpleadoTiempoCompleto  extends Empleado {

    public EmpleadoTiempoCompleto(String nombre) {
        super(nombre, new PagoTiempoCompleto());
    }

}

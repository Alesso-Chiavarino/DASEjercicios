package ar.edu.ubp.das.ejemplo11.refact;

public class EmpleadoTiempoParcial extends Empleado {

    public EmpleadoTiempoParcial(String nombre) {
        super(nombre, new PagoTiempoParcial());
    }

}

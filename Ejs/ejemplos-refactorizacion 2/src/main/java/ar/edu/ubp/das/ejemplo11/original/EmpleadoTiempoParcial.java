package ar.edu.ubp.das.ejemplo11.original;

public class EmpleadoTiempoParcial extends Empleado {

    public EmpleadoTiempoParcial(String nombre) {
        super(nombre);
    }

    @Override
    public double calcularPago() {
        return 1500;
    }

}
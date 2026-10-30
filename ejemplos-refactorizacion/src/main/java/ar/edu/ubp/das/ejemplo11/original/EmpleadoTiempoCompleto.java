package ar.edu.ubp.das.ejemplo11.original;

public class EmpleadoTiempoCompleto extends Empleado {

    public EmpleadoTiempoCompleto(String nombre) {
        super(nombre);
    }

    @Override
    public double calcularPago() {
        return 3000;
    }

}


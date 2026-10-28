package ar.edu.ubp.das.ej2.ref;

public class EmpleadoEfectivo extends Empleado {

    private double salarioBase;

    public EmpleadoEfectivo(String nombre, double salarioBase) {
        super(nombre);
        this.salarioBase = salarioBase;
    }

    @Override
    public double calcularPago() {
        return salarioBase;
    }

}

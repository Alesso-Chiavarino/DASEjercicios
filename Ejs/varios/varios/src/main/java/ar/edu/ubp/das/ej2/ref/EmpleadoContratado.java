package ar.edu.ubp.das.ej2.ref;

public class EmpleadoContratado extends Empleado {

    private double horasTrabajadas;
    private double tarifaPorHora;

    public EmpleadoContratado(String nombre, double horasTrabajadas, double tarifaPorHora) {
        super(nombre);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    public double calcularPago() {
        return horasTrabajadas * tarifaPorHora;
    }

}

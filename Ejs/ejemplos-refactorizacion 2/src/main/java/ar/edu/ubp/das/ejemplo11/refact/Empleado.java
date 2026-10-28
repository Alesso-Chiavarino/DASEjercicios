package ar.edu.ubp.das.ejemplo11.refact;

public class Empleado {

    private String nombre;
    private EstrategiaPago estrategiaPago;

    public Empleado(String nombre, EstrategiaPago estrategiaPago) {
        this.nombre = nombre;
        this.estrategiaPago = estrategiaPago;
    }

    public String getNombre() {
        return nombre;
    }

    public double calcularPago() {
        return estrategiaPago.calcular();
    }

}

package ar.edu.ubp.das.ej2.ref;

public abstract class Empleado {

    private String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double calcularPago();

}

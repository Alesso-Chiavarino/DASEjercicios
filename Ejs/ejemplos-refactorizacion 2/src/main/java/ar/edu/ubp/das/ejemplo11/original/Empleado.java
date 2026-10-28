package ar.edu.ubp.das.ejemplo11.original;

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

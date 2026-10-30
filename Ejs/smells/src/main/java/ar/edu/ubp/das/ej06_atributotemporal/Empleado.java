package ar.edu.ubp.das.ej06_atributotemporal;

public class Empleado {

    private String nombre;
    private double sueldoBasico;

    public Empleado(String nombre, double sueldoBasico) {
        this.nombre = nombre;
        this.sueldoBasico = sueldoBasico;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

}

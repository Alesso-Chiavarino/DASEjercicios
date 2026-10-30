package ar.edu.ubp.das.ejemplo03.refact;

public class Empleado {

    private String nombre;
    private double salarioBase;
    private double bonificacion;

    public Empleado(String nombre, double salarioBase, double bonificacion) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.bonificacion = bonificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public double calcularSalarioTotal() {
        return salarioBase + bonificacion;
    }

}

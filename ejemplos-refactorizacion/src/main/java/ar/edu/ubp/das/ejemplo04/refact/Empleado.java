package ar.edu.ubp.das.ejemplo04.refact;

public class Empleado {

    private String nombre;
    private double salario;
    private int añosTrabajados;

    public Empleado(String nombre, double salario, int añosTrabajados) {
        this.nombre = nombre;
        this.salario = salario;
        this.añosTrabajados = añosTrabajados;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public int getAñosTrabajados() {
        return añosTrabajados;
    }

}

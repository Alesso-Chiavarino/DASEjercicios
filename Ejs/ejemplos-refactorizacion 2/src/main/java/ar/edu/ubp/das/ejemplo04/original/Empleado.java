package ar.edu.ubp.das.ejemplo04.original;

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

    public double calcularBonificacion() {
        return salario * 0.05 * añosTrabajados;
    }

    public int calcularDiasVacaciones() {
        return añosTrabajados * 2;
    }

    public void registrarAumento(double nuevoSalario) {
        System.out.println("Empleado " + nombre + " ha recibido un aumento. Nuevo salario: " + nuevoSalario);
    }

}


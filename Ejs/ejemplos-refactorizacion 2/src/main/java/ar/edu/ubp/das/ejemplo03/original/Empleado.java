package ar.edu.ubp.das.ejemplo03.original;

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

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getBonificacion() {
        return bonificacion;
    }

    public double calcularSalarioTotal() {
        return salarioBase + bonificacion;
    }

    public String generarInforme() {
        return "Empleado: " + nombre + "\nSalario Total: " + calcularSalarioTotal();
    }

    public void guardarEmpleado() {
        System.out.println("Guardando empleado en la base de datos...");
        // Conectar a la base de datos y guardar el empleado.
    }

}


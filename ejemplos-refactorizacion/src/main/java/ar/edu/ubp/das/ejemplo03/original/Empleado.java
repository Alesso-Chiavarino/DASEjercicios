package ar.edu.ubp.das.ejemplo03.original;

// SMELL: Divergent Change — Empleado cambia por 3 motivos distintos (negocio, presentación y persistencia).
// Refactor sugerida: Extract Class (separar en Empleado, EmpleadoReporteGenerator y EmpleadoRepository).
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

    // Responsabilidad 1: lógica de negocio (cálculo de salario).
    public double calcularSalarioTotal() {
        return salarioBase + bonificacion;
    }

    // Responsabilidad 2: presentación / formateo del informe. No es responsabilidad del Empleado.
    public String generarInforme() {
        return "Empleado: " + nombre + "\nSalario Total: " + calcularSalarioTotal();
    }

    // Responsabilidad 3: persistencia. No es responsabilidad del Empleado.
    public void guardarEmpleado() {
        System.out.println("Guardando empleado en la base de datos...");
        // Conectar a la base de datos y guardar el empleado.
    }

}


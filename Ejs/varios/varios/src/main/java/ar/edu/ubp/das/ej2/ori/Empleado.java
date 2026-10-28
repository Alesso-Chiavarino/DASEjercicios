package ar.edu.ubp.das.ej2.ori;

class Empleado {

    private String nombre;
    private String tipo;
    private double salarioBase;
    private double horasTrabajadas;
    private double tarifaPorHora;

    public Empleado(String nombre, String tipo, double salarioBase) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.salarioBase = salarioBase;
        this.horasTrabajadas = 0;
        this.tarifaPorHora = 0;
    }

    public Empleado(String nombre, String tipo, double horasTrabajadas, double tarifaPorHora) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
        this.salarioBase = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public double calcularPago() {
        if (tipo.equals("Efectivo")) {
            return salarioBase;
        } else if (tipo.equals("Contratado")) {
            return horasTrabajadas * tarifaPorHora;
        } else {
            throw new IllegalArgumentException("Tipo de empleado desconocido");
        }
    }

}

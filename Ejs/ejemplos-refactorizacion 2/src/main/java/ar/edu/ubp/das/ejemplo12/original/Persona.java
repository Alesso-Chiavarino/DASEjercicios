package ar.edu.ubp.das.ejemplo12.original;

public class Persona {

    private String nombre;
    private int edad;
    private double salario;

    public Persona(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }

    public void describir() {
        System.out.println(nombre + " tiene " + edad + " años y con salario $" + salario);
    }

}


package ar.edu.ubp.das.ejemplo12.original;

// SMELL: Refused Bequest — Alumno hereda 'salario' pero no le corresponde (se pasa 0 en el constructor).
// Refactor sugerida: Push Down Field/Method (mover 'salario' a Empleado).
public class Persona {

    private String nombre;
    private int edad;
    // SMELL: Refused Bequest — este campo no aplica a todas las subclases (Alumno no lo usa).
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


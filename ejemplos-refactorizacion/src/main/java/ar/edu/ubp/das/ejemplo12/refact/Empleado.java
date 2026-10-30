package ar.edu.ubp.das.ejemplo12.refact;

public class Empleado extends Persona {

    private double salario;

    public Empleado(String nombre, int edad, double salario) {
        super(nombre, edad);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public void describir() {
        System.out.println(getNombre() + " tiene " + getEdad() + " años y es un empleado que gana $" + salario + " al mes.");
    }
}

package ar.edu.ubp.das.ejemplo12.original;

public class Empleado extends Persona {

    public Empleado(String nombre, int edad, double salario) {
        super(nombre, edad, salario);
    }

    @Override
    public void describir() {
        System.out.println(getNombre() + " tiene " + getEdad() + " años y es un empleado que gana $" + getSalario() + " al mes.");
    }

}


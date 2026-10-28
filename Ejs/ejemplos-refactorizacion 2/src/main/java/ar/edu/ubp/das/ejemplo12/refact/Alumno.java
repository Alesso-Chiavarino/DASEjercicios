package ar.edu.ubp.das.ejemplo12.refact;

public class Alumno extends Persona {

    public Alumno(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void describir() {
        System.out.println(getNombre() + " tiene " + getEdad() + " años y es un estudiante.");
    }

}


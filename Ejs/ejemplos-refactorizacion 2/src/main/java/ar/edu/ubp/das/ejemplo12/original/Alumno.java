package ar.edu.ubp.das.ejemplo12.original;

public class Alumno extends Persona {

    public Alumno(String nombre, int edad) {
        super(nombre, edad, 0);
    }

    @Override
    public void describir() {
        System.out.println(getNombre() + " tiene " + getEdad() + " años y es un estudiante.");
    }

}


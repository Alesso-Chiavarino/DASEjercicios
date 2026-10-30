package ar.edu.ubp.das.ejemplo12.refact;

public class Persona {

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void describir() {
        System.out.println(nombre + " tiene " + edad + " años.");
    }
}

package ar.edu.ubp.das.ej17_clasegrande;

public class Alumno {

    private String nombre;
    private String dni;
    private String email;

    public Alumno(String nombre, String dni, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

}

package ar.edu.ubp.das.ejemplo06.original;

public class Cliente {

    private String nombre;
    private String email;
    private int antiguedad;

    public Cliente(String nombre, String email, int antiguedad) {
        this.nombre = nombre;
        this.email = email;
        this.antiguedad = antiguedad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

}

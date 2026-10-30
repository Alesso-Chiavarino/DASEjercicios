package ar.edu.ubp.das.ej08_intermediario.resolucion;

public class Profesor {

    private String nombre;
    private String email;
    private int horasSemanales;

    public Profesor(String nombre, String email, int horasSemanales) {
        this.nombre = nombre;
        this.email = email;
        this.horasSemanales = horasSemanales;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

}

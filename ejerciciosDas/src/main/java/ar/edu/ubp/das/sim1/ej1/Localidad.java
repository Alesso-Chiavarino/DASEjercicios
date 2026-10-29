package ar.edu.ubp.das.sim1.ej1;

public class Localidad {

    private String nombre;
    private String provincia;

    public Localidad(String nombre, String provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProvincia() {
        return provincia;
    }

}

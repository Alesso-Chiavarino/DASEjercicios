package ar.edu.ubp.das.sim4.ej2;

public class Contacto {

    private String nombre;
    private String email;
    private String telefono;
    private String canalPreferido;

    public Contacto(String nombre, String email, String telefono, String canalPreferido) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.canalPreferido = canalPreferido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCanalPreferido() {
        return canalPreferido;
    }

}

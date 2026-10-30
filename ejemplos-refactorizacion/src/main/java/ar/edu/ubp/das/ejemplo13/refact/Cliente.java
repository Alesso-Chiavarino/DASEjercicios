package ar.edu.ubp.das.ejemplo13.refact;

public class Cliente {

    private String nombre;
    private String email;
    private String direccionEntrega;
    private String ciudadEntrega;
    private String codigoPostalEntrega;

    public Cliente(String nombre, String email, String direccionEntrega, String ciudadEntrega, String codigoPostalEntrega) {
        this.nombre = nombre;
        this.email = email;
        this.direccionEntrega = direccionEntrega;
        this.ciudadEntrega = ciudadEntrega;
        this.codigoPostalEntrega = codigoPostalEntrega;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public String getCiudadEntrega() {
        return ciudadEntrega;
    }

    public String getCodigoPostalEntrega() {
        return codigoPostalEntrega;
    }

}


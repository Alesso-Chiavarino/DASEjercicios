package ar.edu.ubp.das.ej04_gruposdedatos;

public class Deposito {

    private String nombre;
    private String calle;
    private int numero;
    private String ciudad;
    private String codigoPostal;

    public Deposito(String nombre, String calle, int numero, String ciudad, String codigoPostal) {
        this.nombre = nombre;
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

}

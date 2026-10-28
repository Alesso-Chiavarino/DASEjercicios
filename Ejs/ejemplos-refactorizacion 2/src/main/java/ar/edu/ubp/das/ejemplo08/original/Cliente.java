package ar.edu.ubp.das.ejemplo08.original;

public class Cliente {

    private String nombre;
    private String email;

    private String calle;
    private String nroCalle;
    private String ciudad;
    private String codigoPostal;
    private String pais;

    public Cliente(String nombre, String email, String calle, String nroCalle, String ciudad, String codigoPostal, String pais) {
        this.nombre = nombre;
        this.email = email;
        this.calle = calle;
        this.nroCalle = nroCalle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
    }

    public void actualizarDireccion(String nuevaCalle, String nuevoNroCalle, String nuevaCiudad, String nuevoCodigoPostal, String nuevoPais) {
        this.calle = nuevaCalle;
        this.nroCalle = nuevoNroCalle;
        this.ciudad = nuevaCiudad;
        this.codigoPostal = nuevoCodigoPostal;
        this.pais = nuevoPais;
    }

    public void mostrarInformacion() {
        System.out.println("Cliente: " + nombre);
        System.out.println("Correo: " + email);
        System.out.println("Dirección: " + calle + " "  + nroCalle + ", " + ciudad + ", " + codigoPostal + ", " + pais);
    }

}

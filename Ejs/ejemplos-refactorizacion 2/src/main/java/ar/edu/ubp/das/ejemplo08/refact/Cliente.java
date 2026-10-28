package ar.edu.ubp.das.ejemplo08.refact;

public class Cliente {

    private String nombre;
    private String email;
    private Direccion direccion;

    public Cliente(String nombre, String email, Direccion direccion) {
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
    }

    public void actualizarDireccion(Direccion nuevaDireccion) {
        this.direccion = nuevaDireccion;
    }

    public void mostrarInformacion() {
        System.out.println("Cliente: " + nombre);
        System.out.println("Correo: " + email);
        System.out.println("Dirección: " + direccion.mostrarDireccion());
    }

}


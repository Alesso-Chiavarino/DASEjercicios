package ar.edu.ubp.das.ejemplo14.refact;

public class Persona {

    private String nombre;
    private String apellido;
    private Telefono telefono;
    private Direccion direccion;

    public Persona(String nombre, String apellido, Telefono telefono, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Teléfono: " + telefono.getNumero());
        System.out.println("Dirección: " + direccion.mostrarDireccion());
    }

}


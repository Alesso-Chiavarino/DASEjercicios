package ar.edu.ubp.das.ejemplo14.original;

public class Persona {

    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;

    public Persona(String nombre, String apellido, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public boolean validarTelefono() {
        return telefono.matches("\\d{3}-\\d{3}-\\d{4}");
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Dirección: " + direccion);
    }

}


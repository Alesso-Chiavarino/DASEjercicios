package ar.edu.ubp.das.ejemplo14.original;

// SMELL: Primitive Obsession — teléfono y dirección se modelan como String pese a tener reglas propias.
// La lógica de validación (validarTelefono) vive en Persona en lugar de en un tipo Telefono.
// Refactor sugerida: Replace Primitive with Object (crear clases Telefono y Direccion).
public class Persona {

    private String nombre;
    private String apellido;
    // SMELL: Primitive Obsession — un teléfono con formato propio no debería ser un String crudo.
    private String telefono;
    // SMELL: Primitive Obsession — la dirección tiene estructura (calle, nro, ciudad, cp), no es un String.
    private String direccion;

    public Persona(String nombre, String apellido, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // SMELL: validación de un concepto propio (Telefono) viviendo en Persona.
    public boolean validarTelefono() {
        return telefono.matches("\\d{3}-\\d{3}-\\d{4}");
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Dirección: " + direccion);
    }

}


package ar.edu.ubp.das.ejemplo08.original;

// SMELL: Data Clumps — los campos de dirección (calle, nroCalle, ciudad, codigoPostal, pais)
// viajan siempre juntos por constructor, método de actualización e impresión.
// Refactor sugerida: Extract Class (crear una clase Direccion).
public class Cliente {

    private String nombre;
    private String email;

    // SMELL: Data Clump — este grupo de 5 campos debería ser una clase Direccion.
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

    // SMELL: Data Clump — el mismo grupo de 5 parámetros vuelve a aparecer.
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

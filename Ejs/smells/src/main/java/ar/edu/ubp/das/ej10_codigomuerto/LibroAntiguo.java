package ar.edu.ubp.das.ej10_codigomuerto;

public class LibroAntiguo extends Libro {

    private int anioEdicion;

    public LibroAntiguo(String titulo, String autor, int anioEdicion) {
        super(titulo, autor);
        this.anioEdicion = anioEdicion;
    }

    public int getAnioEdicion() {
        return anioEdicion;
    }

}

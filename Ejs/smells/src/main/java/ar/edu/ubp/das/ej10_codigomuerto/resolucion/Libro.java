package ar.edu.ubp.das.ej10_codigomuerto.resolucion;

public class Libro {

    private String titulo;
    private boolean prestado;

    public Libro(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

}

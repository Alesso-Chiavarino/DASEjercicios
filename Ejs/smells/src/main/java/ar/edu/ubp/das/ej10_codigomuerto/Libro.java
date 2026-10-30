package ar.edu.ubp.das.ej10_codigomuerto;

public class Libro {

    private String titulo;
    private String autor;
    private boolean prestado;
    private int vecesPrestado;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
        this.vecesPrestado++;
    }

}

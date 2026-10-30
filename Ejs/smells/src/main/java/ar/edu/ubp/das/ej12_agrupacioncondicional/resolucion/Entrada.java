package ar.edu.ubp.das.ej12_agrupacioncondicional.resolucion;

public abstract class Entrada {

    private String pelicula;

    public Entrada(String pelicula) {
        this.pelicula = pelicula;
    }

    public String getPelicula() {
        return pelicula;
    }

    public abstract String getTipo();

    public abstract double calcularPrecio(double precioBase);

    public abstract String describirBeneficio();

    public abstract boolean requiereDocumento();

}

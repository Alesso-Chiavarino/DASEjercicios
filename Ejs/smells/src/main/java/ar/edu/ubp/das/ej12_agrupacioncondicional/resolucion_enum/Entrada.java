package ar.edu.ubp.das.ej12_agrupacioncondicional.resolucion_enum;

public class Entrada {

    private String pelicula;
    private TipoEntrada tipo;

    public Entrada(String pelicula, TipoEntrada tipo) {
        this.pelicula = pelicula;
        this.tipo = tipo;
    }

    public String getPelicula() {
        return pelicula;
    }

    public TipoEntrada getTipo() {
        return tipo;
    }

    public double calcularPrecio(double precioBase) {
        return tipo.calcularPrecio(precioBase);
    }

    public String describirBeneficio() {
        return tipo.getBeneficio();
    }

    public boolean requiereDocumento() {
        return tipo.requiereDocumento();
    }

}

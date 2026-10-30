package ar.edu.ubp.das.ej12_agrupacioncondicional.resolucion;

public class EntradaJubilado extends Entrada {

    public EntradaJubilado(String pelicula) {
        super(pelicula);
    }

    @Override
    public String getTipo() {
        return "JUBILADO";
    }

    @Override
    public double calcularPrecio(double precioBase) {
        return precioBase * 0.50;
    }

    @Override
    public String describirBeneficio() {
        return "50% de descuento";
    }

    @Override
    public boolean requiereDocumento() {
        return true;
    }

}

package ar.edu.ubp.das.ej12_agrupacioncondicional.resolucion;

public class EntradaVip extends Entrada {

    public EntradaVip(String pelicula) {
        super(pelicula);
    }

    @Override
    public String getTipo() {
        return "VIP";
    }

    @Override
    public double calcularPrecio(double precioBase) {
        return precioBase * 1.5 + 2000;
    }

    @Override
    public String describirBeneficio() {
        return "Butaca premium + combo";
    }

    @Override
    public boolean requiereDocumento() {
        return false;
    }

}

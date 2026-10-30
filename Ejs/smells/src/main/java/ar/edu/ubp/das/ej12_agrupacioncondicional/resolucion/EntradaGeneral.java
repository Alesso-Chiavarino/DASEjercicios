package ar.edu.ubp.das.ej12_agrupacioncondicional.resolucion;

public class EntradaGeneral extends Entrada {

    public EntradaGeneral(String pelicula) {
        super(pelicula);
    }

    @Override
    public String getTipo() {
        return "GENERAL";
    }

    @Override
    public double calcularPrecio(double precioBase) {
        return precioBase;
    }

    @Override
    public String describirBeneficio() {
        return "Sin beneficio";
    }

    @Override
    public boolean requiereDocumento() {
        return false;
    }

}

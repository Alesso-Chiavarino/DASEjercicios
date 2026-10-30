package ar.edu.ubp.das.ej12_agrupacioncondicional.resolucion;

public class EntradaEstudiante extends Entrada {

    public EntradaEstudiante(String pelicula) {
        super(pelicula);
    }

    @Override
    public String getTipo() {
        return "ESTUDIANTE";
    }

    @Override
    public double calcularPrecio(double precioBase) {
        return precioBase * 0.70;
    }

    @Override
    public String describirBeneficio() {
        return "30% de descuento";
    }

    @Override
    public boolean requiereDocumento() {
        return true;
    }

}

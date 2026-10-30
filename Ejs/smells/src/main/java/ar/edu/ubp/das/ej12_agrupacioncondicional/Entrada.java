package ar.edu.ubp.das.ej12_agrupacioncondicional;

public class Entrada {

    private String pelicula;
    private String tipo; // GENERAL, ESTUDIANTE, JUBILADO, VIP

    public Entrada(String pelicula, String tipo) {
        this.pelicula = pelicula;
        this.tipo = tipo;
    }

    public String getPelicula() {
        return pelicula;
    }

    public String getTipo() {
        return tipo;
    }

    public double calcularPrecio(double precioBase) {
        switch (tipo) {
            case "GENERAL":
                return precioBase;
            case "ESTUDIANTE":
                return precioBase * 0.70;
            case "JUBILADO":
                return precioBase * 0.50;
            case "VIP":
                return precioBase * 1.5 + 2000;
            default:
                throw new IllegalArgumentException("Tipo de entrada desconocido: " + tipo);
        }
    }

    public String describirBeneficio() {
        switch (tipo) {
            case "GENERAL":
                return "Sin beneficio";
            case "ESTUDIANTE":
                return "30% de descuento";
            case "JUBILADO":
                return "50% de descuento";
            case "VIP":
                return "Butaca premium + combo";
            default:
                throw new IllegalArgumentException("Tipo de entrada desconocido: " + tipo);
        }
    }

    public boolean requiereDocumento() {
        return tipo.equals("ESTUDIANTE") || tipo.equals("JUBILADO");
    }

}

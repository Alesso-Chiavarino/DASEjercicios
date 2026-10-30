package ar.edu.ubp.das.ej19_cambioencadena.resolucion;

public class CalculadoraIva {

    private static final double IVA = 0.21;
    private static final String PORCENTAJE = "21%";

    public static double calcularIva(double neto) {
        return redondear(neto * IVA);
    }

    public static double redondear(double valor) {
        return Math.round(valor * 100) / 100.0;
    }

    public static String getPorcentaje() {
        return PORCENTAJE;
    }

}

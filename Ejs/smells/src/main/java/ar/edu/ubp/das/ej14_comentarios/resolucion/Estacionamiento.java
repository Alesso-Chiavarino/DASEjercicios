package ar.edu.ubp.das.ej14_comentarios.resolucion;

public class Estacionamiento {

    private static final int MINUTOS_TOLERANCIA = 10;
    private static final int MINUTOS_POR_FRACCION = 15;
    private static final double PRECIO_POR_FRACCION = 300;
    private static final double TOPE_DIARIO = 12000;

    public double calcularTarifa(int minutos, boolean esMoto) {
        assert minutos >= 0 : "Los minutos no pueden ser negativos";

        if (minutos <= MINUTOS_TOLERANCIA) {
            return 0;
        }

        double tarifa = calcularFracciones(minutos) * PRECIO_POR_FRACCION;
        if (esMoto) {
            tarifa = tarifa / 2;
        }
        return aplicarTopeDiario(tarifa);
    }

    private int calcularFracciones(int minutos) {
        int fracciones = minutos / MINUTOS_POR_FRACCION;
        if (minutos % MINUTOS_POR_FRACCION != 0) {
            fracciones++;
        }
        return fracciones;
    }

    private double aplicarTopeDiario(double tarifa) {
        if (tarifa > TOPE_DIARIO) {
            return TOPE_DIARIO;
        }
        return tarifa;
    }

}

package ar.edu.ubp.das.ej14_comentarios;

public class Estacionamiento {

    // calcula la tarifa
    public double calcularTarifa(int minutos, boolean esMoto) {
        // OJO: minutos nunca puede ser negativo, el que llama tiene que controlarlo

        // si estuvo 10 minutos o menos no se cobra (tolerancia)
        if (minutos <= 10) {
            return 0;
        }

        // calculamos cuántas fracciones de 15 minutos hay
        // (una fracción empezada se cobra entera)
        int fracciones = minutos / 15;
        if (minutos % 15 != 0) {
            fracciones++;
        }

        // cada fracción cuesta $250
        double tarifa = fracciones * 300;

        // las motos pagan la mitad
        if (esMoto) {
            tarifa = tarifa / 2;
        }

        // tope diario: nunca se cobra más de $12000
        if (tarifa > 12000) {
            tarifa = 12000;
        }

        return tarifa;
    }

}

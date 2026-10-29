package ar.edu.ubp.das.sim4.ej1;

public class ValidadorDistancia {

    public static boolean esValida(double distanciaKm) {
        return distanciaKm > 0 && distanciaKm <= 15;
    }

}

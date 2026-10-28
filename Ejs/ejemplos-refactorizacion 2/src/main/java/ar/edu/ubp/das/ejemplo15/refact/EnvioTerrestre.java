package ar.edu.ubp.das.ejemplo15.refact;

public class EnvioTerrestre implements ServicioEnvio {

    @Override
    public double calcularCostoEnvio(double peso, double distancia) {
        return peso * 0.8 + distancia * 0.5;
    }

}

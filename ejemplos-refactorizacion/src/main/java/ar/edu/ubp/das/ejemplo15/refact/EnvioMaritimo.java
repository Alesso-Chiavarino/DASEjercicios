package ar.edu.ubp.das.ejemplo15.refact;

public class EnvioMaritimo implements ServicioEnvio{

    @Override
    public double calcularCostoEnvio(double peso, double distancia) {
        return peso * 0.5 + distancia * 0.2;
    }

}

package ar.edu.ubp.das.ejemplo15.original;

// SMELL: Alternative Classes with Different Interfaces — misma responsabilidad que EnvioMaritimo
// pero el método se llama 'calcularCosto' en vez de 'calcularTarifa'. No comparten interfaz.
public class EnvioTerrestre {

    // SMELL: nombre distinto al de EnvioMaritimo.calcularTarifa() para la misma operación.
    public double calcularCosto(double peso, double distancia) {
        return peso * 0.8 + distancia * 0.5;
    }

}

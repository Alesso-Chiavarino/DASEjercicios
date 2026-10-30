package ar.edu.ubp.das.ejemplo15.original;

// SMELL: Alternative Classes with Different Interfaces — EnvioMaritimo y EnvioTerrestre hacen
// lo mismo (calcular costo de envío) pero exponen métodos con nombres distintos:
// 'calcularTarifa' acá y 'calcularCosto' en EnvioTerrestre, impidiendo tratarlos polimórficamente.
// Refactor sugerida: Rename Method + Extract Interface (ServicioEnvio.calcular(peso, distancia)).
public class EnvioMaritimo {

    // SMELL: nombre distinto al de EnvioTerrestre.calcularCosto() para una operación equivalente.
    public double calcularTarifa(double peso, double distancia) {
        return peso * 0.5 + distancia * 0.2;
    }

}

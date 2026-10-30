package ar.edu.ubp.das.ejemplo18.original;

// SMELL: Lazy Class — una clase entera para una sola operación trivial, usada por un solo cliente (Factura).
// No encapsula ningún estado ni invariante propia: cualquiera puede escribir 'monto * 0.21' igual.
// Refactor sugerida: Inline Class (meter su contenido en Factura).
public class CalculadoraIVA {

    public double calcular(double monto) {
        return monto * 0.21;
    }

}

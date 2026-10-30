package ar.edu.ubp.das.ejemplo07.original;

// SMELL: Switch Statements — el switch decide el comportamiento según el "tipo" (string) de operación.
// Agregar una operación nueva obliga a modificar esta clase.
// Refactor sugerida: Replace Conditional with Polymorphism (una clase por operación + interfaz común).
public class Calculadora {

    public double calcular(String tipoOperacion, double a, double b) {
        // SMELL: Switch Statement sobre el "tipo" — violación de OCP.
        switch (tipoOperacion) {
            case "suma":
                return a + b;
            case "resta":
                return a - b;
            case "multiplicacion":
                return a * b;
            case "division":
                if (b != 0) {
                    return a / b;
                }
                else {
                    throw new IllegalArgumentException("No se puede dividir por cero");
                }
            default:
                throw new UnsupportedOperationException("Operación no soportada: " + tipoOperacion);
        }
    }

}


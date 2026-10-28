package ar.edu.ubp.das.ejemplo07.original;

public class Calculadora {

    public double calcular(String tipoOperacion, double a, double b) {
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


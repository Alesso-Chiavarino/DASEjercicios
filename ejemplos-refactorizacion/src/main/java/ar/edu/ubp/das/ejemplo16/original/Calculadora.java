package ar.edu.ubp.das.ejemplo16.original;

// SMELL: Dead Code — hay métodos, parámetros, código comentado y código inalcanzable
// que nunca se ejecutan. Confunde al lector y da la ilusión de que la clase hace más cosas.
// Refactor sugerida: eliminar todo lo que no se usa. Git guarda el historial.
public class Calculadora {

    // SMELL: Dead Code — 'moneda' nunca se usa.
    public double sumar(double a, double b, String moneda) {
        return a + b;
    }

    // SMELL: Dead Code — método nunca invocado desde Run ni desde la clase.
    public double restar(double a, double b) {
        return a - b;
    }

    public double promedio(double a, double b) {
        double resultado = (a + b) / 2;
        return resultado;
        // SMELL: Dead Code — código inalcanzable después del return.
        // System.out.println("Promedio calculado: " + resultado);
    }

    // SMELL: Dead Code — bloque comentado "por las dudas".
    // public double multiplicar(double a, double b) {
    //     return a * b;
    // }

}

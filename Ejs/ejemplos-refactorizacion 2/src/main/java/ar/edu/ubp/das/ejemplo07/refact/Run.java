package ar.edu.ubp.das.ejemplo07.refact;

public class Run {

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        Operacion suma = new Suma();
        Operacion resta = new Resta();
        Operacion multiplicacion = new Multiplicacion();
        Operacion division = new Division();

        System.out.println("Suma: " + calculadora.calcular(suma, 10, 5));
        System.out.println("Resta: " + calculadora.calcular(resta, 10, 5));
        System.out.println("Multiplicación: " + calculadora.calcular(multiplicacion, 10, 5));
        System.out.println("División: " + calculadora.calcular(division, 10, 5));

        // Refactorización aplicada: "Replace Conditional with Polymorphism" (Reemplazo
        // de condicional por polimorfismo) el switch fue eliminado y reemplazado por
        // polimorfismo. Se creó una interfaz Operacion y se implementaron clases
        // específicas para cada tipo de operación (Suma, Resta, etc.).
        // Esto permite que la clase Calculadora sea extensible sin necesidad de
        // modificarla cuando se añadan nuevas operaciones, lo que mejora la
        // adherencia al principio Abierto/Cerrado (abierto para extensión,
        // cerrado para modificación).
    }

}

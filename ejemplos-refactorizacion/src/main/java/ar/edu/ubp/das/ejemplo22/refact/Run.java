package ar.edu.ubp.das.ejemplo22.refact;

public class Run {

    public static void main(String[] args) {
        Empleado empleado = new Empleado("ATAHUALPA MAS", 500, 160, 8, true);
        CalculadorNomina calculador = new CalculadorNomina();
        calculador.calcular(empleado);

        // Refactorización aplicada: "Extract Method" (Extraer Método). calcular()
        // hacía demasiadas cosas: calcular base, bonos, aportes, impuesto e imprimir.
        // Se partió en métodos privados con nombres descriptivos (calcularBase,
        // calcularBonos, calcularAportes, calcularImpuesto, imprimirRecibo). Ahora
        // calcular() se lee como un resumen de alto nivel y cada parte se puede
        // probar o cambiar por separado.
    }

}

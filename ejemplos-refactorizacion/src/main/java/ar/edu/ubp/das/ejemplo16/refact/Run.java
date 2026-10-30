package ar.edu.ubp.das.ejemplo16.refact;

public class Run {

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        System.out.println("Suma: " + calculadora.sumar(10, 5));
        System.out.println("Promedio: " + calculadora.promedio(10, 5));

        // Refactorización aplicada: eliminación de "Dead Code" (código muerto).
        // Se removió el método restar() que nunca se llamaba, el parámetro 'moneda'
        // de sumar() que nunca se usaba, el código inalcanzable después del return
        // de promedio() y el bloque comentado de multiplicar(). El historial de git
        // sigue guardando esas versiones si alguna vez vuelven a hacer falta.
    }

}

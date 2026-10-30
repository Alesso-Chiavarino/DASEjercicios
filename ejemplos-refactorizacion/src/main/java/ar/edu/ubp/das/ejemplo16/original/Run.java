package ar.edu.ubp.das.ejemplo16.original;

public class Run {

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        System.out.println("Suma: " + calculadora.sumar(10, 5, "ARS"));
        System.out.println("Promedio: " + calculadora.promedio(10, 5));
    }

}

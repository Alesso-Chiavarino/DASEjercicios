package ar.edu.ubp.das.ejemplo07.original;

public class Run {

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        System.out.println("Suma: " + calculadora.calcular("suma", 10, 5));
        System.out.println("Resta: " + calculadora.calcular("resta", 10, 5));
        System.out.println("Multiplicación: " + calculadora.calcular("multiplicacion", 10, 5));
        System.out.println("División: " + calculadora.calcular("division", 10, 5));
    }

}

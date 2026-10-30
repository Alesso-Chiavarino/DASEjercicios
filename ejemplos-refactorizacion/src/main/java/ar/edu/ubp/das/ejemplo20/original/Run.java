package ar.edu.ubp.das.ejemplo20.original;

public class Run {

    public static void main(String[] args) {
        double[] precios = { 100.0, 200.0, 50.0 };

        CalculadorPrecios calculador = new CalculadorPrecios();

        System.out.println("Total con IVA: " + calculador.totalConIVA(precios));
        System.out.println("Total con 10% de descuento: " + calculador.totalConDescuento(precios, 10));
    }

}

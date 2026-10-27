package ar.edu.ubp.das.ej1;

import java.util.Arrays;
import java.util.List;

public class Run {

    public static void main(String[] args) {
        CalcularMiCarrito calculadora = new CalcularMiCarrito();

        // Armamos un carrito con varios productos ya conocidos
        List<String> carrito = Arrays.asList("Mate", "Yerba", "Termo");
        int cantidad = 1;

        System.out.println("Caso 1: Efectivo sin promoción");
        double totalEfectivo = calculadora.totalEfectivo(carrito, cantidad);
        System.out.println("Total efectivo: $" + totalEfectivo);

        System.out.println("\nCaso 2: Efectivo con promoción temporal");
        calculadora.configurarPromocionTemporal(10);
        double totalPromo = calculadora.totalEfectivo(carrito, cantidad);
        System.out.println("Total efectivo con promo: $" + totalPromo);

        System.out.println("\nCaso 3: Tarjeta 6 cuotas (promo anterior sigue activa)");
        calculadora.configurarCuotasTemporales(6);
        double totalTarjeta = calculadora.totalTarjeta(carrito, cantidad);
        System.out.println("Total tarjeta (promo arrastrada): $" + totalTarjeta);

        System.out.println("\nCaso 4: Limpiamos los valores temporales y recalculamos");
        calculadora.limpiarConfiguracion();
        double totalLimpio = calculadora.totalTarjeta(carrito, cantidad);
        System.out.println("Total tarjeta sin promo ni extras: $" + totalLimpio);

        System.out.println("\nCaso 5: Agregamos impuesto extra temporal del 3%");
        calculadora.configurarImpuestoExtraTemporal(3);
        double totalConImpuestoExtra = calculadora.totalEfectivo(carrito, cantidad);
        System.out.println("Total con impuesto extra temporal: $" + totalConImpuestoExtra);
    }

}

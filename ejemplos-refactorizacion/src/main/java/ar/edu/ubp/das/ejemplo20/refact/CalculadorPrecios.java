package ar.edu.ubp.das.ejemplo20.refact;

public class CalculadorPrecios {

    public double totalConIVA(double[] precios) {
        return sumarPrecios(precios) * 1.21;
    }

    public double totalConDescuento(double[] precios, double descuento) {
        double subtotal = sumarPrecios(precios);
        return subtotal - (subtotal * descuento / 100);
    }

    private double sumarPrecios(double[] precios) {
        double total = 0;
        for (double precio : precios) {
            total += precio;
        }
        return total;
    }

}

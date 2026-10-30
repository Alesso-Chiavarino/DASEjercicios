package ar.edu.ubp.das.ejemplo01.original;

// SMELL: Temporary Field — 'totalConDescuento' solo tiene sentido después de llamar a calcularDescuento().
// Refactor sugerida: Replace Temp with Query (calcular el total dentro de imprimirFactura()).
public class Pedido {

    private double[] items;
    // SMELL: Temporary Field — atributo que solo se usa en algunos métodos y depende del orden de llamadas.
    private double totalConDescuento;

    public Pedido(double[] items) {
        this.items = items;
        this.totalConDescuento = 0;
    }

    public double calcularDescuento(double descuento) {
        double total = sumarItems();
        totalConDescuento = total - (total * (descuento / 100.00));
        return totalConDescuento;
    }

    public void imprimirFactura() {
        // SMELL: usar 'totalConDescuento > 0' como bandera de "hubo descuento" falla con descuento del 100%.
        if (totalConDescuento > 0) {
            System.out.println("El total con descuento es: " + totalConDescuento);
        }
        else {
            System.out.println("El total sin descuento es: " + sumarItems());
        }
    }

    private double sumarItems() {
        double total = 0;
        for (double item : items) {
            total += item;
        }
        return total;
    }

}

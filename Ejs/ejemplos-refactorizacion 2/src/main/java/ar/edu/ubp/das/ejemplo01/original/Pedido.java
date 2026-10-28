package ar.edu.ubp.das.ejemplo01.original;

public class Pedido {

    private double[] items;
    private double totalConDescuento;  // Atributo temporal, solo se usa en algunos métodos

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

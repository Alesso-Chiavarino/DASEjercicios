package ar.edu.ubp.das.ejemplo01.refact;

public class Pedido {

    private double[] items;

    public Pedido(double[] items) {
        this.items = items;
    }

    public void imprimirFactura(double descuento) {
        double total = sumarItems();
        if(descuento > 0) {
            total -= (total * (descuento / 100.00));
            System.out.println("El total con descuento es: " + total);
        }
        else {
            System.out.println("El total sin descuento es: " + total);
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

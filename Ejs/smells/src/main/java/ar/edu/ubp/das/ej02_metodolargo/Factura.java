package ar.edu.ubp.das.ej02_metodolargo;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    private String cliente;
    private String condicionIva;
    private List<Item> items = new ArrayList<>();

    public Factura(String cliente, String condicionIva) {
        this.cliente = cliente;
        this.condicionIva = condicionIva;
    }

    public void agregarItem(Item item) {
        items.add(item);
    }

    public void imprimir() {
        System.out.println("==============================");
        System.out.println("FACTURA " + (condicionIva.equals("RI") ? "A" : "B"));
        System.out.println("Cliente: " + cliente);
        System.out.println("==============================");
        double subtotal = 0;
        for (Item item : items) {
            double importe = item.getCantidad() * item.getPrecioUnitario();
            System.out.println(item.getCantidad() + " x " + item.getDescripcion() + " ... $" + importe);
            subtotal += importe;
        }
        double descuento = 0;
        if (subtotal > 50000 && items.size() >= 3) {
            descuento = subtotal * 0.10;
        }
        double neto = subtotal - descuento;
        System.out.println("------------------------------");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento: $" + descuento);
        if (condicionIva.equals("RI")) {
            double iva = neto * 0.21;
            System.out.println("IVA (21%): $" + iva);
            System.out.println("TOTAL: $" + (neto + iva));
        } else {
            System.out.println("IVA incluido en el precio");
            System.out.println("TOTAL: $" + neto);
        }
        System.out.println("==============================");
    }

}

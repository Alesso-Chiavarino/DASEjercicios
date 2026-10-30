package ar.edu.ubp.das.ej02_metodolargo.resolucion;

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
        imprimirEncabezado();
        imprimirItems();
        imprimirDescuento();
        imprimirTotal();
    }

    private void imprimirEncabezado() {
        System.out.println("==============================");
        System.out.println("FACTURA " + (esResponsableInscripto() ? "A" : "B"));
        System.out.println("Cliente: " + cliente);
        System.out.println("==============================");
    }

    private void imprimirItems() {
        for (Item item : items) {
            System.out.println(item.getCantidad() + " x " + item.getDescripcion() + " ... $" + calcularImporte(item));
        }
    }

    private void imprimirDescuento() {
        System.out.println("------------------------------");
        System.out.println("Subtotal: $" + calcularSubtotal());
        System.out.println("Descuento: $" + calcularDescuento());
    }

    private void imprimirTotal() {
        double neto = calcularSubtotal() - calcularDescuento();
        if (esResponsableInscripto()) {
            double iva = neto * 0.21;
            System.out.println("IVA (21%): $" + iva);
            System.out.println("TOTAL: $" + (neto + iva));
        } else {
            System.out.println("IVA incluido en el precio");
            System.out.println("TOTAL: $" + neto);
        }
        System.out.println("==============================");
    }

    private double calcularImporte(Item item) {
        return item.getCantidad() * item.getPrecioUnitario();
    }

    private double calcularSubtotal() {
        double subtotal = 0;
        for (Item item : items) {
            subtotal += calcularImporte(item);
        }
        return subtotal;
    }

    private double calcularDescuento() {
        if (correspondeDescuento()) {
            return calcularSubtotal() * 0.10;
        }
        return 0;
    }

    private boolean correspondeDescuento() {
        return calcularSubtotal() > 50000 && items.size() >= 3;
    }

    private boolean esResponsableInscripto() {
        return condicionIva.equals("RI");
    }

}

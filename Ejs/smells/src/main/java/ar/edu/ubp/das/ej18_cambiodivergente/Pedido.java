package ar.edu.ubp.das.ej18_cambiodivergente;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int numero;
    private String cliente;
    private List<Item> items = new ArrayList<>();

    public Pedido(int numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

    public void agregarItem(Item item) {
        items.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getCantidad() * item.getPrecio();
        }
        if (total > 100000) {
            total = total * 0.95;
        }
        return total;
    }

    public String exportarCSV() {
        String csv = "numero;cliente;producto;cantidad;precio\n";
        for (Item item : items) {
            csv += numero + ";" + cliente + ";" + item.getProducto() + ";" + item.getCantidad() + ";" + item.getPrecio() + "\n";
        }
        return csv;
    }

    public String exportarJSON() {
        String json = "{\"numero\": " + numero + ", \"cliente\": \"" + cliente + "\", \"total\": " + calcularTotal() + "}";
        return json;
    }

    public void guardar() {
        System.out.println("INSERT INTO pedidos (numero, cliente, total) VALUES (" + numero + ", '" + cliente + "', " + calcularTotal() + ");");
        for (Item item : items) {
            System.out.println("INSERT INTO items (pedido, producto, cantidad) VALUES (" + numero + ", '" + item.getProducto() + "', " + item.getCantidad() + ");");
        }
    }

    public void borrar() {
        System.out.println("DELETE FROM items WHERE pedido = " + numero + ";");
        System.out.println("DELETE FROM pedidos WHERE numero = " + numero + ";");
    }

}

package ar.edu.ubp.das.ej18_cambiodivergente.resolucion;

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

    public int getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public List<Item> getItems() {
        return items;
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

}

package ar.edu.ubp.das.sim4.ej1;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    int numero;
    String cliente;
    List<Item> items;
    double distanciaKm;
    String estado;
    Repartidor repartidor;

    public Pedido(int numero, String cliente, double distanciaKm) {
        this.numero = numero;
        this.cliente = cliente;
        this.distanciaKm = distanciaKm;
        this.items = new ArrayList<Item>();
        this.estado = "PENDIENTE";
    }

    public void agregarItem(String descripcion, double precio, int cantidad) {
        items.add(new Item(descripcion, precio, cantidad));
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (Item item : items) {
            subtotal += item.getPrecio() * item.getCantidad();
        }
        return subtotal;
    }

    public double calcularEnvio() {
        return distanciaKm * 350;
    }

}

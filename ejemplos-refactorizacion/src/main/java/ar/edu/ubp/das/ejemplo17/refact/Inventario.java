package ar.edu.ubp.das.ejemplo17.refact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventario {

    private List<String> productos;
    private Map<String, Integer> stock;

    public Inventario() {
        this.productos = new ArrayList<>();
        this.stock = new HashMap<>();
    }

    public void agregarProducto(String producto, int cantidadInicial) {
        productos.add(producto);
        stock.put(producto, cantidadInicial);
    }

    public int consultarStock(String producto) {
        return stock.getOrDefault(producto, 0);
    }

    public void descontarUnidad(String producto) {
        stock.put(producto, stock.get(producto) - 1);
    }

}

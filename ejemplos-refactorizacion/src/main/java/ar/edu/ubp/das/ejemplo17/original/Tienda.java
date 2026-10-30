package ar.edu.ubp.das.ejemplo17.original;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// SMELL: Large Class — Tienda agrupa 3 responsabilidades distintas: inventario, clientes y ventas.
// Al leerla cuesta ubicarse, cualquier cambio arriesga tocar temas que no estaban en el pedido,
// y aparecen otros smells derivados (Divergent Change, Duplicated Code).
// Refactor sugerida: Extract Class (Inventario, GestorClientes, RegistroVentas).
public class Tienda {

    // SMELL: Large Class — bloque "inventario".
    private List<String> productos;
    private Map<String, Integer> stock;

    // SMELL: Large Class — bloque "clientes".
    private List<String> clientes;
    private Map<String, Integer> puntos;

    // SMELL: Large Class — bloque "ventas".
    private double totalVendido;

    public Tienda() {
        this.productos = new ArrayList<>();
        this.stock = new HashMap<>();
        this.clientes = new ArrayList<>();
        this.puntos = new HashMap<>();
        this.totalVendido = 0;
    }

    public void agregarProducto(String producto, int cantidadInicial) {
        productos.add(producto);
        stock.put(producto, cantidadInicial);
    }

    public int consultarStock(String producto) {
        return stock.getOrDefault(producto, 0);
    }

    public void registrarCliente(String cliente) {
        clientes.add(cliente);
        puntos.put(cliente, 0);
    }

    public void sumarPuntos(String cliente, int puntosGanados) {
        puntos.put(cliente, puntos.getOrDefault(cliente, 0) + puntosGanados);
    }

    public void registrarVenta(String cliente, String producto, double monto) {
        stock.put(producto, stock.get(producto) - 1);
        sumarPuntos(cliente, (int) (monto / 100));
        totalVendido += monto;
        System.out.println("Venta registrada: " + producto + " a " + cliente + " por $" + monto);
    }

    public double getTotalVendido() {
        return totalVendido;
    }

}

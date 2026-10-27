package ar.edu.ubp.das.ej2;

import java.util.HashMap;
import java.util.Map;

public class Run {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("35123456", "ATAHUALPA MAS", 10, "PLATA");

        Map<String,Integer> carrito = new HashMap<>();
        carrito.put("fideos", 5);
        carrito.put("leche",  3);

        GestorCliente gestor = new GestorCliente(cliente);

        PedidoService servicio = new PedidoService();

        System.out.println("COMPRA EN EL SÚPER");
        System.out.println("Cliente: " + gestor.obtenerNombre() + " - DNI: " + gestor.obtenerDni());
        System.out.println("Categoría: " + gestor.obtenerCategoria() + " | Puntos actuales: " + gestor.obtenerPuntos());

        double total = servicio.calcularTotal(carrito, gestor);
        System.out.println("Subtotal con posible descuento por categoría: $" + total);

        System.out.println("Puntos luego de la compra: " + gestor.obtenerPuntos());
    }

}

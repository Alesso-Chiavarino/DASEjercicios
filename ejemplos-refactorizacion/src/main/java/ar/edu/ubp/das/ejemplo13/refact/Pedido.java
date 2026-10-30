package ar.edu.ubp.das.ejemplo13.refact;

import java.util.List;

public class Pedido {

    private Cliente cliente;
    private List<Producto> productos;
    private String metodoPago;

    public Pedido(Cliente cliente, List<Producto> productos, String metodoPago) {
        this.cliente = cliente;
        this.productos = productos;
        this.metodoPago = metodoPago;
    }

    public void mostrarDetallePedido() {
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Correo: " + cliente.getEmail());
        System.out.println("Dirección de entrega: " + cliente.getDireccionEntrega() + ", " + cliente.getCiudadEntrega() + ", " + cliente.getCodigoPostalEntrega());
        System.out.println("Productos:");
        double total = 0;
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + " (Cantidad: " + producto.getCantidad() + ")");
            System.out.println("Precio total: " + producto.calcularPrecioTotal());
            total += producto.calcularPrecioTotal();
        }
        System.out.println("Método de pago: " + metodoPago);
        System.out.println("Total a pagar: " + total);
    }
}


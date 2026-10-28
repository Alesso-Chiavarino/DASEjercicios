package ar.edu.ubp.das.ejemplo13.original;

import java.util.List;

public class Pedido {

    private String clienteNombre;
    private String clienteEmail;
    private String direccionEntrega;
    private String ciudadEntrega;
    private String codigoPostalEntrega;
    private List<String> productos;
    private List<Integer> cantidades;
    private List<Double> preciosUnitarios;
    private String metodoPago;

    public Pedido(String clienteNombre, String clienteEmail, String direccionEntrega, String ciudadEntrega,
                  String codigoPostalEntrega, List<String> productos, List<Integer> cantidades,
                  List<Double> preciosUnitarios, String metodoPago) {
        this.clienteNombre = clienteNombre;
        this.clienteEmail = clienteEmail;
        this.direccionEntrega = direccionEntrega;
        this.ciudadEntrega = ciudadEntrega;
        this.codigoPostalEntrega = codigoPostalEntrega;
        this.productos = productos;
        this.cantidades = cantidades;
        this.preciosUnitarios = preciosUnitarios;
        this.metodoPago = metodoPago;
    }

    public void mostrarDetallePedido() {
        System.out.println("Cliente: " + clienteNombre);
        System.out.println("Correo: " + clienteEmail);
        System.out.println("Dirección de entrega: " + direccionEntrega + ", " + ciudadEntrega + ", " + codigoPostalEntrega);
        System.out.println("Productos:");
        double total = 0;
        for (int i = 0; i < productos.size(); i++) {
            System.out.println(productos.get(i) + " (Cantidad: " + cantidades.get(i) + ")");
            System.out.println("Precio total: " + (preciosUnitarios.get(i) * cantidades.get(i)));
            total += (preciosUnitarios.get(i) * cantidades.get(i));
        }
        System.out.println("Método de pago: " + metodoPago);
        System.out.println("Total a pagar: " + total);
    }

}


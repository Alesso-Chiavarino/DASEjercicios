package ar.edu.ubp.das.ejemplo10.original;

public class Pedido {

    private Cliente cliente;
    private String nroPedido;
    private double monto;

    public Pedido(Cliente cliente, String nroPedido, double monto) {
        this.cliente = cliente;
        this.nroPedido = nroPedido;
        this.monto = monto;
    }

    public void mostrarDetallePedido() {
        // SMELL: Inappropriate Intimacy — Pedido accede directo a los campos de Cliente.
        System.out.println("Cliente: " + cliente.nombre);
        System.out.println("Correo: " + cliente.email);
        System.out.println("Nro. Pedido: " + nroPedido);
        System.out.println("Monto del pedido: " + monto);
    }

}

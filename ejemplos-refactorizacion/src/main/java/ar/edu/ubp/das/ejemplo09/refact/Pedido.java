package ar.edu.ubp.das.ejemplo09.refact;

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
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Correo: " + cliente.getEmail());
        System.out.println("Nro. Pedido: " + nroPedido);
        System.out.println("Monto del pedido: " + monto);
    }

}

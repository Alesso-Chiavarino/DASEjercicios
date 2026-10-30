package ar.edu.ubp.das.ejemplo09.original;

public class Pedido {

    private ClienteEngine cliente;
    private String nroPedido;
    private double monto;

    public Pedido(ClienteEngine cliente, String nroPedido, double monto) {
        this.cliente = cliente;
        this.nroPedido = nroPedido;
        this.monto = monto;
    }

    public void mostrarDetallePedido() {
        System.out.println("Cliente: " + cliente.getNombreCliente());
        System.out.println("Correo: " + cliente.getEmailCliente());
        System.out.println("Nro. Pedido: " + nroPedido);
        System.out.println("Monto del pedido: " + monto);
    }

}


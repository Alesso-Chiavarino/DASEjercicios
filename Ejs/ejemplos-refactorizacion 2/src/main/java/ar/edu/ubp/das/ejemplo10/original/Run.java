package ar.edu.ubp.das.ejemplo10.original;

public class Run {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("ATAHUALPA MAS", "atahmas@ubp.edu.ar");
        Pedido pedido = new Pedido(cliente, "2024-00123456", 150.50);
        pedido.mostrarDetallePedido();
    }

}

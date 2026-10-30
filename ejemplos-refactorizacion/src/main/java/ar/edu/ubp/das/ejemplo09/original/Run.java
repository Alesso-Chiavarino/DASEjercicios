package ar.edu.ubp.das.ejemplo09.original;

public class Run {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("ATAHUALPA MAS", "atahmas@ubp.edu.ar");
        ClienteEngine clienteEng = new ClienteEngine(cliente);

        Pedido pedido = new Pedido(clienteEng, "2024-00123456", 150.50);
        pedido.mostrarDetallePedido();
    }

}

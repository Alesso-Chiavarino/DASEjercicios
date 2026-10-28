package ar.edu.ubp.das.ejemplo02.original;

public class Run {

    public static void main(String[] args) {
        Direccion direccion = new Direccion("Argüello", "Donato Alvarez", "380");
        Cliente cliente = new Cliente("ATAHUALPA MAS", direccion);
        Pedido pedido = new Pedido(cliente);
        pedido.imprimirCliente();
    }

}

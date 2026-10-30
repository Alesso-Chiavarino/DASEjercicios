package ar.edu.ubp.das.ejemplo06.original;

public class Run {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("ATAHUALPA MAS", "atahmas@ubp.edu.ar", 6);
        Pedido pedido = new Pedido(1000, cliente);
        pedido.calcularDescuento();
        System.out.println("Monto con descuento: " + pedido.getMontoTotal());
    }

}

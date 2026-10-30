package ar.edu.ubp.das.ejemplo01.original;

public class Run {

    public static void main(String[] args) {
        double items[] = { 10.50, 20.00, 5.50, 46.00, 18.00 };

        Pedido pedido = new Pedido(items);
        pedido.calcularDescuento(10);
        pedido.imprimirFactura();
  }

}

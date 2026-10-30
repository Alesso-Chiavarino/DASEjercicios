package ar.edu.ubp.das.ej07_envidiadecaracteristicas.resolucion;

public class Caja {

    private double recaudado = 0;

    public void cobrar(Pedido pedido) {
        double total = pedido.calcularTotal();
        recaudado += total;
        System.out.println("Cobrando pedido de " + pedido.getCliente() + ": $" + total);
    }

    public void cerrarCaja() {
        System.out.println("Total recaudado: $" + recaudado);
    }

}

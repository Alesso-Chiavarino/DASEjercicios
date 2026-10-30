package ar.edu.ubp.das.ej13_cadenademensajes.resolucion;

public class Despachante {

    public void despachar(Pedido pedido) {
        System.out.println("Despachando pedido de " + pedido.getNombreCliente()
                + " a " + pedido.getDireccionEnvio());
        System.out.println("  Total con envío: $" + (pedido.getMonto() + pedido.getRecargoEnvio()));
    }

}

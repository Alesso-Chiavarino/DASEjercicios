package ar.edu.ubp.das.ej13_cadenademensajes;

public class Despachante {

    public void despachar(Pedido pedido) {
        String ciudad = pedido.getCliente().getDireccion().getCiudad().getNombre();
        String provincia = pedido.getCliente().getDireccion().getCiudad().getProvincia().getNombre();
        double recargo = pedido.getCliente().getDireccion().getCiudad().getProvincia().getRecargoEnvio();

        System.out.println("Despachando pedido de " + pedido.getCliente().getNombre()
                + " a " + pedido.getCliente().getDireccion().getCalle() + ", " + ciudad + " (" + provincia + ")");
        System.out.println("  Total con envío: $" + (pedido.getMonto() + recargo));
    }

}

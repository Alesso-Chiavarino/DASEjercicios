package ar.edu.ubp.das.sim4.ej1;

import java.util.ArrayList;
import java.util.List;

public class Despacho {

    private List<Pedido> pedidos;
    private int proximoNumero;

    public Despacho() {
        this.pedidos = new ArrayList<Pedido>();
        this.proximoNumero = 1;
    }

    public Pedido crearPedido(String cliente, double distanciaKm) {
        if (!ValidadorDistancia.esValida(distanciaKm)) {
            System.out.println("Pedido rechazado para " + cliente + ": " + distanciaKm + " km está fuera de la zona de reparto");
            return null;
        }
        Pedido pedido = new Pedido(proximoNumero, cliente, distanciaKm);
        proximoNumero++;
        pedidos.add(pedido);
        return pedido;
    }

    public void asignar(Pedido pedido, Repartidor repartidor) {
        repartidor.tomar(pedido);
        System.out.println("Pedido #" + pedido.numero + " asignado a " + repartidor.nombre);
    }

    public void entregar(Pedido pedido) {
        pedido.repartidor.entregar(pedido);
        System.out.println("Pedido #" + pedido.numero + " entregado por " + pedido.repartidor.nombre);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

}

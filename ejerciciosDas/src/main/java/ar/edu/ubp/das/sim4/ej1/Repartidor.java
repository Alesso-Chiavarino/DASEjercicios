package ar.edu.ubp.das.sim4.ej1;

import java.util.ArrayList;
import java.util.List;

public class Repartidor {

    String nombre;
    List<Pedido> pedidos;
    double ganancias;

    public Repartidor(String nombre) {
        this.nombre = nombre;
        this.pedidos = new ArrayList<Pedido>();
        this.ganancias = 0;
    }

    public void tomar(Pedido pedido) {
        pedido.repartidor = this;
        pedido.estado = "EN_CAMINO";
        pedidos.add(pedido);
    }

    public void entregar(Pedido pedido) {
        pedido.estado = "ENTREGADO";
        ganancias += pedido.distanciaKm * 350 * 0.80;
    }

}

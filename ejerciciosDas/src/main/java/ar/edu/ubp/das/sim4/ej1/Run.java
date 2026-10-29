package ar.edu.ubp.das.sim4.ej1;

public class Run {

    public static void main(String[] args) {
        CentralPedidos central = new CentralPedidos();

        Repartidor juan = new Repartidor("Juan");
        Repartidor maria = new Repartidor("María");

        Pedido p1 = central.crearPedido("Ana", 3.0);
        p1.agregarItem("Pizza muzzarella", 9500, 1);
        p1.agregarItem("Gaseosa 1.5L", 2500, 2);

        Pedido p2 = central.crearPedido("Bruno", 6.5);
        p2.agregarItem("Hamburguesa doble", 8000, 2);

        Pedido p3 = central.crearPedido("Carla", 20);

        Pedido p4 = central.crearPedido("Diego", 2.0);
        p4.agregarItem("Docena de empanadas", 14400, 1);

        central.asignar(p1, juan);
        central.asignar(p2, maria);
        central.asignar(p4, juan);

        central.entregar(p1);
        central.entregar(p2);

        central.imprimirTicket(p1);
        central.imprimirTicket(p2);

        central.imprimirReporte();

        System.out.println("Ganancias de " + juan.nombre + ": $" + juan.ganancias);
        System.out.println("Ganancias de " + maria.nombre + ": $" + maria.ganancias);
    }

}

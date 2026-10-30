package ar.edu.ubp.das.ej07_envidiadecaracteristicas.resolucion;

public class Run {

    public static void main(String[] args) {
        Caja caja = new Caja();

        Pedido p1 = new Pedido("Carla", true, 1.5);
        p1.agregarLinea(new LineaPedido("Pizza", 2, 9000));
        p1.agregarLinea(new LineaPedido("Gaseosa", 1, 2500));

        Pedido p2 = new Pedido("Martín", false, 6);
        p2.agregarLinea(new LineaPedido("Empanada", 12, 1100));

        caja.cobrar(p1);
        caja.cobrar(p2);
        caja.cerrarCaja();
    }

}

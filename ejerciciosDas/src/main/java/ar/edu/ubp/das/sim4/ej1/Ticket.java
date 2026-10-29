package ar.edu.ubp.das.sim4.ej1;

public class Ticket {

    public void imprimir(Pedido pedido) {
        System.out.println("Ticket pedido #" + pedido.numero + " - " + pedido.cliente);
        for (Item item : pedido.items) {
            System.out.println("  " + item.getCantidad() + " x " + item.getDescripcion()
                    + " $" + (item.getPrecio() * item.getCantidad()));
        }
        double productosConIva = pedido.calcularSubtotal() * 1.21;
        double envio = pedido.distanciaKm * 350;
        System.out.println("  Productos (IVA incluido): $" + productosConIva);
        System.out.println("  Envío (" + pedido.distanciaKm + " km): $" + envio);
        System.out.println("  TOTAL: $" + (productosConIva + envio));
        System.out.println("  Repartidor: " + pedido.repartidor.nombre);
    }

}

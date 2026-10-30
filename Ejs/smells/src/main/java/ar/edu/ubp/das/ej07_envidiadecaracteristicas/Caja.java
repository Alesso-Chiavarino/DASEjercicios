package ar.edu.ubp.das.ej07_envidiadecaracteristicas;

public class Caja {

    private double recaudado = 0;

    public double calcularTotalProductos(Pedido pedido) {
        double total = 0;
        for (LineaPedido linea : pedido.getLineas()) {
            total += linea.getCantidad() * linea.getPrecioUnitario();
        }
        if (pedido.isClienteFrecuente()) {
            total = total * 0.90;
        }
        return total;
    }

    public double calcularEnvio(Pedido pedido) {
        if (pedido.getDistanciaKm() <= 2) {
            return 0;
        }
        return pedido.getDistanciaKm() * 400;
    }

    public void cobrar(Pedido pedido) {
        double total = calcularTotalProductos(pedido) + calcularEnvio(pedido);
        recaudado += total;
        System.out.println("Cobrando pedido de " + pedido.getCliente() + ": $" + total);
    }

    public void cerrarCaja() {
        System.out.println("Total recaudado: $" + recaudado);
    }

}

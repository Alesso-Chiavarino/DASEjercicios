package ar.edu.ubp.das.ejemplo06.refact;

public class Pedido {

    private double montoTotal;
    private Cliente cliente;

    public Pedido(double montoTotal, Cliente cliente) {
        this.montoTotal = montoTotal;
        this.cliente = cliente;
    }

    public double aplicarDescuento() {
        return cliente.calcularDescuento(montoTotal);
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

}

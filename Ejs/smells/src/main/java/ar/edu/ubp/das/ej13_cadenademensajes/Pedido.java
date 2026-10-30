package ar.edu.ubp.das.ej13_cadenademensajes;

public class Pedido {

    private Cliente cliente;
    private double monto;

    public Pedido(Cliente cliente, double monto) {
        this.cliente = cliente;
        this.monto = monto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getMonto() {
        return monto;
    }

}

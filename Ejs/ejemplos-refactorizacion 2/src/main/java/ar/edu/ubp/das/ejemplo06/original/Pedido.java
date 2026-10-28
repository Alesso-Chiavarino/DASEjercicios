package ar.edu.ubp.das.ejemplo06.original;

public class Pedido {

    private double montoTotal;
    private Cliente cliente;

    public Pedido(double montoTotal, Cliente cliente) {
        this.montoTotal = montoTotal;
        this.cliente = cliente;
    }

    public double calcularDescuento() {
        if (cliente.getAntiguedad() > 5 && cliente.getEmail().contains(".edu")) {
            return montoTotal * 0.15;
        }
        else if (cliente.getAntiguedad() > 2) {
            return montoTotal * 0.05;
        }
        else {
            return 0;
        }
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

}


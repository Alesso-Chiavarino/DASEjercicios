package ar.edu.ubp.das.ejemplo06.original;

// SMELL: Feature Envy — calcularDescuento() usa más datos de Cliente (antigüedad, email) que de Pedido.
// Refactor sugerida: Move Method (mover el cálculo del porcentaje a Cliente).
public class Pedido {

    private double montoTotal;
    private Cliente cliente;

    public Pedido(double montoTotal, Cliente cliente) {
        this.montoTotal = montoTotal;
        this.cliente = cliente;
    }

    public double calcularDescuento() {
        // SMELL: Feature Envy — este if depende por completo del estado de Cliente, no de Pedido.
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


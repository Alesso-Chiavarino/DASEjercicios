package ar.edu.ubp.das.ej13_cadenademensajes.resolucion;

public class Pedido {

    private Cliente cliente;
    private double monto;

    public Pedido(Cliente cliente, double monto) {
        this.cliente = cliente;
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    public String getNombreCliente() {
        return cliente.getNombre();
    }

    public String getDireccionEnvio() {
        return cliente.getDireccionCompleta();
    }

    public double getRecargoEnvio() {
        return cliente.getRecargoEnvio();
    }

}

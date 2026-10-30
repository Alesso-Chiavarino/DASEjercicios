package ar.edu.ubp.das.ej07_envidiadecaracteristicas.resolucion;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private String cliente;
    private boolean clienteFrecuente;
    private double distanciaKm;
    private List<LineaPedido> lineas = new ArrayList<>();

    public Pedido(String cliente, boolean clienteFrecuente, double distanciaKm) {
        this.cliente = cliente;
        this.clienteFrecuente = clienteFrecuente;
        this.distanciaKm = distanciaKm;
    }

    public void agregarLinea(LineaPedido linea) {
        lineas.add(linea);
    }

    public String getCliente() {
        return cliente;
    }

    public boolean isClienteFrecuente() {
        return clienteFrecuente;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public List<LineaPedido> getLineas() {
        return lineas;
    }

    public double calcularTotalProductos() {
        double total = 0;
        for (LineaPedido linea : lineas) {
            total += linea.calcularSubtotal();
        }
        if (clienteFrecuente) {
            total = total * 0.90;
        }
        return total;
    }

    public double calcularEnvio() {
        if (distanciaKm <= 2) {
            return 0;
        }
        return distanciaKm * 400;
    }

    public double calcularTotal() {
        return calcularTotalProductos() + calcularEnvio();
    }

}

package ar.edu.ubp.das.ej07_envidiadecaracteristicas;

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

}

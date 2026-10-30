package ar.edu.ubp.das.ejemplo17.refact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorClientes {

    private List<String> clientes;
    private Map<String, Integer> puntos;

    public GestorClientes() {
        this.clientes = new ArrayList<>();
        this.puntos = new HashMap<>();
    }

    public void registrarCliente(String cliente) {
        clientes.add(cliente);
        puntos.put(cliente, 0);
    }

    public void sumarPuntos(String cliente, int puntosGanados) {
        puntos.put(cliente, puntos.getOrDefault(cliente, 0) + puntosGanados);
    }

    public int consultarPuntos(String cliente) {
        return puntos.getOrDefault(cliente, 0);
    }

}

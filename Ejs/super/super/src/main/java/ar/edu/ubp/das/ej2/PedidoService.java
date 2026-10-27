package ar.edu.ubp.das.ej2;

import java.util.Map;

public class PedidoService {

    //Supongamos la siguiente fuente de datos
    private final Map<String, Double> precios = Map.of(
        "fideos", 950.0,
        "arroz",  1200.0,
        "leche",  800.0
    );

    public double calcularTotal(Map<String,Integer> items, GestorCliente gestor) {
        double subtotal = 0.0;
        for (var e : items.entrySet()) {
            Double p = precios.get(e.getKey());
            if (p != null) subtotal += p * e.getValue();
        }

        double descuento = gestor.aplicaDescuentoPrefer() ? subtotal * 0.05 : 0.0;

        int puntosGanados = (int) Math.floor(subtotal / 1000.0);
        gestor.sumarPuntos(puntosGanados);

        return subtotal - descuento;
    }

}

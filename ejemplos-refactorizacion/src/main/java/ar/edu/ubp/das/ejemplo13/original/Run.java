package ar.edu.ubp.das.ejemplo13.original;

import java.util.Arrays;
import java.util.List;

public class Run {

    public static void main(String[] args) {
        List<String> productos = Arrays.asList("Laptop", "Mouse");
        List<Integer> cantidades = Arrays.asList(2, 1);
        List<Double> preciosUnitarios = Arrays.asList(80000.0, 2000.0);

        Pedido pedido = new Pedido("ATAHUALPA MAS", "atahmas@ubp.edu.ar",
                "Donato Álvarez 380", "Argüello", "5147",
                productos, cantidades, preciosUnitarios, "Tarjeta de crédito");
        pedido.mostrarDetallePedido();
    }

}

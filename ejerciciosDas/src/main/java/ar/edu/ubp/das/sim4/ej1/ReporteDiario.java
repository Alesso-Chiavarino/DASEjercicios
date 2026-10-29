package ar.edu.ubp.das.sim4.ej1;

import java.util.List;

public class ReporteDiario {

    public void imprimir(List<Pedido> pedidos) {
        int entregados = 0;
        double recaudado = 0;
        double pagadoARepartidores = 0;
        double comisionPlataforma = 0;

        for (Pedido p : pedidos) {
            if (p.estado.equals("ENTREGADO")) {
                entregados++;
                recaudado += p.calcularSubtotal() * 1.21 + p.distanciaKm * 350;
                pagadoARepartidores += p.distanciaKm * 350 * 0.80;
                comisionPlataforma += p.distanciaKm * 350 * 0.20;
            }
        }

        System.out.println("===== REPORTE DIARIO =====");
        System.out.println("Pedidos registrados: " + pedidos.size() + " - entregados: " + entregados);
        System.out.println("Recaudado: $" + recaudado);
        System.out.println("Pagado a repartidores: $" + pagadoARepartidores);
        System.out.println("Comisión de la plataforma: $" + comisionPlataforma);
    }

}

package ar.edu.ubp.das.ej16_generalidadespeculativa;

import java.util.List;

public class ProcesadorReservas extends ProcesadorBase {

    public ProcesadorReservas(Notificable notificador) {
        super(notificador);
    }

    @Override
    public void procesarGenerico(Reserva reserva, boolean modoAvanzado, String formatoFuturo) {
        System.out.println("Reserva de " + reserva.getCancha() + " a las " + reserva.getHora() + " hs");
        notificador.notificar(reserva.getCliente(), "Tu reserva quedó confirmada");
    }

    // por si en el futuro se aceptan reservas grupales
    public void procesarGrupal(List<Reserva> reservas) {
        throw new UnsupportedOperationException("Todavía no implementado");
    }

}

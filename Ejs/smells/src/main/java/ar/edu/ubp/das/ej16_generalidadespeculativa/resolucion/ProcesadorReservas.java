package ar.edu.ubp.das.ej16_generalidadespeculativa.resolucion;

public class ProcesadorReservas {

    private NotificadorEmail notificador;

    public ProcesadorReservas(NotificadorEmail notificador) {
        this.notificador = notificador;
    }

    public void procesar(Reserva reserva) {
        System.out.println("Reserva de " + reserva.getCancha() + " a las " + reserva.getHora() + " hs");
        notificador.notificar(reserva.getCliente(), "Tu reserva quedó confirmada");
    }

}

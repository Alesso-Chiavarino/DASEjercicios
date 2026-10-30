package ar.edu.ubp.das.ej16_generalidadespeculativa;

// base para futuros procesadores (torneos, escuelitas, cumpleaños...)
public abstract class ProcesadorBase {

    protected Notificable notificador;

    public ProcesadorBase(Notificable notificador) {
        this.notificador = notificador;
    }

    public abstract void procesarGenerico(Reserva reserva, boolean modoAvanzado, String formatoFuturo);

}

package ar.edu.ubp.das.ej16_generalidadespeculativa;

public class Run {

    public static void main(String[] args) {
        ProcesadorBase procesador = new ProcesadorReservas(new NotificadorEmail());

        procesador.procesarGenerico(new Reserva("nico@mail.com", "Cancha 1 (fútbol 5)", 20), false, null);
        procesador.procesarGenerico(new Reserva("vale@mail.com", "Cancha 3 (pádel)", 18), false, null);
    }

}

package ar.edu.ubp.das.ej16_generalidadespeculativa.resolucion;

public class Run {

    public static void main(String[] args) {
        ProcesadorReservas procesador = new ProcesadorReservas(new NotificadorEmail());

        procesador.procesar(new Reserva("nico@mail.com", "Cancha 1 (fútbol 5)", 20));
        procesador.procesar(new Reserva("vale@mail.com", "Cancha 3 (pádel)", 18));
    }

}

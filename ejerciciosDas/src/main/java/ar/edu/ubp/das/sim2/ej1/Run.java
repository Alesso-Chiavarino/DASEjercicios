package ar.edu.ubp.das.sim2.ej1;

import java.time.LocalDate;

public class Run {

    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hotel Sierras");

        double cotizacion = hotel.cotizar("DOBLE", LocalDate.of(2026, 12, 20), LocalDate.of(2026, 12, 27), 3);
        System.out.println("Total cotizado: $" + cotizacion);
        hotel.imprimirUltimaCotizacion();

        System.out.println();

        hotel.reservar("Lucía", "Fernández", "33222111", "lucia@mail.com",
                101, "DOBLE", LocalDate.of(2026, 12, 20), LocalDate.of(2026, 12, 27), 3);

        hotel.reservar("Martín", "López", "29888777", "martin@mail.com",
                101, "DOBLE", LocalDate.of(2026, 12, 24), LocalDate.of(2026, 12, 26), 2);

        hotel.reservar("Martín", "López", "29888777", "martin@mail.com",
                205, "SUITE", LocalDate.of(2026, 12, 24), LocalDate.of(2026, 12, 26), 2);

        hotel.reservar("Sofía", "Paz", "40111000", "sofia.mail.com",
                110, "SIMPLE", LocalDate.of(2027, 1, 5), LocalDate.of(2027, 1, 8), 1);

        hotel.reservar("Lucía", "Fernández", "33222111", "lucia@mail.com",
                110, "SIMPLE", LocalDate.of(2027, 1, 10), LocalDate.of(2027, 1, 12), 1);

        System.out.println();

        hotel.listarReservasDe("Lucía", "Fernández", "33222111", "lucia@mail.com");
    }

}

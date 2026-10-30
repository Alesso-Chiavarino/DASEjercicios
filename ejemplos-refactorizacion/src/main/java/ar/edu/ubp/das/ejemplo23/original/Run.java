package ar.edu.ubp.das.ejemplo23.original;

import java.time.LocalDate;

public class Run {

    public static void main(String[] args) {
        LocalDate lunes = LocalDate.of(2026, 10, 26);
        LocalDate sabado = LocalDate.of(2026, 10, 31);

        Facturacion facturacion = new Facturacion();
        facturacion.emitir(lunes, 1500);
        facturacion.emitir(sabado, 1500);

        Turnos turnos = new Turnos();
        turnos.asignar(lunes, "ATAHUALPA MAS");
        turnos.asignar(sabado, "TUPAC DUPLO");
    }

}

package ar.edu.ubp.das.ejemplo23.refact;

import java.time.LocalDate;

public class Run {

    public static void main(String[] args) {
        Fecha lunes = new Fecha(LocalDate.of(2026, 10, 26));
        Fecha sabado = new Fecha(LocalDate.of(2026, 10, 31));

        Facturacion facturacion = new Facturacion();
        facturacion.emitir(lunes, 1500);
        facturacion.emitir(sabado, 1500);

        Turnos turnos = new Turnos();
        turnos.asignar(lunes, "ATAHUALPA MAS");
        turnos.asignar(sabado, "TUPAC DUPLO");

        // Refactorización aplicada: "Introduce Local Extension" (envoltorio).
        // A LocalDate le faltaba un esDiaHabil() y esa expresión aparecía copiada en
        // Facturacion y Turnos. Como LocalDate es final (no se puede extender), se
        // creó una clase propia Fecha que la envuelve y expone esDiaHabil(). Si
        // mañana hay que considerar feriados, se cambia en un único lugar.
    }

}

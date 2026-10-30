package ar.edu.ubp.das.ejemplo23.refact;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Fecha {

    private LocalDate fecha;

    public Fecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean esDiaHabil() {
        return fecha.getDayOfWeek() != DayOfWeek.SATURDAY
                && fecha.getDayOfWeek() != DayOfWeek.SUNDAY;
    }

    public LocalDate toLocalDate() {
        return fecha;
    }

    @Override
    public String toString() {
        return fecha.toString();
    }

}

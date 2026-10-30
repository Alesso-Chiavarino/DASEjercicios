package ar.edu.ubp.das.ejemplo23.original;

import java.time.DayOfWeek;
import java.time.LocalDate;

// SMELL: Incomplete Library Class — misma lógica de día hábil copiada de Facturacion.
public class Turnos {

    public void asignar(LocalDate fecha, String paciente) {
        // SMELL: Incomplete Library Class — expresión duplicada que debería vivir junto a Fecha.
        if (fecha.getDayOfWeek() != DayOfWeek.SATURDAY
                && fecha.getDayOfWeek() != DayOfWeek.SUNDAY) {
            System.out.println("Turno asignado a " + paciente + " el " + fecha);
        }
        else {
            System.out.println("No se asignan turnos los fines de semana.");
        }
    }

}

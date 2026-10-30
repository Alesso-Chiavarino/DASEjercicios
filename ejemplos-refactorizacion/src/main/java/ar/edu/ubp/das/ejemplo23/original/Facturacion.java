package ar.edu.ubp.das.ejemplo23.original;

import java.time.DayOfWeek;
import java.time.LocalDate;

// SMELL: Incomplete Library Class — a LocalDate le falta un método esDiaHabil().
// Como no la podemos modificar, la lógica "sábado/domingo/feriado" termina copiada
// acá, en Turnos y en cualquier otra clase que la necesite. Si cambia la regla
// (agregar un feriado puente, por ejemplo), hay que tocar todos esos lugares.
// Refactor sugerida: Introduce Local Extension (envolver LocalDate en una clase Fecha).
public class Facturacion {

    public void emitir(LocalDate fecha, double monto) {
        // SMELL: Incomplete Library Class — misma expresión duplicada en Turnos.asignar().
        if (fecha.getDayOfWeek() != DayOfWeek.SATURDAY
                && fecha.getDayOfWeek() != DayOfWeek.SUNDAY) {
            System.out.println("Factura emitida el " + fecha + " por $" + monto);
        }
        else {
            System.out.println("No se emiten facturas los fines de semana.");
        }
    }

}

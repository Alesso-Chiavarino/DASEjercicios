package ar.edu.ubp.das.ejemplo23.refact;

public class Turnos {

    public void asignar(Fecha fecha, String paciente) {
        if (fecha.esDiaHabil()) {
            System.out.println("Turno asignado a " + paciente + " el " + fecha);
        }
        else {
            System.out.println("No se asignan turnos los fines de semana.");
        }
    }

}

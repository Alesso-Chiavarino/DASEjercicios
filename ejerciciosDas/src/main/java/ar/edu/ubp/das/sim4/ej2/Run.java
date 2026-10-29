package ar.edu.ubp.das.sim4.ej2;

import java.util.Arrays;
import java.util.List;

public class Run {

    public static void main(String[] args) {
        CentroDeAvisos avisos = new CentroDeAvisos();

        Contacto ana = new Contacto("Ana", "ana@mail.com", "3516001122", "EMAIL");
        Contacto bruno = new Contacto("Bruno", "bruno@mail.com", "3515443322", "SMS");
        Contacto carla = new Contacto("Carla", "carla@mail.com", "3517889900", "WHATSAPP");
        Contacto diego = new Contacto("Diego", "diego@mail.com", "351", "SMS");

        avisos.enviarRecordatorio(ana, "Tu turno con el dentista es mañana a las 10:00");
        avisos.enviarRecordatorio(bruno, "Tu turno con el dentista es mañana a las 10:00");
        avisos.enviarRecordatorio(carla, "Tu turno con el dentista es mañana a las 10:00");
        avisos.enviarRecordatorio(diego, "Tu turno con el dentista es mañana a las 10:00");

        List<Contacto> todos = Arrays.asList(ana, bruno, carla, diego);
        avisos.enviarPromocionATodos(todos, "20% de descuento en blanqueamiento");
    }

}

package ar.edu.ubp.das.ej16_generalidadespeculativa;

// pensada para cuando haya notificaciones por SMS, WhatsApp, push, etc.
public interface Notificable {

    void notificar(String destinatario, String mensaje);

}

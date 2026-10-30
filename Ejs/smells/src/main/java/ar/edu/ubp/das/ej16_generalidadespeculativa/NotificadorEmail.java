package ar.edu.ubp.das.ej16_generalidadespeculativa;

public class NotificadorEmail implements Notificable {

    @Override
    public void notificar(String destinatario, String mensaje) {
        System.out.println("  [email a " + destinatario + "] " + mensaje);
    }

}

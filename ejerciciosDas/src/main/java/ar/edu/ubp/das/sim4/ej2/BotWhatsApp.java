package ar.edu.ubp.das.sim4.ej2;

public class BotWhatsApp {

    public void notificarContacto(Contacto contacto, String mensaje) {
        System.out.println("[WHATSAPP] Hola " + contacto.getNombre() + " (" + contacto.getTelefono() + ")! " + mensaje);
    }

}

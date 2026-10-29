package ar.edu.ubp.das.sim4.ej2;

import java.util.List;

public class CentroDeAvisos {

    private EnviadorEmail email;
    private MensajeroSMS sms;
    private BotWhatsApp whatsapp;

    public CentroDeAvisos() {
        this.email = new EnviadorEmail();
        this.sms = new MensajeroSMS();
        this.whatsapp = new BotWhatsApp();
    }

    public void enviarRecordatorio(Contacto contacto, String texto) {
        if (contacto.getCanalPreferido().equals("EMAIL")) {
            email.enviarCorreo(contacto.getEmail(), "Recordatorio", texto);
        }
        else if (contacto.getCanalPreferido().equals("SMS")) {
            if (!sms.mandar(texto, contacto.getTelefono())) {
                System.out.println("No se pudo enviar SMS a " + contacto.getNombre());
            }
        }
        else if (contacto.getCanalPreferido().equals("WHATSAPP")) {
            whatsapp.notificarContacto(contacto, texto);
        }
    }

    public void enviarPromocion(Contacto contacto, String promocion) {
        String texto = "PROMO: " + promocion;
        if (contacto.getCanalPreferido().equals("EMAIL")) {
            email.enviarCorreo(contacto.getEmail(), "Promoción especial", texto);
        }
        else if (contacto.getCanalPreferido().equals("SMS")) {
            if (!sms.mandar(texto, contacto.getTelefono())) {
                System.out.println("No se pudo enviar SMS a " + contacto.getNombre());
            }
        }
        else if (contacto.getCanalPreferido().equals("WHATSAPP")) {
            whatsapp.notificarContacto(contacto, texto);
        }
    }

    public void enviarPromocionATodos(List<Contacto> contactos, String promocion) {
        for (Contacto contacto : contactos) {
            enviarPromocion(contacto, promocion);
        }
    }

}

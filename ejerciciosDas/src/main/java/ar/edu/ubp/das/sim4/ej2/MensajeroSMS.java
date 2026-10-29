package ar.edu.ubp.das.sim4.ej2;

public class MensajeroSMS {

    public boolean mandar(String texto, String numeroTelefono) {
        if (numeroTelefono.length() < 10) {
            return false;
        }
        String recortado = texto.length() > 40 ? texto.substring(0, 40) + "..." : texto;
        System.out.println("[SMS] " + numeroTelefono + ": " + recortado);
        return true;
    }

}

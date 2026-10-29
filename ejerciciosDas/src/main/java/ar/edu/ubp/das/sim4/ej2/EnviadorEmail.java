package ar.edu.ubp.das.sim4.ej2;

public class EnviadorEmail {

    public void enviarCorreo(String direccion, String asunto, String cuerpo) {
        System.out.println("[EMAIL] Para: " + direccion + " | Asunto: " + asunto + " | " + cuerpo);
    }

}

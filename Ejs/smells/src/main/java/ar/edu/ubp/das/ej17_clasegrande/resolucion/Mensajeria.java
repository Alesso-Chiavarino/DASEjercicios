package ar.edu.ubp.das.ej17_clasegrande.resolucion;

public class Mensajeria {

    private String emailRemitente = "secretaria@escuela.edu.ar";
    private int mailsEnviados = 0;

    public void enviarMail(Alumno alumno, String asunto, String cuerpo) {
        mailsEnviados++;
        System.out.println("De: " + emailRemitente + " | Para: " + alumno.getEmail() + " | " + asunto);
        System.out.println("  " + cuerpo);
    }

    public int getMailsEnviados() {
        return mailsEnviados;
    }

}

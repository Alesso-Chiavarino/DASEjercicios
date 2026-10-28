package arg.edu.ubp.das.ej2;

public class Notificador {

    public void enviarRecordatorio(Turno turno) {

        System.out.println("Recordatorio de turno");
        System.out.println("Cliente: " + turno.getDatosEnvio().getNombreCliente() + " - Tel: " + turno.getDatosEnvio().getTelefonoCliente());
        System.out.println("Peluquero: " + turno.getDatosEnvio().getNombrePeluquero() + " (" + turno.getDatosEnvio().getEspecialidadPeluquero() + ")");
        System.out.println("Fecha: " + turno.getFecha() + " Hora: " + turno.getHora());
    }

    public void enviarEncuesta(Turno turno) {
        System.out.println("Encuesta de satisfacción");
        System.out.println("Cliente: " + turno.getDatosEnvio().getNombreCliente() + " - Tel: " + turno.getDatosEnvio().getTelefonoCliente());
        System.out.println("Peluquero: " + turno.getDatosEnvio().getNombrePeluquero() + " (" + turno.getDatosEnvio().getEspecialidadPeluquero() + ")");
        System.out.println("Turno atendido el " + turno.getFecha() + " a las " + turno.getHora());
    }
}

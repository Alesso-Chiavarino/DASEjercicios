package ar.edu.ubp.das.ej2;

public class Notificador {

    public void enviarRecordatorio(String nombreCliente,
                                   String telefonoCliente,
                                   String nombrePeluquero,
                                   String especialidadPeluquero,
                                   String fecha,
                                   String hora) {

        System.out.println("Recordatorio de turno");
        System.out.println("Cliente: " + nombreCliente + " - Tel: " + telefonoCliente);
        System.out.println("Peluquero: " + nombrePeluquero + " (" + especialidadPeluquero + ")");
        System.out.println("Fecha: " + fecha + " Hora: " + hora);
    }

    public void enviarEncuesta(String nombreCliente,
                               String telefonoCliente,
                               String nombrePeluquero,
                               String especialidadPeluquero,
                               String fecha,
                               String hora) {
        System.out.println("Encuesta de satisfacción");
        System.out.println("Cliente: " + nombreCliente + " - Tel: " + telefonoCliente);
        System.out.println("Peluquero: " + nombrePeluquero + " (" + especialidadPeluquero + ")");
        System.out.println("Turno atendido el " + fecha + " a las " + hora);
    }
}

package arg.edu.ubp.das.ej2;

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

    private void pintarPersonas(String nombreCliente,
                                String telefonoCliente,
                                String nombrePeluquero,
                                String especialidadPeluquero) {
        System.out.println("Cliente: " + nombreCliente + " - Tel: " + telefonoCliente);
        System.out.println("Peluquero: " + nombrePeluquero + " (" + especialidadPeluquero + ")");
    }

    public void enviarNotificacion(String tipo,
            String nombreCliente,
                                   String telefonoCliente,
                                   String nombrePeluquero,
                                   String especialidadPeluquero,
                                   String fecha,
                                   String hora) {

        switch (tipo) {
            case "encuesta": {
                System.out.println("Encuesta de satisfacción");
                this.pintarPersonas();
                System.out.println("Turno atendido el " + fecha + " a las " + hora);
            }
            case "recordatorio": {
                System.out.println("Recordatorio de turno");
                System.out.println("Fecha: " + fecha + " Hora: " + hora);
            }
            default:
        }

    }
}

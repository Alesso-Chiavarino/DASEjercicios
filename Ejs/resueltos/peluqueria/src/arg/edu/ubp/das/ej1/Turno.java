package arg.edu.ubp.das.ej1;

public class Turno {

    String nombreCliente;
    String telefonoCliente;
    String fecha;
    String hora;
    int duracion;

    public Turno(String nombreCliente,
                 String telefonoCliente,
                 String fecha,
                 String hora,
                 int duracion) {
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
    }

    public void confirmar() {
        System.out.println("Turno confirmado para " + nombreCliente + " el " + fecha + " a las " + hora);
    }

    public void registrarLlegada() {
        System.out.println(nombreCliente + " llegó al turno.");
    }

    public void finalizar() {
        System.out.println("Finalizando turno de " + nombreCliente);
    }

    public String mostrarDatosTurno(Peluquero peluquero) {
        StringBuilder sb = new StringBuilder();

        sb.append("------------------------------\n");
        sb.append("Datos del Turno:\n");
        sb.append("Fecha: ").append(fecha).append("\n");
        sb.append("Hora: ").append(hora).append("\n");
        sb.append("Duración: ").append(duracion).append(" min\n");
        sb.append("------------------------------\n");
        sb.append("Datos del Cliente:\n");
        sb.append("Nombre: ").append(nombreCliente).append("\n");
        sb.append("Teléfono: ").append(telefonoCliente).append("\n\n");
        sb.append("------------------------------\n");
        sb.append("Datos del Peluquero:\n");
        sb.append("Nombre: ").append(peluquero.getNombre()).append("\n");
        sb.append("Especialidad: ").append(peluquero.getEspecialidad()).append("\n");
        sb.append("Salario: ").append(peluquero.getSalario()).append("\n\n");
        sb.append("------------------------------\n");

        return sb.toString();
    }
    
}

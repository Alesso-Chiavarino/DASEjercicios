package ar.edu.ubp.das.ej1;

public class Peluquero extends Turno {

    private String nombre;
    private String especialidad;
    private double salario;

    public Peluquero(String nombre,
                     String especialidad,
                     double salario) {
        this("N/A", "N/A", "0000-00-00", "00:00", 0, nombre, especialidad, salario);
    }

    public Peluquero(String nombreCliente,
                     String telefonoCliente,
                     String fecha,
                     String hora,
                     int duracion,
                     String nombre,
                     String especialidad,
                     double salari) {
        super(nombreCliente, telefonoCliente, fecha, hora, duracion);
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public double getSalario() {
        return salario;
    }

    public void calcularPagoMensual(double totalServicios) {
        double monto = salario + (totalServicios * 0.10);
        System.out.println("Pago mensual de " + nombre + ": " + monto);
    }

    @Override
    public String toString() {
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
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Especialidad: ").append(especialidad).append("\n");
        sb.append("Salario: ").append(salario).append("\n\n");
        sb.append("------------------------------\n");

        return sb.toString();
    }

}

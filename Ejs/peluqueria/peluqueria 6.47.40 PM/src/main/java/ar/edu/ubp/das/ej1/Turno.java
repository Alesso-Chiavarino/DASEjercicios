package ar.edu.ubp.das.ej1;

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
    
}

package ar.edu.ubp.das.ej16_generalidadespeculativa;

public class Reserva {

    private String cliente;
    private String cancha;
    private int hora;

    public Reserva(String cliente, String cancha, int hora) {
        this.cliente = cliente;
        this.cancha = cancha;
        this.hora = hora;
    }

    public String getCliente() {
        return cliente;
    }

    public String getCancha() {
        return cancha;
    }

    public int getHora() {
        return hora;
    }

}

package ar.edu.ubp.das.sim2.ej1;

import java.time.LocalDate;

public class Reserva {

    private String nombreHuesped;
    private String apellidoHuesped;
    private String dniHuesped;
    private String emailHuesped;
    private int nroHabitacion;
    private String tipoHabitacion;
    private LocalDate desde;
    private LocalDate hasta;
    private int cantidadPersonas;
    private double total;

    public Reserva(String nombreHuesped, String apellidoHuesped, String dniHuesped, String emailHuesped,
                   int nroHabitacion, String tipoHabitacion, LocalDate desde, LocalDate hasta,
                   int cantidadPersonas, double total) {
        this.nombreHuesped = nombreHuesped;
        this.apellidoHuesped = apellidoHuesped;
        this.dniHuesped = dniHuesped;
        this.emailHuesped = emailHuesped;
        this.nroHabitacion = nroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.desde = desde;
        this.hasta = hasta;
        this.cantidadPersonas = cantidadPersonas;
        this.total = total;
    }

    public String getNombreHuesped() {
        return nombreHuesped;
    }

    public String getApellidoHuesped() {
        return apellidoHuesped;
    }

    public String getDniHuesped() {
        return dniHuesped;
    }

    public String getEmailHuesped() {
        return emailHuesped;
    }

    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public LocalDate getDesde() {
        return desde;
    }

    public LocalDate getHasta() {
        return hasta;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public double getTotal() {
        return total;
    }

}

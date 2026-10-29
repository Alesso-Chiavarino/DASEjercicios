package ar.edu.ubp.das.sim1.ej2;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Envio {

    private String codigo;
    private String destinatario;
    private LocalDate fechaDespacho;
    private int diasHabilesEntrega;

    public Envio(String codigo, String destinatario, LocalDate fechaDespacho, int diasHabilesEntrega) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.fechaDespacho = fechaDespacho;
        this.diasHabilesEntrega = diasHabilesEntrega;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public LocalDate getFechaDespacho() {
        return fechaDespacho;
    }

    public LocalDate getFechaEstimadaEntrega() {
        LocalDate fecha = fechaDespacho;
        int diasSumados = 0;
        while (diasSumados < diasHabilesEntrega) {
            fecha = fecha.plusDays(1);
            if (fecha.getDayOfWeek() != DayOfWeek.SATURDAY && fecha.getDayOfWeek() != DayOfWeek.SUNDAY) {
                diasSumados++;
            }
        }
        return fecha;
    }

}

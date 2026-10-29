package ar.edu.ubp.das.sim1.ej2;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Reclamo {

    private Envio envio;
    private LocalDate fechaReclamo;
    private String motivo;

    public Reclamo(Envio envio, LocalDate fechaReclamo, String motivo) {
        this.envio = envio;
        this.fechaReclamo = fechaReclamo;
        this.motivo = motivo;
    }

    public Envio getEnvio() {
        return envio;
    }

    public String getMotivo() {
        return motivo;
    }

    public LocalDate getFechaLimiteRespuesta() {
        LocalDate limite = fechaReclamo;
        int habiles = 0;
        while (habiles < 5) {
            limite = limite.plusDays(1);
            DayOfWeek dia = limite.getDayOfWeek();
            if (!(dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY)) {
                habiles++;
            }
        }
        return limite;
    }

    public boolean esPrematuro() {
        return fechaReclamo.isBefore(envio.getFechaEstimadaEntrega());
    }

}

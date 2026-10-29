package ar.edu.ubp.das.sim1.ej2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sucursal {

    private String nombre;
    private List<Envio> envios;
    private List<Reclamo> reclamos;

    public Sucursal(String nombre) {
        this.nombre = nombre;
        this.envios = new ArrayList<Envio>();
        this.reclamos = new ArrayList<Reclamo>();
    }

    public void despachar(Envio envio) {
        DayOfWeek dia = envio.getFechaDespacho().getDayOfWeek();
        if (dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY) {
            System.out.println("[" + nombre + "] No se despacha en fin de semana: " + envio.getCodigo());
            return;
        }
        envios.add(envio);
        System.out.println("[" + nombre + "] Despachado " + envio.getCodigo() + " para " + envio.getDestinatario()
                + " - entrega estimada: " + formatear(envio.getFechaEstimadaEntrega()));
    }

    public void registrarReclamo(Reclamo reclamo) {
        reclamos.add(reclamo);
        String aviso = reclamo.esPrematuro() ? " (el envío todavía está en plazo)" : "";
        System.out.println("[" + nombre + "] Reclamo por " + reclamo.getEnvio().getCodigo() + ": " + reclamo.getMotivo()
                + " - responder antes del " + formatear(reclamo.getFechaLimiteRespuesta()) + aviso);
    }

    public void listarEntregasDeLaSemana(LocalDate lunes) {
        System.out.println("[" + nombre + "] Entregas estimadas para la semana del " + formatear(lunes) + ":");
        LocalDate viernes = lunes.plusDays(4);
        for (Envio envio : envios) {
            LocalDate entrega = envio.getFechaEstimadaEntrega();
            if (!entrega.isBefore(lunes) && !entrega.isAfter(viernes)) {
                System.out.println("  " + envio.getCodigo() + " -> " + formatear(entrega));
            }
        }
    }

    private String formatear(LocalDate fecha) {
        return fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear();
    }

}

package ar.edu.ubp.das.sim2.ej1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String nombre;
    private List<Reserva> reservas;

    private String tipoCotizado;
    private long nochesCalculadas;
    private double tarifaPorNoche;
    private double descuentoAplicado;

    public Hotel(String nombre) {
        this.nombre = nombre;
        this.reservas = new ArrayList<Reserva>();
    }

    public double cotizar(String tipoHabitacion, LocalDate desde, LocalDate hasta, int cantidadPersonas) {
        this.tipoCotizado = tipoHabitacion;
        this.nochesCalculadas = ChronoUnit.DAYS.between(desde, hasta);

        if (tipoHabitacion.equals("SIMPLE")) {
            this.tarifaPorNoche = 40000;
        }
        else if (tipoHabitacion.equals("DOBLE")) {
            this.tarifaPorNoche = 60000;
        }
        else if (tipoHabitacion.equals("SUITE")) {
            this.tarifaPorNoche = 110000;
        }
        if (cantidadPersonas > 2) {
            this.tarifaPorNoche += (cantidadPersonas - 2) * 15000;
        }

        double total = this.tarifaPorNoche * this.nochesCalculadas;
        this.descuentoAplicado = 0;
        if (this.nochesCalculadas >= 7) {
            this.descuentoAplicado = total * 0.10;
        }
        return total - this.descuentoAplicado;
    }

    public void imprimirUltimaCotizacion() {
        System.out.println("Cotización " + nombre + " - habitación " + tipoCotizado);
        System.out.println("Noches: " + nochesCalculadas + " x $" + tarifaPorNoche);
        if (descuentoAplicado > 0) {
            System.out.println("Descuento por estadía larga: $" + descuentoAplicado);
        }
    }

    public void reservar(String nombre, String apellido, String dni, String email,
                         int nroHabitacion, String tipoHabitacion,
                         LocalDate desde, LocalDate hasta, int cantidadPersonas) {
        if (!email.contains("@") || !email.contains(".")) {
            System.out.println("Email inválido para " + nombre + " " + apellido + ": " + email);
            return;
        }

        for (Reserva r : reservas) {
            if (r.getNroHabitacion() == nroHabitacion
                    && desde.isBefore(r.getHasta()) && hasta.isAfter(r.getDesde())) {
                System.out.println("La habitación " + nroHabitacion + " no está disponible para "
                        + nombre + " " + apellido);
                return;
            }
        }

        long noches = ChronoUnit.DAYS.between(desde, hasta);
        double tarifa = 0;
        if (tipoHabitacion.equals("SIMPLE")) {
            tarifa = 40000;
        }
        else if (tipoHabitacion.equals("DOBLE")) {
            tarifa = 60000;
        }
        else if (tipoHabitacion.equals("SUITE")) {
            tarifa = 110000;
        }
        if (cantidadPersonas > 2) {
            tarifa += (cantidadPersonas - 2) * 15000;
        }
        double total = tarifa * noches;
        if (noches >= 7) {
            total = total - total * 0.10;
        }

        reservas.add(new Reserva(nombre, apellido, dni, email, nroHabitacion, tipoHabitacion,
                desde, hasta, cantidadPersonas, total));
        System.out.println("Reserva confirmada para " + nombre + " " + apellido + " (DNI " + dni + "): habitación "
                + nroHabitacion + " - $" + total);
    }

    public void listarReservasDe(String nombre, String apellido, String dni, String email) {
        System.out.println("Reservas de " + nombre + " " + apellido + " <" + email + ">:");
        for (Reserva r : reservas) {
            if (r.getNombreHuesped().equals(nombre) && r.getApellidoHuesped().equals(apellido)
                    && r.getDniHuesped().equals(dni) && r.getEmailHuesped().equals(email)) {
                System.out.println("  Habitación " + r.getNroHabitacion() + " (" + r.getTipoHabitacion() + ") del "
                        + r.getDesde() + " al " + r.getHasta() + " - $" + r.getTotal());
            }
        }
    }

}

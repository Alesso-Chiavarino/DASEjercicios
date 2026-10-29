package ar.edu.ubp.das.sim1.ej2;

import java.time.LocalDate;

public class Run {

    public static void main(String[] args) {
        Sucursal sucursal = new Sucursal("Correo Nueva Córdoba");

        Envio e1 = new Envio("E001", "Ana Gómez", LocalDate.of(2026, 10, 29), 3);
        Envio e2 = new Envio("E002", "Bruno Díaz", LocalDate.of(2026, 10, 31), 2);
        Envio e3 = new Envio("E003", "Carla Ruiz", LocalDate.of(2026, 11, 2), 5);

        sucursal.despachar(e1);
        sucursal.despachar(e2);
        sucursal.despachar(e3);

        sucursal.registrarReclamo(new Reclamo(e1, LocalDate.of(2026, 11, 2), "No llegó"));
        sucursal.registrarReclamo(new Reclamo(e3, LocalDate.of(2026, 11, 13), "Paquete dañado"));

        sucursal.listarEntregasDeLaSemana(LocalDate.of(2026, 11, 2));
    }

}

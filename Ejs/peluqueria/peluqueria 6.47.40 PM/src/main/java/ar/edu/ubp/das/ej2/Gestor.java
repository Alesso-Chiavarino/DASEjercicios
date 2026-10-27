package ar.edu.ubp.das.ej2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Gestor {

    private List<String> nombresClientes = new ArrayList<>();
    private List<String> telefonosClientes = new ArrayList<>();
    private List<String> nombresPeluqueros = new ArrayList<>();
    private List<String> especialidadesPeluqueros = new ArrayList<>();
    private List<String> fechas = new ArrayList<>();
    private List<String> horas = new ArrayList<>();
    private List<Double> montos = new ArrayList<>();
    private List<Boolean> turnosFinalizados = new ArrayList<>();

    public void registrarTurno(String nombreCliente,
                               String telefonoCliente,
                               String nombrePeluquero,
                               String especialidadPeluquero,
                               String fecha,
                               String hora,
                               double monto) {
        nombresClientes.add(nombreCliente);
        telefonosClientes.add(telefonoCliente);
        nombresPeluqueros.add(nombrePeluquero);
        especialidadesPeluqueros.add(especialidadPeluquero);
        fechas.add(fecha);
        horas.add(hora);
        montos.add(monto);
        turnosFinalizados.add(false);

        System.out.println("Turno registrado.");
    }

    public void actualizarTurno(String nombreCliente,
                                String telefonoCliente,
                                String nombrePeluquero,
                                String especialidadPeluquero,
                                String nuevaFecha,
                                String nuevaHora,
                                double nuevoMonto) {
        int indiceEncontrado = -1;

        for (int i = 0; i < nombresClientes.size(); i++) {
            if (nombresClientes.get(i).equals(nombreCliente)
                && telefonosClientes.get(i).equals(telefonoCliente)
                && nombresPeluqueros.get(i).equals(nombrePeluquero)
                && especialidadesPeluqueros.get(i).equals(especialidadPeluquero)) {
                indiceEncontrado = i;
                break;
            }
        }

        if (indiceEncontrado != -1) {
            if (turnosFinalizados.get(indiceEncontrado)) {
                System.out.println("El turno ya fue ejecutado y no puede actualizarse.");
                return;
            }
            fechas.set(indiceEncontrado, nuevaFecha);
            horas.set(indiceEncontrado, nuevaHora);
            montos.set(indiceEncontrado, nuevoMonto);
            System.out.println("Turno actualizado.");
        }
        else {
            registrarTurno(
                nombreCliente,
                telefonoCliente,
                nombrePeluquero,
                especialidadPeluquero,
                nuevaFecha,
                nuevaHora,
                nuevoMonto
            );
            System.out.println("No existía el turno. Se creó uno nuevo.");
        }
    }

    public void ejecutarTurno(String nombreCliente,
                              String telefonoCliente,
                              String nombrePeluquero,
                              String especialidadPeluquero) {
        int indiceEncontrado = -1;

        for (int i = 0; i < nombresClientes.size(); i++) {
            if (nombresClientes.get(i).equals(nombreCliente)
                    && telefonosClientes.get(i).equals(telefonoCliente)
                    && nombresPeluqueros.get(i).equals(nombrePeluquero)
                    && especialidadesPeluqueros.get(i).equals(especialidadPeluquero)) {
                indiceEncontrado = i;
                break;
            }
        }

        if (indiceEncontrado != -1) {
            turnosFinalizados.set(indiceEncontrado, true);
            System.out.println("Turno marcado como ejecutado.");
        }
        else {
            System.out.println("No se encontró el turno para ejecutar.");
        }
    }

    public void enviarNotificacion(String nombreCliente,
                                   String telefonoCliente,
                                   String nombrePeluquero,
                                   String especialidadPeluquero) {
        Notificador notificador = new Notificador();

        for (int i = 0; i < nombresClientes.size(); i++) {
            if (nombresClientes.get(i).equals(nombreCliente)
                && telefonosClientes.get(i).equals(telefonoCliente)
                && nombresPeluqueros.get(i).equals(nombrePeluquero)
                && especialidadesPeluqueros.get(i).equals(especialidadPeluquero)
                && !turnosFinalizados.get(i)) {
                notificador.enviarRecordatorio(
                    nombreCliente,
                    telefonoCliente,
                    nombrePeluquero,
                    especialidadPeluquero,
                    fechas.get(i),
                    horas.get(i)
                );
            }
        }
    }

    public void enviarEncuesta(String nombreCliente,
                               String telefonoCliente,
                               String nombrePeluquero,
                               String especialidadPeluquero) {
        Notificador notificador = new Notificador();
        LocalDate hoy = LocalDate.now();

        for (int i = 0; i < nombresClientes.size(); i++) {
            if (nombresClientes.get(i).equals(nombreCliente)
                && telefonosClientes.get(i).equals(telefonoCliente)
                && nombresPeluqueros.get(i).equals(nombrePeluquero)
                && especialidadesPeluqueros.get(i).equals(especialidadPeluquero)
                && turnosFinalizados.get(i)) {
                LocalDate fechaTurno = convertirFechaAReal(fechas.get(i));

                if ((fechaTurno != null && fechaTurno.isBefore(hoy)) || turnosFinalizados.get(i)) {
                    notificador.enviarEncuesta(
                        nombreCliente,
                        telefonoCliente,
                        nombrePeluquero,
                        especialidadPeluquero,
                        fechas.get(i),
                        horas.get(i)
                    );

                    turnosFinalizados.set(i, true);
                }
            }
        }
    }

    private LocalDate convertirFechaAReal(String fecha) {
        try {
            return LocalDate.parse(fecha); // asume formato YYYY-MM-DD
        }
        catch (Exception e) {
            return null;
        }
    }

}

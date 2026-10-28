package arg.edu.ubp.das.ej2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Gestor {

    private List<Turno> turnos = new ArrayList<>();

    private Integer buscarIndiceCliente(DatosEnvio datosEnvio) {
        int indiceEncontrado = -1;

        for (int i = 0; i < turnos.size(); i++) {
            DatosEnvio turnoIterado = turnos.get(i).getDatosEnvio();

            if (turnoIterado.getNombreCliente().equals(datosEnvio.getNombreCliente())
                    && turnoIterado.getTelefonoCliente().equals(datosEnvio.getTelefonoCliente())
                    && turnoIterado.getNombrePeluquero().equals(datosEnvio.getNombrePeluquero())
                    && turnoIterado.getEspecialidadPeluquero().equals(datosEnvio.getEspecialidadPeluquero())) {
                indiceEncontrado = i;
                break;
            }
        }

        return indiceEncontrado;
    }

    public void registrarTurno(Turno turno) {
        turno.setFinalizado(false);
        turnos.add(turno);

        System.out.println("Turno registrado.");
    }

    public void actualizarTurno(Turno nuevoTurno) {

        int indiceEncontrado = this.buscarIndiceCliente(nuevoTurno.getDatosEnvio());

        if (indiceEncontrado != -1) {
            Turno turno = turnos.get(indiceEncontrado);
            if (turno.getFinalizado()) {
                System.out.println("El turno ya fue ejecutado y no puede actualizarse.");
                return;
            }

            Turno turnoEncontrado = turnos.get(indiceEncontrado);
            turnoEncontrado.setFecha(nuevoTurno.getFecha());
            turnoEncontrado.setHora(nuevoTurno.getHora());
            turnoEncontrado.setMonto(nuevoTurno.getMonto());

            System.out.println("Turno actualizado.");
        }
        else {
            registrarTurno(nuevoTurno);
            System.out.println("No existía el turno. Se creó uno nuevo.");
        }
    }

    public void ejecutarTurno(DatosEnvio datosEnvio) {

        int indiceEncontrado = this.buscarIndiceCliente(datosEnvio);

        if (indiceEncontrado != -1) {
            Turno turno = turnos.get(indiceEncontrado);
            turno.setFinalizado(true);
            System.out.println("Turno marcado como ejecutado.");
        }
        else {
            System.out.println("No se encontró el turno para ejecutar.");
        }
    }

    public void enviarNotificacion(DatosEnvio datosEnvio) {
        Notificador notificador = new Notificador();

        for (int i = 0; i < turnos.size(); i++) {

            Turno turnoIterado = turnos.get(i);
            DatosEnvio turnoEnvioIterado = turnoIterado.getDatosEnvio();

            if (turnoIterado.getDatosEnvio().getNombreCliente().equals(datosEnvio.getNombreCliente())
                    && turnoEnvioIterado.getTelefonoCliente().equals(datosEnvio.getTelefonoCliente())
                    && turnoEnvioIterado.getNombrePeluquero().equals(datosEnvio.getNombrePeluquero())
                    && turnoEnvioIterado.getEspecialidadPeluquero().equals(datosEnvio.getEspecialidadPeluquero())
                    && !turnoIterado.getFinalizado()) {

                Turno turnoEnvio = new Turno();
                DatosEnvio datosEnvioFinalizado = new DatosEnvio();

                datosEnvioFinalizado.setNombreCliente(datosEnvio.getNombreCliente());
                datosEnvioFinalizado.setTelefonoCliente(datosEnvio.getTelefonoCliente());
                datosEnvioFinalizado.setNombrePeluquero(datosEnvio.getNombrePeluquero());
                datosEnvioFinalizado.setEspecialidadPeluquero(datosEnvio.getEspecialidadPeluquero());

                turnoEnvio.setDatosEnvio(datosEnvioFinalizado);
                turnoEnvio.setFecha(turnoIterado.getFecha());
                turnoEnvio.setHora(turnoIterado.getHora());
                turnoEnvio.setMonto(turnoIterado.getMonto());

                notificador.enviarRecordatorio(turnoEnvio);
            }
        }
    }

    public void enviarEncuesta(DatosEnvio datosEnvio) {
        Notificador notificador = new Notificador();
        LocalDate hoy = LocalDate.now();

        for (int i = 0; i < turnos.size(); i++) {
            Turno turnoIterado = turnos.get(i);
            DatosEnvio turnoEnvioIterado = turnoIterado.getDatosEnvio();

            if (turnoIterado.getDatosEnvio().getNombreCliente().equals(datosEnvio.getNombreCliente())
                    && turnoEnvioIterado.getTelefonoCliente().equals(datosEnvio.getTelefonoCliente())
                    && turnoEnvioIterado.getNombrePeluquero().equals(datosEnvio.getNombrePeluquero())
                    && turnoEnvioIterado.getEspecialidadPeluquero().equals(datosEnvio.getEspecialidadPeluquero())
                    && turnoIterado.getFinalizado()) {
                LocalDate fechaTurno = convertirFechaAReal(turnoIterado.getFecha());

                if ((fechaTurno != null && fechaTurno.isBefore(hoy)) || turnoIterado.getFinalizado()) {

                    Turno turnoEnvio = new Turno();
                    DatosEnvio datosEnvioFinalizado = new DatosEnvio();

                    datosEnvioFinalizado.setNombreCliente(datosEnvio.getNombreCliente());
                    datosEnvioFinalizado.setTelefonoCliente(datosEnvio.getTelefonoCliente());
                    datosEnvioFinalizado.setNombrePeluquero(datosEnvio.getNombrePeluquero());
                    datosEnvioFinalizado.setEspecialidadPeluquero(datosEnvio.getEspecialidadPeluquero());

                    turnoEnvio.setDatosEnvio(datosEnvioFinalizado);
                    turnoEnvio.setFecha(turnoIterado.getFecha());
                    turnoEnvio.setHora(turnoIterado.getHora());
                    turnoEnvio.setMonto(turnoIterado.getMonto());

                    turnoIterado.setFinalizado(true);
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

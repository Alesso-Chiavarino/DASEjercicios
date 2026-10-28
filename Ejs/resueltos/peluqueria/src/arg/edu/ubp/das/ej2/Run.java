package arg.edu.ubp.das.ej2;

public class Run {

    public static void main(String[] args) {
        Gestor gestor = new Gestor();

        gestor.registrarTurno(new Turno(
            new DatosEnvio("Carolina", "3516778899", "Marcelo", "Cortes"),
            "2025-11-11", "15:00",
            4500
        ));

        gestor.registrarTurno(new Turno(
            new DatosEnvio("Carolina", "3516778899", "Marcelo", "Cortes"),
            "2025-11-27", "16:30",
            5000
        ));

        gestor.registrarTurno(new Turno(
            new DatosEnvio("Juan", "3515332211", "Marcelo", "Cortes"),
            "2025-11-22", "10:00",
            4000
        ));

        gestor.actualizarTurno(new Turno(
            new DatosEnvio("Juan", "3515332211", "Marcelo", "Cortes"),
            "2025-11-25", "10:00",
            4000
        ));

        gestor.ejecutarTurno(
            new DatosEnvio("Carolina", "3516778899", "Marcelo", "Cortes")
        );

        gestor.enviarNotificacion(
            new DatosEnvio("Carolina", "3516778899", "Marcelo", "Cortes")
        );

        gestor.enviarEncuesta(
            new DatosEnvio("Carolina", "3516778899", "Marcelo", "Cortes")
        );
    }

}

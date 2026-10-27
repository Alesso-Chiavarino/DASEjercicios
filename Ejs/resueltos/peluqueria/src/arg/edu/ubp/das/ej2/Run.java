package arg.edu.ubp.das.ej2;

public class Run {

    public static void main(String[] args) {
        Gestor gestor = new Gestor();

        gestor.registrarTurno(
            "Carolina", "3516778899",
            "Marcelo", "Cortes",
            "2025-11-11", "15:00",
            4500
        );

        gestor.registrarTurno(
            "Carolina", "3516778899",
            "Marcelo", "Cortes",
            "2025-11-27", "16:30",
            5000
        );

        gestor.registrarTurno(
            "Juan", "3515332211",
            "Marcelo", "Cortes",
            "2025-11-22", "10:00",
            4000
        );

        // Actualizar uno de los turnos de Carolina con Marcelo
        gestor.actualizarTurno(
            "Juan", "3515332211",
            "Marcelo", "Cortes",
            "2025-11-25", "10:00",
            4000
        );

        // Marcar como ejecutado un turno de Carolina con Marcelo
        gestor.ejecutarTurno(
            "Carolina", "3516778899",
            "Marcelo", "Cortes"
        );

        // Enviar recordatorios para los turnos de Carolina con Marcelo
        gestor.enviarNotificacion(
            "Carolina", "3516778899",
            "Marcelo", "Cortes"
        );

        // Enviar encuestas para los turnos de Carolina con Marcelo
        gestor.enviarEncuesta(
            "Carolina", "3516778899",
            "Marcelo", "Cortes"
        );
    }

}

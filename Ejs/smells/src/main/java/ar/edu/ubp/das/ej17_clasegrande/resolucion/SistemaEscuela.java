package ar.edu.ubp.das.ej17_clasegrande.resolucion;

import java.util.LinkedHashMap;
import java.util.Map;

public class SistemaEscuela {

    private Map<String, Alumno> alumnos = new LinkedHashMap<>();
    private Calificaciones calificaciones = new Calificaciones();
    private Cobranzas cobranzas = new Cobranzas();
    private Mensajeria mensajeria = new Mensajeria();

    public void inscribir(Alumno alumno) {
        alumnos.put(alumno.getDni(), alumno);
        calificaciones.registrarAlumno(alumno.getDni());
        cobranzas.registrarAlumno(alumno.getDni());
        System.out.println("Inscripto: " + alumno.getNombre());
    }

    public void cargarNota(String dni, int nota) {
        calificaciones.cargarNota(dni, nota);
    }

    public void generarCuota(String dni) {
        cobranzas.generarCuota(dni);
    }

    public void registrarPago(String dni, double monto) {
        cobranzas.registrarPago(dni, monto);
    }

    public void enviarBoletin(String dni) {
        String estado = calificaciones.estaAprobado(dni) ? "APROBADO" : "DESAPROBADO";
        mensajeria.enviarMail(alumnos.get(dni), "Boletín",
                "Promedio: " + calificaciones.calcularPromedio(dni) + " - " + estado);
    }

    public void enviarAvisosDeDeuda() {
        for (String dni : alumnos.keySet()) {
            if (cobranzas.tieneDeuda(dni)) {
                mensajeria.enviarMail(alumnos.get(dni), "Aviso de deuda", "Adeuda $" + cobranzas.getDeuda(dni));
            }
        }
    }

    public void imprimirResumen() {
        System.out.println("Recaudado: $" + cobranzas.getRecaudado() + " - Mails enviados: " + mensajeria.getMailsEnviados());
    }

}

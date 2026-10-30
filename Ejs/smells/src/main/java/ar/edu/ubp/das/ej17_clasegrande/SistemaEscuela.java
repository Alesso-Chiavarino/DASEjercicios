package ar.edu.ubp.das.ej17_clasegrande;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SistemaEscuela {

    private Map<String, Alumno> alumnos = new LinkedHashMap<>();

    private Map<String, List<Integer>> notas = new LinkedHashMap<>();
    private int notaMinimaAprobacion = 6;

    private Map<String, Double> deudas = new LinkedHashMap<>();
    private double valorCuota = 45000;
    private double recaudado = 0;

    private String emailRemitente = "secretaria@escuela.edu.ar";
    private int mailsEnviados = 0;

    public void inscribir(Alumno alumno) {
        alumnos.put(alumno.getDni(), alumno);
        notas.put(alumno.getDni(), new ArrayList<>());
        deudas.put(alumno.getDni(), 0.0);
        System.out.println("Inscripto: " + alumno.getNombre());
    }

    public void cargarNota(String dni, int nota) {
        notas.get(dni).add(nota);
    }

    public double calcularPromedio(String dni) {
        List<Integer> notasAlumno = notas.get(dni);
        if (notasAlumno.isEmpty()) {
            return 0;
        }
        int suma = 0;
        for (int nota : notasAlumno) {
            suma += nota;
        }
        return (double) suma / notasAlumno.size();
    }

    public boolean estaAprobado(String dni) {
        return calcularPromedio(dni) >= notaMinimaAprobacion;
    }

    public void generarCuota(String dni) {
        deudas.put(dni, deudas.get(dni) + valorCuota);
    }

    public void registrarPago(String dni, double monto) {
        deudas.put(dni, deudas.get(dni) - monto);
        recaudado += monto;
    }

    public boolean tieneDeuda(String dni) {
        return deudas.get(dni) > 0;
    }

    public void enviarMail(String dni, String asunto, String cuerpo) {
        Alumno alumno = alumnos.get(dni);
        mailsEnviados++;
        System.out.println("De: " + emailRemitente + " | Para: " + alumno.getEmail() + " | " + asunto);
        System.out.println("  " + cuerpo);
    }

    public void enviarBoletin(String dni) {
        String estado = estaAprobado(dni) ? "APROBADO" : "DESAPROBADO";
        enviarMail(dni, "Boletín", "Promedio: " + calcularPromedio(dni) + " - " + estado);
    }

    public void enviarAvisosDeDeuda() {
        for (String dni : alumnos.keySet()) {
            if (tieneDeuda(dni)) {
                enviarMail(dni, "Aviso de deuda", "Adeuda $" + deudas.get(dni));
            }
        }
    }

    public void imprimirResumen() {
        System.out.println("Recaudado: $" + recaudado + " - Mails enviados: " + mailsEnviados);
    }

}

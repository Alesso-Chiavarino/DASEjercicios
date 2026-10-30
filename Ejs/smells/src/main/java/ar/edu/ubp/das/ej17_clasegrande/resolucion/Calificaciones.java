package ar.edu.ubp.das.ej17_clasegrande.resolucion;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Calificaciones {

    private Map<String, List<Integer>> notas = new LinkedHashMap<>();
    private int notaMinimaAprobacion = 6;

    public void registrarAlumno(String dni) {
        notas.put(dni, new ArrayList<>());
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

}

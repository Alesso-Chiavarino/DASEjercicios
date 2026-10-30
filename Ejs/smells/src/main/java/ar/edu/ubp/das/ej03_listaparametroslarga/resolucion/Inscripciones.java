package ar.edu.ubp.das.ej03_listaparametroslarga.resolucion;

import java.time.LocalDate;
import java.util.Map;

public class Inscripciones {

    //Supongamos la siguiente fuente de datos (dni -> porcentaje de beca)
    private final Map<String, Double> becas = Map.of(
        "40111222", 50.0,
        "38999000", 25.0
    );

    public double obtenerPorcentajeBeca(String dni) {
        return becas.getOrDefault(dni, 0.0);
    }

    public void inscribir(Alumno alumno, String curso, LocalDate inicio, double arancel) {
        double porcentajeBeca = obtenerPorcentajeBeca(alumno.getDni());
        double aPagar = arancel - arancel * porcentajeBeca / 100;
        System.out.println("Inscripción de " + alumno.getApellido() + ", " + alumno.getNombre() + " (DNI " + alumno.getDni() + ")");
        System.out.println("  Curso: " + curso + " - inicia el " + inicio.getDayOfMonth() + "/" + inicio.getMonthValue() + "/" + inicio.getYear());
        System.out.println("  Arancel: $" + arancel + " - Beca: " + porcentajeBeca + "% - A pagar: $" + aPagar);
    }

}

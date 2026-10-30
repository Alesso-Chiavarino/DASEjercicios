package ar.edu.ubp.das.ej03_listaparametroslarga;

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

    public void inscribir(String nombre, String apellido, String dni, String curso,
                          int dia, int mes, int anio, double arancel, double porcentajeBeca) {
        double aPagar = arancel - arancel * porcentajeBeca / 100;
        System.out.println("Inscripción de " + apellido + ", " + nombre + " (DNI " + dni + ")");
        System.out.println("  Curso: " + curso + " - inicia el " + dia + "/" + mes + "/" + anio);
        System.out.println("  Arancel: $" + arancel + " - Beca: " + porcentajeBeca + "% - A pagar: $" + aPagar);
    }

}

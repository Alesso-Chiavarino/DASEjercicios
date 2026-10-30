package ar.edu.ubp.das.ej03_listaparametroslarga.resolucion;

import java.time.LocalDate;

public class Run {

    public static void main(String[] args) {
        Inscripciones inscripciones = new Inscripciones();

        Alumno juan = new Alumno("Juan", "Pérez", "40111222");
        Alumno sofia = new Alumno("Sofía", "Ruiz", "41555666");
        Alumno marcos = new Alumno("Marcos", "Díaz", "38999000");

        inscripciones.inscribir(juan, "Java Inicial", LocalDate.of(2025, 3, 3), 80000);
        inscripciones.inscribir(sofia, "Java Inicial", LocalDate.of(2025, 3, 3), 80000);
        inscripciones.inscribir(marcos, "Bases de Datos", LocalDate.of(2025, 4, 10), 95000);
    }

}

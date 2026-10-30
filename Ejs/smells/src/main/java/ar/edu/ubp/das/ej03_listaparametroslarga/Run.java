package ar.edu.ubp.das.ej03_listaparametroslarga;

public class Run {

    public static void main(String[] args) {
        Inscripciones inscripciones = new Inscripciones();

        Alumno juan = new Alumno("Juan", "Pérez", "40111222");
        Alumno sofia = new Alumno("Sofía", "Ruiz", "41555666");
        Alumno marcos = new Alumno("Marcos", "Díaz", "38999000");

        inscripciones.inscribir(juan.getNombre(), juan.getApellido(), juan.getDni(),
                "Java Inicial", 3, 3, 2025, 80000, inscripciones.obtenerPorcentajeBeca(juan.getDni()));

        inscripciones.inscribir(sofia.getNombre(), sofia.getApellido(), sofia.getDni(),
                "Java Inicial", 3, 3, 2025, 80000, inscripciones.obtenerPorcentajeBeca(sofia.getDni()));

        inscripciones.inscribir(marcos.getNombre(), marcos.getApellido(), marcos.getDni(),
                "Bases de Datos", 10, 4, 2025, 95000, inscripciones.obtenerPorcentajeBeca(marcos.getDni()));
    }

}

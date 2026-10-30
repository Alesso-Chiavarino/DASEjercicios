package ar.edu.ubp.das.ej10_codigomuerto;

public class Run {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregar(new Libro("Rayuela", "Cortázar"));
        biblioteca.agregar(new Libro("Ficciones", "Borges"));

        biblioteca.prestar("Rayuela", "Juan", true);
        biblioteca.prestar("Rayuela", "María", false);
        biblioteca.prestar("El Aleph", "María", false);
        biblioteca.prestar("Ficciones", "María", true);

        biblioteca.devolver("Rayuela", 0);
        biblioteca.devolver("Ficciones", 4);
    }

}

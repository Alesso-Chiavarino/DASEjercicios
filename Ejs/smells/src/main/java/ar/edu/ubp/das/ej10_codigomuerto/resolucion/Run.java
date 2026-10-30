package ar.edu.ubp.das.ej10_codigomuerto.resolucion;

public class Run {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregar(new Libro("Rayuela"));
        biblioteca.agregar(new Libro("Ficciones"));

        biblioteca.prestar("Rayuela", "Juan");
        biblioteca.prestar("Rayuela", "María");
        biblioteca.prestar("El Aleph", "María");
        biblioteca.prestar("Ficciones", "María");

        biblioteca.devolver("Rayuela", 0);
        biblioteca.devolver("Ficciones", 4);
    }

}

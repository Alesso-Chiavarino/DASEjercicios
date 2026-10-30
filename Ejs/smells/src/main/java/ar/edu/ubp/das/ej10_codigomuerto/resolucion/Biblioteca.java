package ar.edu.ubp.das.ej10_codigomuerto.resolucion;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Libro> libros = new ArrayList<>();

    public void agregar(Libro libro) {
        libros.add(libro);
    }

    public void prestar(String titulo, String socio) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                if (libro.isPrestado()) {
                    System.out.println(titulo + " ya está prestado");
                    return;
                }
                libro.setPrestado(true);
                System.out.println(titulo + " prestado a " + socio);
                return;
            }
        }
        System.out.println("No existe el libro " + titulo);
    }

    public void devolver(String titulo, int diasAtraso) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                libro.setPrestado(false);
                System.out.println(titulo + " devuelto. Multa: $" + calcularMulta(diasAtraso));
            }
        }
    }

    public double calcularMulta(int diasAtraso) {
        if (diasAtraso <= 0) {
            return 0;
        }
        return diasAtraso * 500;
    }

}

package ar.edu.ubp.das.ej10_codigomuerto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Biblioteca {

    private List<Libro> libros = new ArrayList<>();
    private String ultimoSocio;

    public void agregar(Libro libro) {
        libros.add(libro);
    }

    public void prestar(String titulo, String socio, boolean notificarPorMail) {
        ultimoSocio = socio;
        int intentos = 0;
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
        if (diasAtraso > 30 && diasAtraso < 10) {
            return diasAtraso * 1000;
        }
        return diasAtraso * 500;
    }

    public double calcularMultaVieja(int diasAtraso) {
        return diasAtraso * 300;
    }

}

package ar.edu.ubp.das.ej08_intermediario.resolucion;

public class Liquidacion {

    public double calcularHonorarios(Profesor profesor, double valorHora) {
        double honorarios = profesor.getHorasSemanales() * 4 * valorHora;
        System.out.println("Honorarios de " + profesor.getNombre() + ": $" + honorarios
                + " (aviso enviado a " + profesor.getEmail() + ")");
        return honorarios;
    }

}

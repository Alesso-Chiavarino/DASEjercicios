package ar.edu.ubp.das.ej08_intermediario;

public class Liquidacion {

    public double calcularHonorarios(GestorProfesor gestor, double valorHora) {
        double honorarios = gestor.obtenerHorasSemanales() * 4 * valorHora;
        System.out.println("Honorarios de " + gestor.obtenerNombre() + ": $" + honorarios
                + " (aviso enviado a " + gestor.obtenerEmail() + ")");
        return honorarios;
    }

}

package ar.edu.ubp.das.ej08_intermediario.resolucion;

public class Run {

    public static void main(String[] args) {
        Liquidacion liquidacion = new Liquidacion();

        Profesor lucia = new Profesor("Lucía Fernández", "lucia@ubp.edu.ar", 12);
        Profesor raul = new Profesor("Raúl Medina", "rmedina@ubp.edu.ar", 8);

        System.out.println("Profesor: " + lucia.getNombre() + " - " + lucia.getEmail());
        System.out.println("Profesor: " + raul.getNombre() + " - " + raul.getEmail());

        raul.setEmail("raul.medina@ubp.edu.ar");

        liquidacion.calcularHonorarios(lucia, 9500);
        liquidacion.calcularHonorarios(raul, 11000);
    }

}

package ar.edu.ubp.das.ej08_intermediario;

public class Run {

    public static void main(String[] args) {
        Liquidacion liquidacion = new Liquidacion();

        GestorProfesor gestorLucia = new GestorProfesor(new Profesor("Lucía Fernández", "lucia@ubp.edu.ar", 12));
        GestorProfesor gestorRaul = new GestorProfesor(new Profesor("Raúl Medina", "rmedina@ubp.edu.ar", 8));

        System.out.println("Profesor: " + gestorLucia.obtenerNombre() + " - " + gestorLucia.obtenerEmail());
        System.out.println("Profesor: " + gestorRaul.obtenerNombre() + " - " + gestorRaul.obtenerEmail());

        gestorRaul.actualizarEmail("raul.medina@ubp.edu.ar");

        liquidacion.calcularHonorarios(gestorLucia, 9500);
        liquidacion.calcularHonorarios(gestorRaul, 11000);
    }

}

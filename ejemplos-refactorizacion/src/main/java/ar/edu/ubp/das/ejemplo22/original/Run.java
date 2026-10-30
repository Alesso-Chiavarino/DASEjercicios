package ar.edu.ubp.das.ejemplo22.original;

public class Run {

    public static void main(String[] args) {
        Empleado empleado = new Empleado("ATAHUALPA MAS", 500, 160, 8, true);
        CalculadorNomina calculador = new CalculadorNomina();
        calculador.calcular(empleado);
    }

}

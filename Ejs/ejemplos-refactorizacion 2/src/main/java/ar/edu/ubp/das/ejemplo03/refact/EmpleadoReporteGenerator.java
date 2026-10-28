package ar.edu.ubp.das.ejemplo03.refact;

public class EmpleadoReporteGenerator {

    public String generarInforme(Empleado empleado) {
        return "Empleado: " + empleado.getNombre() + "\nSalario Total: " + (empleado.calcularSalarioTotal());
    }

}

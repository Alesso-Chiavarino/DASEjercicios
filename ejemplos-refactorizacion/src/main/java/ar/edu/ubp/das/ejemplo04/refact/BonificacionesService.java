package ar.edu.ubp.das.ejemplo04.refact;

public class BonificacionesService {

    public double calcularBonificacion(Empleado empleado) {
        return empleado.getSalario() * 0.05 * empleado.getAñosTrabajados();
    }

}

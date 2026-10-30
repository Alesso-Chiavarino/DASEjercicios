package ar.edu.ubp.das.ejemplo04.refact;

public class VacacionesService {

    public int calcularDiasVacaciones(Empleado empleado) {
        return empleado.getAñosTrabajados() * 2;
    }

}

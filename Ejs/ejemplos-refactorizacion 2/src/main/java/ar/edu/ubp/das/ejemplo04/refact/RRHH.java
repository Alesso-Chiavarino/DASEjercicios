package ar.edu.ubp.das.ejemplo04.refact;

import java.util.ArrayList;
import java.util.List;

public class RRHH {

    private List<Empleado> empleados;

    private BonificacionesService bonificacionesService;
    private VacacionesService vacacionesService;
    private RegistroService registroService;

    public RRHH() {
        this.empleados = new ArrayList<>();
        this.bonificacionesService = new BonificacionesService();
        this.vacacionesService = new VacacionesService();
        this.registroService = new RegistroService();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void calcularBonificaciones() {
        for (Empleado empleado : empleados) {
            double bonificacion = bonificacionesService.calcularBonificacion(empleado);
            System.out.println("Bonificación para " + empleado.getNombre() + ": " + bonificacion);
        }
    }

    public void calcularDiasVacaciones() {
        for (Empleado empleado : empleados) {
            int diasVacaciones = vacacionesService.calcularDiasVacaciones(empleado);
            System.out.println("Días de vacaciones para " + empleado.getNombre() + ": " + diasVacaciones);
        }
    }

    public void registrarPromocion(Empleado empleado, double nuevoSalario) {
        registroService.registrarPromocion(empleado, nuevoSalario);
    }

    public void registrarAumento(Empleado empleado, double nuevoSalario) {
        registroService.registrarAumento(empleado, nuevoSalario);
    }

}

package ar.edu.ubp.das.ejemplo04.original;

import java.util.ArrayList;
import java.util.List;

// SMELL: Shotgun Surgery — un cambio en una regla (ej. bonificación al 7%) obliga a tocar Empleado y RRHH.
// SMELL: Duplicated Code — mismas fórmulas que en Empleado.
// SMELL: lógica de registro partida (registrarAumento en Empleado, registrarPromocion acá).
public class RRHH {

    private List<Empleado> empleados;

    public RRHH() {
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void calcularBonificaciones() {
        for (Empleado empleado : empleados) {
            // SMELL: Duplicated Code — misma fórmula que Empleado.calcularBonificacion().
            double bonificacion = empleado.getSalario() * 0.05 * empleado.getAñosTrabajados();
            System.out.println("Bonificación para " + empleado.getNombre() + ": " + bonificacion);
        }
    }

    public void calcularDiasVacaciones() {
        for (Empleado empleado : empleados) {
            // SMELL: Duplicated Code — misma fórmula que Empleado.calcularDiasVacaciones().
            int diasVacaciones = empleado.getAñosTrabajados() * 2;
            System.out.println("Días de vacaciones para " + empleado.getNombre() + ": " + diasVacaciones);
        }
    }

    public void registrarPromocion(Empleado empleado, double nuevoSalario) {
        System.out.println("El salario de " + empleado.getNombre() + " ha sido ajustado a " + nuevoSalario);
    }

    public void registrarAumento(Empleado empleado, double nuevoSalario) {
        empleado.registrarAumento(nuevoSalario);
    }

}


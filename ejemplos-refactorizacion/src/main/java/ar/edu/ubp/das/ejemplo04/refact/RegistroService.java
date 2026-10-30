package ar.edu.ubp.das.ejemplo04.refact;

public class RegistroService {

    public void registrarAumento(Empleado empleado, double nuevoSalario) {
        System.out.println("Empleado " + empleado.getNombre() + " ha recibido un aumento. Nuevo salario: " + nuevoSalario);
    }

    public void registrarPromocion(Empleado empleado, double nuevoSalario) {
        System.out.println("El salario de " + empleado.getNombre() + " ha sido ajustado a " + nuevoSalario);
    }

}

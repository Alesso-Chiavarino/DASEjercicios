package ar.edu.ubp.das.ejemplo04.original;

public class Run {

    public static void main(String[] args) {
        RRHH rrhh = new RRHH();

        Empleado empleado1 = new Empleado("ATAHUALPA MAS", 50000, 5);
        Empleado empleado2 = new Empleado("TUPAC DUPLO", 60000, 3);

        rrhh.agregarEmpleado(empleado1);
        rrhh.agregarEmpleado(empleado2);

        rrhh.calcularBonificaciones();
        rrhh.calcularDiasVacaciones();

        rrhh.registrarPromocion(empleado1, 55000);
        rrhh.registrarAumento(empleado2, 62000);
    }

}

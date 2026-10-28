package ar.edu.ubp.das.ejemplo04.refact;

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

        // Refactorización aplicada: "Extract Class" (Extraer Clase): tanto la clase
        // Empleado como la clase RRHH manejaban la lógica para calcular
        // bonificaciones, días de vacaciones y registrar acciones (promociones,
        // aumentos, etc.). Estas responsabilidades estaban dispersas y duplicadas
        // entre ambas clases.
        // Se crearon las clases BonificacionesService, VacacionesService y
        // RegistroService, que se encargan de manejar sus respectivas responsabilidades.
    }

}

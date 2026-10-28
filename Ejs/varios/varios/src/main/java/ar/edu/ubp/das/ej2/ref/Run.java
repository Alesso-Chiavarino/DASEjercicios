package ar.edu.ubp.das.ej2.ref;

public class Run {

    public static void main(String[] args) {
        Empleado empleadoEfectivo = new EmpleadoEfectivo("ATUAHUALPA MAS", 500000);
        Empleado empleadoContratado = new EmpleadoContratado("CEFERINO TUPAC", 120, 5000);

        System.out.println("Empleado: " + empleadoEfectivo.getNombre() + ", Pago: $" + empleadoEfectivo.calcularPago());
        System.out.println("Empleado: " + empleadoContratado.getNombre() + ", Pago: $" + empleadoContratado.calcularPago());
    }

}

package ar.edu.ubp.das.ej2.ori;

public class Run {

    public static void main(String[] args) {
        Empleado empleadoEfectivo = new Empleado("ATUAHUALPA MAS", "Efectivo", 500000);
        Empleado empleadoContratado = new Empleado("CEFERINO TUPAC", "Contratado", 120, 5000);

        System.out.println("Empleado: " + empleadoEfectivo.getNombre() + ", Pago: $" + empleadoEfectivo.calcularPago());
        System.out.println("Empleado: " + empleadoContratado.getNombre() + ", Pago: $" + empleadoContratado.calcularPago());
    }

}

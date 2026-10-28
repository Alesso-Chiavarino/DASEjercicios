package ar.edu.ubp.das.ejemplo11.original;
public class Run {

    public static void main(String[] args) {
        Empleado empleadoTiempoCompleto = new EmpleadoTiempoCompleto("ATAHUALPA MAS");
        Empleado empleadoMedioTiempo = new EmpleadoTiempoParcial("TUPAC DUPLO");

        System.out.println("Pago de empleado tiempo completo: " + empleadoTiempoCompleto.calcularPago());
        System.out.println("Pago de empleado medio tiempo: " + empleadoMedioTiempo.calcularPago());

        EstrategiaPago pagoTiempoCompleto = new PagoTiempoCompleto();
        EstrategiaPago pagoTiempoParcial = new PagoTiempoParcial();

        System.out.println("Pago de empleado tiempo completo: " + pagoTiempoCompleto.calcular());
        System.out.println("Pago de empleado medio tiempo: " + pagoTiempoParcial.calcular());
    }

}

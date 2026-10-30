package ar.edu.ubp.das.ej22_clasesalternativas;

public class Run {

    public static void main(String[] args) {
        Caja caja = new Caja();

        caja.cobrarEnEfectivo(new PagoEfectivo(), 5400);
        caja.cobrarConTarjeta(new PagoTarjeta("Gabriela Molina", 1), 12000);
        caja.cobrarConTarjeta(new PagoTarjeta("Pablo Ortiz", 6), 30000);
        caja.cobrarConMercadoPago(new PagoMercadoPago(), "pablo.ortiz.mp", 8700);

        caja.cerrar();
    }

}

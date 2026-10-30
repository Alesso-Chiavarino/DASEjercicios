package ar.edu.ubp.das.ej22_clasesalternativas.resolucion;

public class Run {

    public static void main(String[] args) {
        Caja caja = new Caja();

        caja.cobrar(new PagoEfectivo(), 5400);
        caja.cobrar(new PagoTarjeta("Gabriela Molina", 1), 12000);
        caja.cobrar(new PagoTarjeta("Pablo Ortiz", 6), 30000);
        caja.cobrar(new PagoMercadoPago("pablo.ortiz.mp"), 8700);

        caja.cerrar();
    }

}

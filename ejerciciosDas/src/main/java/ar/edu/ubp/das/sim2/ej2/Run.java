package ar.edu.ubp.das.sim2.ej2;

public class Run {

    public static void main(String[] args) {
        Banco banco = new Banco("Banco de Córdoba");

        CuentaCorriente corriente = new CuentaCorriente("Ferretería El Tornillo", 20000);
        CajaDeAhorro caja = new CajaDeAhorro("Ana Gómez", 0.02);

        banco.abrirCuenta(corriente);
        banco.abrirCuenta(caja);

        corriente.depositar(50000);
        corriente.emitirCheque("Proveedor Bulonera SA", 60000);
        corriente.emitirCheque("Luz y Fuerza", 15000);

        caja.depositar(100000);
        caja.extraer(30000);
        boolean pudoExtraer = caja.extraer(80000);
        System.out.println("¿Ana pudo extraer $80000? " + pudoExtraer);

        banco.cierreDeMes();
        banco.imprimirCuentas();
    }

}

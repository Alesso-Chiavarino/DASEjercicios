package ar.edu.ubp.das.ej1.ori;

public class Run {

    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("ATAHUALPA MAS", 200000);
        CuentaBancaria cuenta2 = new CuentaBancaria("CEFERINO TUPAC", 10000);

        Transferencia.realizarTransferencia(cuenta1, cuenta2, 50000);

        Transferencia.imprimirDetallesTitular(cuenta1);
        Transferencia.imprimirDetallesTitular(cuenta2);
    }

}

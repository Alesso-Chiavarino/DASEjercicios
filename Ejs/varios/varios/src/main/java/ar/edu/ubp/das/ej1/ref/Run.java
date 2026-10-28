package ar.edu.ubp.das.ej1.ref;

public class Run {

    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("ATAHUALPA MAS", 200000);
        CuentaBancaria cuenta2 = new CuentaBancaria("CEFERINO TUPAC", 10000);

        cuenta1.realizarTransferencia(cuenta2, 50000);

        cuenta1.imprimirDetallesTitular();
        cuenta2.imprimirDetallesTitular();
    }

}

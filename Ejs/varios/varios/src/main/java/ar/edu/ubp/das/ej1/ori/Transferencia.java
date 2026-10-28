package ar.edu.ubp.das.ej1.ori;

public class Transferencia {

    public static void realizarTransferencia(CuentaBancaria cuentaOrigen, CuentaBancaria cuentaDestino, double monto) {
        if (cuentaOrigen.saldo >= monto) {
            cuentaOrigen.saldo -= monto;
            cuentaDestino.saldo += monto;
            System.out.println("Transferencia realizada de: " + cuentaOrigen.nombreTitular +
                    " a " + cuentaDestino.nombreTitular + " por $" + monto);
        } else {
            System.out.println("Fondos insuficientes en la cuenta de: " + cuentaOrigen.nombreTitular);
        }
    }

    public static void imprimirDetallesTitular(CuentaBancaria cuenta) {
        System.out.println("Detalles de la cuenta:");
        System.out.println("Nombre: " + cuenta.nombreTitular);
        System.out.println("Saldo: " + cuenta.saldo);
    }

}

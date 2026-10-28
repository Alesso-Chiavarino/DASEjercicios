package ar.edu.ubp.das.ej1.ref;

public class CuentaBancaria {

    private String nombreTitular;
    private double saldo;

    public CuentaBancaria(String nombreTitular, double saldo) {
        this.nombreTitular = nombreTitular;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void acreditarSaldo(double saldo) {
        this.saldo += saldo;
    }

    public void restarSaldo(double saldo) {
        this.saldo -= saldo;
    }

    public void imprimirDetallesTitular() {
        System.out.println("Detalles de la cuenta:");
        System.out.println("Nombre: " + this.getNombreTitular());
        System.out.println("Saldo: " + this.getSaldo());
    }

    public void realizarTransferencia(CuentaBancaria cuentaDestino, double monto) {
        if (this.getSaldo() >= monto) {
            this.restarSaldo(monto);
            cuentaDestino.acreditarSaldo(monto);
            System.out.println("Transferencia realizada de: " + this.getNombreTitular() +
                    " a " + cuentaDestino.getNombreTitular() + " por $" + monto);
        } else {
            System.out.println("Fondos insuficientes en la cuenta de: " + this.getNombreTitular());
        }
    }



}

package ar.edu.ubp.das.ejemplo05.refact;

public class CuentaBancaria {

    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito realizado. Nuevo saldo: " + saldo);
        }
        else {
            System.out.println("Cantidad de depósito inválida.");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro realizado. Nuevo saldo: " + saldo);
        }
        else {
            System.out.println("Fondos insuficientes o cantidad inválida.");
        }
    }

    public void consultarSaldo() {
        System.out.println("El saldo actual de la cuenta es: " + saldo);
    }

}


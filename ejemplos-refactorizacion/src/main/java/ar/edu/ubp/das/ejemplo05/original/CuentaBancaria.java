package ar.edu.ubp.das.ejemplo05.original;

// SMELL: Data Class — solo tiene getters/setters, sin reglas propias (depositar/retirar).
// SMELL: setSaldo() público rompe el encapsulamiento: permite setear saldos negativos sin validación.
// Refactor sugerida: Move Method (traer la lógica) + Encapsulate Field (quitar los setters).
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

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // SMELL: setter público permite estados inválidos (saldos negativos) sin validación.
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void consultarSaldo() {
        System.out.println("El saldo actual de la cuenta es: " + saldo);
    }

}

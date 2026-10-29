package ar.edu.ubp.das.sim2.ej2;

public class CuentaCorriente {

    protected String titular;
    protected double saldo;
    protected double limiteDescubierto;
    protected int chequesEmitidos;

    public CuentaCorriente(String titular, double limiteDescubierto) {
        this.titular = titular;
        this.saldo = 0;
        this.limiteDescubierto = limiteDescubierto;
        this.chequesEmitidos = 0;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public boolean extraer(double monto) {
        if (saldo + limiteDescubierto >= monto) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public void emitirCheque(String beneficiario, double monto) {
        if (extraer(monto)) {
            chequesEmitidos++;
            System.out.println("Cheque N°" + chequesEmitidos + " de " + titular + " a " + beneficiario + " por $" + monto);
        }
        else {
            System.out.println("Cheque rechazado a " + titular + ": fondos insuficientes");
        }
    }

    public double calcularMantenimiento() {
        return 3500 + chequesEmitidos * 200;
    }

    public String resumen() {
        return titular + " | Saldo: $" + saldo + " | Descubierto: $" + limiteDescubierto
                + " | Cheques emitidos: " + chequesEmitidos;
    }

}

package ar.edu.ubp.das.sim2.ej2;

public class CajaDeAhorro extends CuentaCorriente {

    private double tasaInteresMensual;

    public CajaDeAhorro(String titular, double tasaInteresMensual) {
        super(titular, 0);
        this.tasaInteresMensual = tasaInteresMensual;
    }

    @Override
    public void emitirCheque(String beneficiario, double monto) {
        throw new UnsupportedOperationException("Una caja de ahorro no puede emitir cheques");
    }

    @Override
    public double calcularMantenimiento() {
        return 0;
    }

    public void acreditarIntereses() {
        saldo += saldo * tasaInteresMensual;
    }

    @Override
    public String resumen() {
        return titular + " | Saldo: $" + saldo + " | Tasa mensual: " + (tasaInteresMensual * 100) + "%";
    }

}

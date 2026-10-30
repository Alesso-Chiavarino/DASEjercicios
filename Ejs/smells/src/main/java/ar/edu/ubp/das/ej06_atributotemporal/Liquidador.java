package ar.edu.ubp.das.ej06_atributotemporal;

public class Liquidador {

    private Integer horasExtraTemporales = null;
    private Double valorHoraExtraTemporal = null;
    private String motivoBonoTemporal = null;
    private Double montoBonoTemporal = null;

    public void prepararHorasExtra(int horas, double valorHora) {
        this.horasExtraTemporales = horas;
        this.valorHoraExtraTemporal = valorHora;
    }

    public void prepararBono(String motivo, double monto) {
        this.motivoBonoTemporal = motivo;
        this.montoBonoTemporal = monto;
    }

    public void limpiar() {
        this.horasExtraTemporales = null;
        this.valorHoraExtraTemporal = null;
        this.motivoBonoTemporal = null;
        this.montoBonoTemporal = null;
    }

    public double liquidar(Empleado empleado) {
        double total = empleado.getSueldoBasico();
        if (horasExtraTemporales != null) {
            double extras = horasExtraTemporales * valorHoraExtraTemporal;
            System.out.println("  Horas extra: " + horasExtraTemporales + " x $" + valorHoraExtraTemporal + " = $" + extras);
            total += extras;
        }
        if (montoBonoTemporal != null) {
            System.out.println("  Bono por " + motivoBonoTemporal + ": $" + montoBonoTemporal);
            total += montoBonoTemporal;
        }
        System.out.println("Liquidación de " + empleado.getNombre() + ": $" + total);
        return total;
    }

}

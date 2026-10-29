package ar.edu.ubp.das.sim3.ej2;

public class PolizaAuto extends Poliza {

    private Auto auto;

    public PolizaAuto(int numero, Auto auto) {
        super(numero);
        this.auto = auto;
    }

    @Override
    public double calcularPrima() {
        double prima = auto.getValor() * 0.03;
        if (auto.isTieneGnc()) {
            prima += 18000;
        }
        return prima;
    }

    @Override
    public String descripcion() {
        return "Auto " + auto.getPatente() + (auto.isTieneGnc() ? " (con GNC)" : "");
    }

}

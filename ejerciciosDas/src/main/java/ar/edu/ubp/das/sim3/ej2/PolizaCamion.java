package ar.edu.ubp.das.sim3.ej2;

public class PolizaCamion extends Poliza {

    private Camion camion;

    public PolizaCamion(int numero, Camion camion) {
        super(numero);
        this.camion = camion;
    }

    @Override
    public double calcularPrima() {
        return camion.getValor() * 0.025 + camion.getToneladas() * 9000;
    }

    @Override
    public String descripcion() {
        return "Camión " + camion.getPatente() + " de " + camion.getToneladas() + " t";
    }

}

package ar.edu.ubp.das.sim3.ej2;

public class PolizaMoto extends Poliza {

    private Moto moto;

    public PolizaMoto(int numero, Moto moto) {
        super(numero);
        this.moto = moto;
    }

    @Override
    public double calcularPrima() {
        double prima = moto.getValor() * 0.05;
        if (moto.getCilindrada() > 250) {
            prima += 12000;
        }
        return prima;
    }

    @Override
    public String descripcion() {
        return "Moto " + moto.getPatente() + " " + moto.getCilindrada() + "cc";
    }

}

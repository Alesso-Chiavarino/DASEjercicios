package ar.edu.ubp.das.ej01_codigoduplicado;

public class SocioPremium extends Socio {

    public SocioPremium(String nombre, int mesesAdeudados) {
        super(nombre, mesesAdeudados);
    }

    @Override
    public double getCuotaBase() {
        return 25000;
    }

    public void imprimirCarnet() {
        System.out.println("------------------------------");
        System.out.println("Socio: " + getNombre());
        System.out.println("Cuota base: $" + getCuotaBase());
        System.out.println("------------------------------");
    }

}

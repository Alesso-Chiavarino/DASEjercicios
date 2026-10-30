package ar.edu.ubp.das.ej01_codigoduplicado.resolucion;

public class SocioPremium extends Socio {

    public SocioPremium(String nombre, int mesesAdeudados) {
        super(nombre, mesesAdeudados);
    }

    @Override
    public double getCuotaBase() {
        return 25000;
    }

}

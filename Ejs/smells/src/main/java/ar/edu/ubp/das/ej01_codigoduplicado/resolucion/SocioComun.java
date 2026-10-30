package ar.edu.ubp.das.ej01_codigoduplicado.resolucion;

public class SocioComun extends Socio {

    public SocioComun(String nombre, int mesesAdeudados) {
        super(nombre, mesesAdeudados);
    }

    @Override
    public double getCuotaBase() {
        return 15000;
    }

}

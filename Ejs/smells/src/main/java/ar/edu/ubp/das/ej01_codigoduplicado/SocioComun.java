package ar.edu.ubp.das.ej01_codigoduplicado;

public class SocioComun extends Socio {

    public SocioComun(String nombre, int mesesAdeudados) {
        super(nombre, mesesAdeudados);
    }

    @Override
    public double getCuotaBase() {
        return 15000;
    }

    public void imprimirCarnet() {
        System.out.println("------------------------------");
        System.out.println("Socio: " + getNombre());
        System.out.println("Cuota base: $" + getCuotaBase());
        System.out.println("------------------------------");
    }

}

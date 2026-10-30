package ar.edu.ubp.das.ej01_codigoduplicado;

public abstract class Socio {

    private String nombre;
    private int mesesAdeudados;

    public Socio(String nombre, int mesesAdeudados) {
        this.nombre = nombre;
        this.mesesAdeudados = mesesAdeudados;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMesesAdeudados() {
        return mesesAdeudados;
    }

    public abstract double getCuotaBase();

    public void imprimirCarnet() {
        System.out.println("------------------------------");
        System.out.println("Socio: " + getNombre());
        System.out.println("Cuota base: $" + getCuotaBase());
        System.out.println("------------------------------");
    }

}

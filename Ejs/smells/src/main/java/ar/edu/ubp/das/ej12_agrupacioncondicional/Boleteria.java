package ar.edu.ubp.das.ej12_agrupacioncondicional;

public class Boleteria {

    private double precioBase;

    public Boleteria(double precioBase) {
        this.precioBase = precioBase;
    }

    public void vender(Entrada entrada) {
        System.out.println(entrada.getPelicula() + " - " + entrada.getTipo()
                + " - $" + entrada.calcularPrecio(precioBase)
                + " - " + entrada.describirBeneficio());
        if (entrada.requiereDocumento()) {
            System.out.println("  Presentar documentación en la entrada");
        }
    }

}

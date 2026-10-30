package ar.edu.ubp.das.ejemplo18.original;

public class Run {

    public static void main(String[] args) {
        Factura factura = new Factura(1000);
        System.out.println("Total con IVA: " + factura.calcularTotal());
    }

}

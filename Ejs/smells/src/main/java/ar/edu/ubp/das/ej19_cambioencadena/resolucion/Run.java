package ar.edu.ubp.das.ej19_cambioencadena.resolucion;

public class Run {

    public static void main(String[] args) {
        new Factura("Comercial Norte", 12345.67).imprimir();
        new Presupuesto("Estudio Ríos", 80000, 15).imprimir();
        new NotaDeCredito("Comercial Norte", 2499.99).imprimir();
    }

}

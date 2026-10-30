package ar.edu.ubp.das.ej15_claseperezosa.resolucion;

public class Run {

    public static void main(String[] args) {
        Facturador facturador = new Facturador();

        facturador.facturar(new Cliente("Ana Torres", "30111222"), 10000);
        facturador.facturar(new Cliente("Hugo Lima", "27444555"), 58000);
    }

}

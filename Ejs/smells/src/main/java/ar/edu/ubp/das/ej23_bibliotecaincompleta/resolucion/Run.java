package ar.edu.ubp.das.ej23_bibliotecaincompleta.resolucion;

public class Run {

    public static void main(String[] args) {
        Comprobante comprobante = new Comprobante();

        Cliente cliente = new Cliente("mARÍA", "4509123412341234");
        Empleado empleado = new Empleado("GONZÁLEZ", "L-0042");

        comprobante.imprimir(cliente, empleado, 15000, "0110599520000001234567");

        Cliente otro = new Cliente("rodrigo", "5300987698769876");
        comprobante.imprimir(otro, empleado, 4200, "2850590940090418135201");
    }

}

package ar.edu.ubp.das.ej02_metodolargo.resolucion;

public class Run {

    public static void main(String[] args) {
        Factura f1 = new Factura("Tecno SRL", "RI");
        f1.agregarItem(new Item("Teclado", 2, 15000));
        f1.agregarItem(new Item("Mouse", 3, 8000));
        f1.agregarItem(new Item("Monitor", 1, 120000));
        f1.imprimir();

        Factura f2 = new Factura("Juan Gómez", "CF");
        f2.agregarItem(new Item("Auriculares", 1, 22000));
        f2.agregarItem(new Item("Pad", 2, 4500));
        f2.imprimir();
    }

}

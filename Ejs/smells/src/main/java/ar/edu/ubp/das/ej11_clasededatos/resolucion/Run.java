package ar.edu.ubp.das.ej11_clasededatos.resolucion;

public class Run {

    public static void main(String[] args) {
        Almacen almacen = new Almacen();

        Producto arroz = new Producto("Arroz 1kg", 1800, 10);
        Producto aceite = new Producto("Aceite 900ml", 3200, 2);

        almacen.vender(arroz, 4);
        almacen.vender(aceite, 5);
        almacen.reponer(aceite, 6);
        almacen.vender(aceite, 5);

        arroz.aplicarAumento(10);
        arroz.agregarEtiqueta("oferta");
        arroz.agregarEtiqueta("oferta");
        aceite.agregarEtiqueta("sin TACC");

        almacen.mostrar(arroz);
        almacen.mostrar(aceite);
    }

}

package ar.edu.ubp.das.ej11_clasededatos;

public class Run {

    public static void main(String[] args) {
        Almacen almacen = new Almacen();

        Producto arroz = new Producto();
        arroz.nombre = "Arroz 1kg";
        arroz.setPrecio(1800);
        arroz.setStock(10);

        Producto aceite = new Producto();
        aceite.nombre = "Aceite 900ml";
        aceite.setPrecio(3200);
        aceite.setStock(2);

        almacen.vender(arroz, 4);
        almacen.vender(aceite, 5);
        almacen.reponer(aceite, 6);
        almacen.vender(aceite, 5);

        almacen.aplicarAumento(arroz, 10);
        almacen.etiquetar(arroz, "oferta");
        almacen.etiquetar(arroz, "oferta");
        almacen.etiquetar(aceite, "sin TACC");

        almacen.mostrar(arroz);
        almacen.mostrar(aceite);
    }

}

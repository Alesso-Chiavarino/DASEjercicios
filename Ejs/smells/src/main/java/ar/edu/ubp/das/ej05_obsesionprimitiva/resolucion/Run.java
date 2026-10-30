package ar.edu.ubp.das.ej05_obsesionprimitiva.resolucion;

public class Run {

    public static void main(String[] args) {
        Kiosco kiosco = new Kiosco();
        kiosco.agregarProducto("Alfajor", 1200, 10);
        kiosco.agregarProducto("Gaseosa", 2500, 5);
        kiosco.agregarProducto("Chicle", 300, 20);

        kiosco.vender("Alfajor", 3);
        kiosco.vender("Gaseosa", 6);
        kiosco.vender("Caramelo", 1);
        kiosco.vender("Chicle", 4);

        Producto masCaro = kiosco.productoMasCaro();
        System.out.println("Producto más caro: " + masCaro.getNombre() + " a $" + masCaro.getPrecio());

        kiosco.listarStock();
    }

}

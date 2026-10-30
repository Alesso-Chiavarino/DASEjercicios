package ar.edu.ubp.das.ejemplo17.original;

public class Run {

    public static void main(String[] args) {
        Tienda tienda = new Tienda();

        tienda.agregarProducto("Laptop", 5);
        tienda.agregarProducto("Mouse", 20);

        tienda.registrarCliente("ATAHUALPA MAS");
        tienda.registrarCliente("TUPAC DUPLO");

        tienda.registrarVenta("ATAHUALPA MAS", "Laptop", 80000);
        tienda.registrarVenta("TUPAC DUPLO", "Mouse", 2000);

        System.out.println("Stock de Laptop: " + tienda.consultarStock("Laptop"));
        System.out.println("Total vendido: " + tienda.getTotalVendido());
    }

}

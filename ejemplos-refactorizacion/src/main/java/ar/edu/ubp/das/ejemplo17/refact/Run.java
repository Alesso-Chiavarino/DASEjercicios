package ar.edu.ubp.das.ejemplo17.refact;

public class Run {

    public static void main(String[] args) {
        Tienda tienda = new Tienda();

        tienda.getInventario().agregarProducto("Laptop", 5);
        tienda.getInventario().agregarProducto("Mouse", 20);

        tienda.getClientes().registrarCliente("ATAHUALPA MAS");
        tienda.getClientes().registrarCliente("TUPAC DUPLO");

        tienda.vender("ATAHUALPA MAS", "Laptop", 80000);
        tienda.vender("TUPAC DUPLO", "Mouse", 2000);

        System.out.println("Stock de Laptop: " + tienda.getInventario().consultarStock("Laptop"));
        System.out.println("Total vendido: " + tienda.getVentas().getTotalVendido());

        // Refactorización aplicada: "Extract Class" (Extraer Clase). La clase Tienda
        // original agrupaba inventario, clientes y ventas en un solo lugar (Large Class).
        // Se separó en tres clases con una responsabilidad cada una: Inventario,
        // GestorClientes y RegistroVentas. Tienda pasa a ser un orquestador que las
        // coordina (ejemplo: vender() descuenta stock, suma puntos y registra la venta).
    }

}

package ar.edu.ubp.das.ejemplo13.refact;

import java.util.Arrays;
import java.util.List;

public class Run {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("ATAHUALPA MAS", "atahmas@ubp.edu.ar",
                "Donato Álvarez 380", "Argüello", "5147");

        Producto producto1 = new Producto("Laptop", 2, 80000.0);
        Producto producto2 = new Producto("Mouse", 1, 2000.0);
        List<Producto> productos = Arrays.asList(producto1, producto2);

        Pedido pedido = new Pedido(cliente, productos, "Tarjeta de crédito");
        pedido.mostrarDetallePedido();

        // Refactorizaciones aplicadas:
        // "Introduce Parameter Object" (Introducir objeto parámetro) en lugar de pasar
        // múltiples parámetros separados para cada dato, ahora pasamos los objetos
        // Cliente y una lista de Producto al constructor de Pedido, lo que reduce la
        // longitud de la lista de parámetros.
        // "Replace Data Value with Object" (Reemplazar valor de datos con objeto)
        // reemplazamos las listas individuales de nombres de productos, cantidades y
        // precios unitarios con objetos Producto. El objeto Producto encapsula todos los
        // datos relacionados con un producto individual, lo que mejora la organización y
        // cohesión del código.
    }

}


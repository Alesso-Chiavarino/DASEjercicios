package ar.edu.ubp.das.ej11_clasededatos.resolucion;

public class Almacen {

    public void reponer(Producto producto, int cantidad) {
        producto.reponer(cantidad);
        System.out.println("Repuesto " + producto.getNombre() + ": +" + cantidad);
    }

    public void vender(Producto producto, int cantidad) {
        if (producto.hayStock(cantidad)) {
            producto.vender(cantidad);
            System.out.println("Vendido " + producto.getNombre() + ": -" + cantidad);
        } else {
            System.out.println("Sin stock suficiente de " + producto.getNombre());
        }
    }

    public void mostrar(Producto producto) {
        System.out.println(producto.getNombre() + " | $" + producto.getPrecio() + " | stock: " + producto.getStock()
                + " | etiquetas: " + producto.getEtiquetas());
    }

}

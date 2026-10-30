package ar.edu.ubp.das.ej05_obsesionprimitiva.resolucion;

import java.util.ArrayList;
import java.util.List;

public class Kiosco {

    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(String nombre, double precio, int stock) {
        productos.add(new Producto(nombre, precio, stock));
    }

    public void vender(String nombre, int cantidad) {
        Producto producto = buscar(nombre);
        if (producto == null) {
            System.out.println("No existe el producto " + nombre);
            return;
        }
        if (!producto.hayStock(cantidad)) {
            System.out.println("Stock insuficiente de " + nombre + " (quedan " + producto.getStock() + ")");
            return;
        }
        producto.descontar(cantidad);
        System.out.println("Venta: " + cantidad + " x " + nombre + " = $" + (producto.getPrecio() * cantidad));
    }

    public Producto productoMasCaro() {
        Producto masCaro = productos.get(0);
        for (Producto producto : productos) {
            if (producto.getPrecio() > masCaro.getPrecio()) {
                masCaro = producto;
            }
        }
        return masCaro;
    }

    public void listarStock() {
        System.out.println("Stock actual:");
        for (Producto producto : productos) {
            System.out.println("  " + producto.getNombre() + ": " + producto.getStock() + " u. a $" + producto.getPrecio());
        }
    }

    private Producto buscar(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null;
    }

}

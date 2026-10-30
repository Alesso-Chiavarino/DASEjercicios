package ar.edu.ubp.das.ej11_clasededatos;

public class Almacen {

    public void reponer(Producto producto, int cantidad) {
        producto.setStock(producto.getStock() + cantidad);
        System.out.println("Repuesto " + producto.nombre + ": +" + cantidad);
    }

    public void vender(Producto producto, int cantidad) {
        if (producto.getStock() >= cantidad) {
            producto.setStock(producto.getStock() - cantidad);
            System.out.println("Vendido " + producto.nombre + ": -" + cantidad);
        } else {
            System.out.println("Sin stock suficiente de " + producto.nombre);
        }
    }

    public void aplicarAumento(Producto producto, double porcentaje) {
        producto.setPrecio(producto.getPrecio() + producto.getPrecio() * porcentaje / 100);
    }

    public void etiquetar(Producto producto, String etiqueta) {
        if (!producto.getEtiquetas().contains(etiqueta)) {
            producto.getEtiquetas().add(etiqueta);
        }
    }

    public void mostrar(Producto producto) {
        System.out.println(producto.nombre + " | $" + producto.getPrecio() + " | stock: " + producto.getStock()
                + " | etiquetas: " + producto.getEtiquetas());
    }

}

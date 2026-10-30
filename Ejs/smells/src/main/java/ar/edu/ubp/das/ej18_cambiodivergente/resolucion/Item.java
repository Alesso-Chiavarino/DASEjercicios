package ar.edu.ubp.das.ej18_cambiodivergente.resolucion;

public class Item {

    private String producto;
    private int cantidad;
    private double precio;

    public Item(String producto, int cantidad, double precio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

}

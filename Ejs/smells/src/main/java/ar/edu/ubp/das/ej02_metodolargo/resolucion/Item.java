package ar.edu.ubp.das.ej02_metodolargo.resolucion;

public class Item {

    private String descripcion;
    private int cantidad;
    private double precioUnitario;

    public Item(String descripcion, int cantidad, double precioUnitario) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

}

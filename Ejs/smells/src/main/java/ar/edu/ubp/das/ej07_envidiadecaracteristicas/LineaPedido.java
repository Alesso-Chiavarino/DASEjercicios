package ar.edu.ubp.das.ej07_envidiadecaracteristicas;

public class LineaPedido {

    private String producto;
    private int cantidad;
    private double precioUnitario;

    public LineaPedido(String producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

}

package ar.edu.ubp.das.sim3.ej1;

// Base para cuando la farmacia empiece a vender perfumería, accesorios, etc.
public abstract class ProductoBase {

    protected String nombre;
    protected double precio;

    public ProductoBase(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public double calcularPuntosFidelidad() {
        return 0;
    }

}

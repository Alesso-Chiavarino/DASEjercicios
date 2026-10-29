package ar.edu.ubp.das.sim3.ej1;

public class Medicamento extends ProductoBase {

    private boolean requiereReceta;
    private int stock;

    public Medicamento(String nombre, double precio, boolean requiereReceta, int stock) {
        super(nombre, precio);
        this.requiereReceta = requiereReceta;
        this.stock = stock;
    }

    public boolean isRequiereReceta() {
        return requiereReceta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}

package ar.edu.ubp.das.ej11_clasededatos;

import java.util.ArrayList;
import java.util.List;

public class Producto {

    public String nombre;
    private double precio;
    private int stock;
    private List<String> etiquetas = new ArrayList<>();

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

}

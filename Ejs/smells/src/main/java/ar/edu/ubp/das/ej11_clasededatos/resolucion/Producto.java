package ar.edu.ubp.das.ej11_clasededatos.resolucion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Producto {

    private String nombre;
    private double precio;
    private int stock;
    private List<String> etiquetas = new ArrayList<>();

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public List<String> getEtiquetas() {
        return Collections.unmodifiableList(etiquetas);
    }

    public void reponer(int cantidad) {
        stock = stock + cantidad;
    }

    public boolean hayStock(int cantidad) {
        return stock >= cantidad;
    }

    public void vender(int cantidad) {
        stock = stock - cantidad;
    }

    public void aplicarAumento(double porcentaje) {
        precio = precio + precio * porcentaje / 100;
    }

    public void agregarEtiqueta(String etiqueta) {
        if (!etiquetas.contains(etiqueta)) {
            etiquetas.add(etiqueta);
        }
    }

    public void quitarEtiqueta(String etiqueta) {
        etiquetas.remove(etiqueta);
    }

}

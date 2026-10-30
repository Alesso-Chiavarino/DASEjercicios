package ar.edu.ubp.das.ej05_obsesionprimitiva;

import java.util.ArrayList;
import java.util.List;

public class Kiosco {

    private List<String> productos = new ArrayList<>();
    private List<Double> precios = new ArrayList<>();
    private List<Integer> stocks = new ArrayList<>();

    public void agregarProducto(String nombre, double precio, int stock) {
        productos.add(nombre);
        precios.add(precio);
        stocks.add(stock);
    }

    public void vender(String nombre, int cantidad) {
        int i = productos.indexOf(nombre);
        if (i == -1) {
            System.out.println("No existe el producto " + nombre);
            return;
        }
        if (stocks.get(i) < cantidad) {
            System.out.println("Stock insuficiente de " + nombre + " (quedan " + stocks.get(i) + ")");
            return;
        }
        stocks.set(i, stocks.get(i) - cantidad);
        System.out.println("Venta: " + cantidad + " x " + nombre + " = $" + (precios.get(i) * cantidad));
    }

    public String[] productoMasCaro() {
        int iMax = 0;
        for (int i = 1; i < precios.size(); i++) {
            if (precios.get(i) > precios.get(iMax)) {
                iMax = i;
            }
        }
        return new String[] { productos.get(iMax), String.valueOf(precios.get(iMax)) };
    }

    public void listarStock() {
        System.out.println("Stock actual:");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println("  " + productos.get(i) + ": " + stocks.get(i) + " u. a $" + precios.get(i));
        }
    }

}

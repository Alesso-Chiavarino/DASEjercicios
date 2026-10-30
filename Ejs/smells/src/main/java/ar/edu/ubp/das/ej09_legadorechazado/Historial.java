package ar.edu.ubp.das.ej09_legadorechazado;

import java.util.ArrayList;

public class Historial extends ArrayList<String> {

    public void visitar(String url) {
        add(url);
        System.out.println("Visitando " + url);
    }

    public void volver() {
        if (size() <= 1) {
            System.out.println("No hay página anterior");
            return;
        }
        remove(size() - 1);
        System.out.println("Volviendo a " + paginaActual());
    }

    public String paginaActual() {
        return get(size() - 1);
    }

}

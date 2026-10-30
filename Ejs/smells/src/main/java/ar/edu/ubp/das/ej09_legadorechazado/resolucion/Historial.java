package ar.edu.ubp.das.ej09_legadorechazado.resolucion;

import java.util.ArrayList;
import java.util.List;

public class Historial {

    private List<String> paginas = new ArrayList<>();

    public void visitar(String url) {
        paginas.add(url);
        System.out.println("Visitando " + url);
    }

    public void volver() {
        if (paginas.size() <= 1) {
            System.out.println("No hay página anterior");
            return;
        }
        paginas.remove(paginas.size() - 1);
        System.out.println("Volviendo a " + paginaActual());
    }

    public String paginaActual() {
        return paginas.get(paginas.size() - 1);
    }

    public int cantidadPaginas() {
        return paginas.size();
    }

}

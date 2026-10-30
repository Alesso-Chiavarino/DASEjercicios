package ar.edu.ubp.das.ej09_legadorechazado.resolucion;

public class Run {

    public static void main(String[] args) {
        Historial historial = new Historial();

        historial.visitar("ubp.edu.ar");
        historial.visitar("ubp.edu.ar/carreras");
        historial.visitar("ubp.edu.ar/carreras/informatica");

        historial.volver();
        System.out.println("Página actual: " + historial.paginaActual());
        System.out.println("Páginas en el historial: " + historial.cantidadPaginas());

        historial.volver();
        historial.volver();
        System.out.println("Página actual: " + historial.paginaActual());
    }

}

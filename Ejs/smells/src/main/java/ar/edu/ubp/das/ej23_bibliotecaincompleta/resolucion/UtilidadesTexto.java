package ar.edu.ubp.das.ej23_bibliotecaincompleta.resolucion;

public class UtilidadesTexto {

    public static String capitalizar(String texto) {
        return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
    }

    public static String enmascarar(String texto) {
        return "*".repeat(texto.length() - 4) + texto.substring(texto.length() - 4);
    }

}

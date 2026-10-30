package ar.edu.ubp.das.ej23_bibliotecaincompleta.resolucion;

public class Cliente {

    private String nombre;
    private String numeroTarjeta;

    public Cliente(String nombre, String numeroTarjeta) {
        this.nombre = nombre;
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNombreFormateado() {
        return UtilidadesTexto.capitalizar(nombre);
    }

    public String getTarjetaOculta() {
        return UtilidadesTexto.enmascarar(numeroTarjeta);
    }

}

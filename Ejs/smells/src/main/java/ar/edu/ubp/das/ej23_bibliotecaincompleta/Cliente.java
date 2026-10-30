package ar.edu.ubp.das.ej23_bibliotecaincompleta;

public class Cliente {

    private String nombre;
    private String numeroTarjeta;

    public Cliente(String nombre, String numeroTarjeta) {
        this.nombre = nombre;
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNombreFormateado() {
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
    }

    public String getTarjetaOculta() {
        return "*".repeat(numeroTarjeta.length() - 4) + numeroTarjeta.substring(numeroTarjeta.length() - 4);
    }

}

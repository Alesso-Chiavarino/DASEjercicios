package ar.edu.ubp.das.ej23_bibliotecaincompleta.resolucion;

public class Empleado {

    private String apellido;
    private String legajo;

    public Empleado(String apellido, String legajo) {
        this.apellido = apellido;
        this.legajo = legajo;
    }

    public String getApellidoFormateado() {
        return UtilidadesTexto.capitalizar(apellido);
    }

    public String getLegajo() {
        return legajo;
    }

}

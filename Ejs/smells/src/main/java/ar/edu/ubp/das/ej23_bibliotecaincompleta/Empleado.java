package ar.edu.ubp.das.ej23_bibliotecaincompleta;

public class Empleado {

    private String apellido;
    private String legajo;

    public Empleado(String apellido, String legajo) {
        this.apellido = apellido;
        this.legajo = legajo;
    }

    public String getApellidoFormateado() {
        return apellido.substring(0, 1).toUpperCase() + apellido.substring(1).toLowerCase();
    }

    public String getLegajo() {
        return legajo;
    }

}

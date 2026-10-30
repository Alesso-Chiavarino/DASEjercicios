package ar.edu.ubp.das.ej21_jerarquiasparalelas.resolucion;

public abstract class Curso {

    private String nombre;
    private int horas;

    public Curso(String nombre, int horas) {
        this.nombre = nombre;
        this.horas = horas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHoras() {
        return horas;
    }

    public abstract String emitirCertificado(String alumno);

}

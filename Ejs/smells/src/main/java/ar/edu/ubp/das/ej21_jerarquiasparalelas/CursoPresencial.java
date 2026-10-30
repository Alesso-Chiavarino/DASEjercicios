package ar.edu.ubp.das.ej21_jerarquiasparalelas;

public class CursoPresencial extends Curso {

    private String sede;

    public CursoPresencial(String nombre, int horas, String sede) {
        super(nombre, horas);
        this.sede = sede;
    }

    public String getSede() {
        return sede;
    }

}

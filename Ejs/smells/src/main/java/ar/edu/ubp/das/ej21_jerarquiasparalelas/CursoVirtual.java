package ar.edu.ubp.das.ej21_jerarquiasparalelas;

public class CursoVirtual extends Curso {

    private String plataforma;

    public CursoVirtual(String nombre, int horas, String plataforma) {
        super(nombre, horas);
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

}

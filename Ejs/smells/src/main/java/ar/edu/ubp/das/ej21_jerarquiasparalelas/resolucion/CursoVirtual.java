package ar.edu.ubp.das.ej21_jerarquiasparalelas.resolucion;

public class CursoVirtual extends Curso {

    private String plataforma;

    public CursoVirtual(String nombre, int horas, String plataforma) {
        super(nombre, horas);
        this.plataforma = plataforma;
    }

    @Override
    public String emitirCertificado(String alumno) {
        return "Se certifica que " + alumno + " completó el curso online " + getNombre()
                + " (" + getHoras() + " hs) en " + plataforma;
    }

}

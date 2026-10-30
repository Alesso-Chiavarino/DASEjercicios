package ar.edu.ubp.das.ej21_jerarquiasparalelas.resolucion;

public class CursoPresencial extends Curso {

    private String sede;

    public CursoPresencial(String nombre, int horas, String sede) {
        super(nombre, horas);
        this.sede = sede;
    }

    @Override
    public String emitirCertificado(String alumno) {
        return "Se certifica que " + alumno + " asistió al curso " + getNombre()
                + " (" + getHoras() + " hs) en la sede " + sede;
    }

}

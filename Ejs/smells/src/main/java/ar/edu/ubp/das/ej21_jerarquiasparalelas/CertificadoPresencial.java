package ar.edu.ubp.das.ej21_jerarquiasparalelas;

public class CertificadoPresencial extends Certificado {

    @Override
    public String emitir(String alumno, Curso curso) {
        CursoPresencial presencial = (CursoPresencial) curso;
        return "Se certifica que " + alumno + " asistió al curso " + presencial.getNombre()
                + " (" + presencial.getHoras() + " hs) en la sede " + presencial.getSede();
    }

}

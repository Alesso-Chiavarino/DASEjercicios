package ar.edu.ubp.das.ej21_jerarquiasparalelas;

public class CertificadoVirtual extends Certificado {

    @Override
    public String emitir(String alumno, Curso curso) {
        CursoVirtual virtual = (CursoVirtual) curso;
        return "Se certifica que " + alumno + " completó el curso online " + virtual.getNombre()
                + " (" + virtual.getHoras() + " hs) en " + virtual.getPlataforma();
    }

}

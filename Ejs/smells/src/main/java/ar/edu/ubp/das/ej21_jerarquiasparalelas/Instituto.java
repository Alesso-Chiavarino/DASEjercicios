package ar.edu.ubp.das.ej21_jerarquiasparalelas;

public class Instituto {

    public void certificar(String alumno, Curso curso) {
        Certificado certificado;
        if (curso instanceof CursoPresencial) {
            certificado = new CertificadoPresencial();
        } else {
            certificado = new CertificadoVirtual();
        }
        System.out.println(certificado.emitir(alumno, curso));
    }

}

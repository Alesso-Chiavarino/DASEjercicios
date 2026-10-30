package ar.edu.ubp.das.ej21_jerarquiasparalelas;

public class Run {

    public static void main(String[] args) {
        Instituto instituto = new Instituto();

        Curso java = new CursoPresencial("Java Avanzado", 40, "Campus UBP");
        Curso sql = new CursoVirtual("SQL desde cero", 24, "Moodle");

        instituto.certificar("Lara Sánchez", java);
        instituto.certificar("Iván Castro", sql);
        instituto.certificar("Lara Sánchez", sql);
    }

}

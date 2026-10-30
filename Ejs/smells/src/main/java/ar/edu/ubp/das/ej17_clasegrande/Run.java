package ar.edu.ubp.das.ej17_clasegrande;

public class Run {

    public static void main(String[] args) {
        SistemaEscuela escuela = new SistemaEscuela();

        escuela.inscribir(new Alumno("Tomás", "45111222", "tomas@mail.com"));
        escuela.inscribir(new Alumno("Julieta", "45333444", "juli@mail.com"));

        escuela.cargarNota("45111222", 7);
        escuela.cargarNota("45111222", 9);
        escuela.cargarNota("45333444", 4);
        escuela.cargarNota("45333444", 6);

        escuela.generarCuota("45111222");
        escuela.generarCuota("45333444");
        escuela.registrarPago("45111222", 45000);
        escuela.registrarPago("45333444", 20000);

        escuela.enviarBoletin("45111222");
        escuela.enviarBoletin("45333444");
        escuela.enviarAvisosDeDeuda();
        escuela.imprimirResumen();
    }

}

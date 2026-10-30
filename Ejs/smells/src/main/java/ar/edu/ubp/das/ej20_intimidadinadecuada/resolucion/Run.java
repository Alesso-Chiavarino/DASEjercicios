package ar.edu.ubp.das.ej20_intimidadinadecuada.resolucion;

public class Run {

    public static void main(String[] args) {
        Medico clinica = new Medico("Paula Vera", "Clínica");
        Medico trauma = new Medico("Diego Paz", "Traumatología");

        Paciente juan = new Paciente("Juan");
        Paciente rosa = new Paciente("Rosa");

        juan.elegirMedicoDeCabecera(clinica);
        rosa.elegirMedicoDeCabecera(clinica);

        clinica.atender(juan, "gripe");
        trauma.atender(juan, "esguince de tobillo");
        clinica.atender(rosa, "control anual");

        juan.imprimirHistoria();
        rosa.imprimirHistoria();

        clinica.imprimirResumen();
        trauma.imprimirResumen();
    }

}

package ar.edu.ubp.das.ej20_intimidadinadecuada.resolucion;

public class Medico {

    private String nombre;
    private String especialidad;
    private int cantidadPacientes;
    private int consultasDelMes;

    public Medico(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void sumarPaciente() {
        cantidadPacientes++;
    }

    public void atender(Paciente paciente, String diagnostico) {
        paciente.agregarRegistro(especialidad + ": " + diagnostico + " (Dr/a. " + nombre + ")");
        consultasDelMes++;
    }

    public void imprimirResumen() {
        System.out.println(nombre + ": " + cantidadPacientes + " pacientes, "
                + consultasDelMes + " consultas en el mes");
    }

}

package ar.edu.ubp.das.ej20_intimidadinadecuada;

import java.util.ArrayList;
import java.util.List;

public class Medico {

    String nombre;
    String especialidad;
    List<Paciente> pacientes = new ArrayList<>();
    int consultasDelMes;

    public Medico(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public void atender(Paciente paciente, String diagnostico) {
        paciente.historiaClinica.add(especialidad + ": " + diagnostico + " (Dr/a. " + nombre + ")");
        consultasDelMes++;
    }

}

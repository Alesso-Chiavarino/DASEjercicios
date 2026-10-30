package ar.edu.ubp.das.ej20_intimidadinadecuada;

import java.util.ArrayList;
import java.util.List;

public class Paciente {

    String nombre;
    Medico medicoDeCabecera;
    List<String> historiaClinica = new ArrayList<>();

    public Paciente(String nombre) {
        this.nombre = nombre;
    }

    public void elegirMedicoDeCabecera(Medico medico) {
        this.medicoDeCabecera = medico;
        medico.pacientes.add(this);
        System.out.println(nombre + " eligió a " + medico.nombre + " como médico de cabecera");
    }

    public void imprimirHistoria() {
        System.out.println("Historia clínica de " + nombre + " (cabecera: " + medicoDeCabecera.nombre + ")");
        for (String registro : historiaClinica) {
            System.out.println("  " + registro);
        }
    }

}

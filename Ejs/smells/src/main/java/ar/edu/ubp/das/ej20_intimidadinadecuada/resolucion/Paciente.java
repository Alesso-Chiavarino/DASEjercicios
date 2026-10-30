package ar.edu.ubp.das.ej20_intimidadinadecuada.resolucion;

import java.util.ArrayList;
import java.util.List;

public class Paciente {

    private String nombre;
    private Medico medicoDeCabecera;
    private List<String> historiaClinica = new ArrayList<>();

    public Paciente(String nombre) {
        this.nombre = nombre;
    }

    public void elegirMedicoDeCabecera(Medico medico) {
        this.medicoDeCabecera = medico;
        medico.sumarPaciente();
        System.out.println(nombre + " eligió a " + medico.getNombre() + " como médico de cabecera");
    }

    public void agregarRegistro(String registro) {
        historiaClinica.add(registro);
    }

    public void imprimirHistoria() {
        System.out.println("Historia clínica de " + nombre + " (cabecera: " + medicoDeCabecera.getNombre() + ")");
        for (String registro : historiaClinica) {
            System.out.println("  " + registro);
        }
    }

}

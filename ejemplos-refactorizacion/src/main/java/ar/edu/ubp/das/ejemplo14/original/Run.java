package ar.edu.ubp.das.ejemplo14.original;

public class Run {

    public static void main(String[] args) {
        Persona persona = new Persona("ATAHUALPA", "MAS",
                "351-414-4444", "Donato Ávalez 380, Argüello, 5147");
        if(persona.validarTelefono()) {
            throw new IllegalArgumentException("Formato de teléfono inválido. Debe ser XXX-XXX-XXXX");
        }
        persona.mostrarInformacion();
    }

}

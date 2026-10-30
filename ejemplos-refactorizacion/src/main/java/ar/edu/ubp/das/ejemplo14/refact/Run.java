package ar.edu.ubp.das.ejemplo14.refact;

public class Run {

    public static void main(String[] args) {
        Telefono telefono = new Telefono("351-414-4444");
        Direccion direccion = new Direccion("Donato Álvarez", "380", "Argüello", "5147");

        Persona persona = new Persona("ATAHUALPA", "MAS", telefono, direccion);
        persona.mostrarInformacion();

        // Refactorización aplicada: "Replace Primitive with Object" (Reemplazar
        // primitivo con objeto) se reemplazó el uso de cadenas (String) para el
        // número de teléfono con una clase Telefono.
        // Esta nueva clase encapsula tanto el valor del teléfono como la lógica de
        // validación de su formato.
        // También, se reemplazó el uso de una cadena para la dirección con una
        // clase Direccion, que encapsula los componentes de una dirección
        // (calle, número de calle, ciudad y código postal).
    }

}

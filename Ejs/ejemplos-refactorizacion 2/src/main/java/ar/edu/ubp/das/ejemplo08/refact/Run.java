package ar.edu.ubp.das.ejemplo08.refact;

public class Run {

    public static void main(String[] args) {
        Direccion direccion = new Direccion("Donato Álvarez", "380", "Argüello", "5147", "Argentina");
        Cliente cliente = new Cliente("ATAHUALPA MAS", "atahmas@ubp.edu.ar", direccion);
        cliente.mostrarInformacion();

        Direccion nuevaDireccion = new Direccion("Germán Vagni", "S/N", "Argüello", "5147", "Argentina");
        cliente.actualizarDireccion(nuevaDireccion);
        cliente.mostrarInformacion();

        // Refactorización aplicada: "Extract Class" (Extraer Clase) los datos
        // relacionados con la dirección (calle, nroCalle, ciudad, codigoPostal, pais)
        // estaban dispersos en varias partes del código, lo que generaba duplicación
        // y baja cohesión. Estos datos siempre se usaban juntos, pero estaban
        // representados como atributos y parámetros sueltos en lugar de estar agrupados.
        // Creamos una clase nueva, Direccion, para agrupar todos los atributos
        // relacionados con la dirección. Esto mejoró la cohesión, ya que ahora todos
        // los datos relacionados con la dirección están encapsulados en una entidad
        // lógica y se eliminó la duplicación en la clase Cliente.
    }

}

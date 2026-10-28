package ar.edu.ubp.das.ejemplo12.original;

public class Run {

    public static void main(String[] args) {
        Persona persona = new Persona("AMARU COS", 30, 0);
        persona.describir();

        Persona alumno = new Alumno("TUPAC DUPLO", 19);
        alumno.describir();

        Persona empleado = new Empleado("ATAHUALPA MAS", 45, 25000);
        empleado.describir();
    }

}

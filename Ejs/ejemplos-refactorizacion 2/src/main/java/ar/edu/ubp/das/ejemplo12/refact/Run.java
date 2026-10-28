package ar.edu.ubp.das.ejemplo12.refact;

public class Run {

    public static void main(String[] args) {
        Persona persona = new Persona("AMARU COS", 30);
        persona.describir();

        Alumno alumno = new Alumno("TUPAC DUPLO", 19);
        alumno.describir();

        Empleado empleado = new Empleado("ATAHUALPA MAS", 45, 25000);
        empleado.describir();

        // Refactorización aplicada: "Pull Down Field" (Bajar campo) el atributo salario
        // estaba en la clase base Persona, lo que forzaba a todas las subclases
        // (incluyendo Alumno) a heredar ese atributo y los métodos relacionados con él,
        // a pesar de que no es relevante para los estudiantes. Esto generaba el bad
        // smell "Refused Bequest", ya que Alumno heredaba atributos que no necesitaba.
        // Se movió el atributo salario y el método getSalario() a la subclase Empleado,
        // donde es más apropiado. Esto permite que solo los empleados manejen
        // información relacionada con el salario mejorando la cohesión.
    }

}


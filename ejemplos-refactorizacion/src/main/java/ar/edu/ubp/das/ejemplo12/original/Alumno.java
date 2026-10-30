package ar.edu.ubp.das.ejemplo12.original;

// SMELL: Refused Bequest — Alumno hereda 'salario' de Persona pero no lo necesita;
// se fuerza un '0' en el super() para disimular que no le corresponde.
public class Alumno extends Persona {

    public Alumno(String nombre, int edad) {
        // SMELL: Refused Bequest — pasar 0 como salario revela que este atributo no aplica a Alumno.
        super(nombre, edad, 0);
    }

    @Override
    public void describir() {
        System.out.println(getNombre() + " tiene " + getEdad() + " años y es un estudiante.");
    }

}


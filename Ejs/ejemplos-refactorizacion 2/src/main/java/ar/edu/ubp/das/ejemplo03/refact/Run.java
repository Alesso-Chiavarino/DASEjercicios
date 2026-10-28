package ar.edu.ubp.das.ejemplo03.refact;

public class Run {

    public static void main(String[] args) {
        Empleado emp = new Empleado("ATAHUALPA MAS", 50000, 5000);

        EmpleadoRepository repo = new EmpleadoRepository();
        repo.guardarEmpleado();

        EmpleadoReporteGenerator gen = new EmpleadoReporteGenerator();
        gen.generarInforme(emp);

        // Refactorización aplicada: "Extract Class" (Extraer clase) la clase Empleado
        // ahora solo se encarga de su lógica interna (cálculo del salario), mientras que
        // las responsabilidades de presentación y persistencia se delegan a otras clases.
        // Esto ayuda a evitar cambios divergentes, ya que cualquier modificación en la
        // lógica de presentación o persistencia se realiza de forma aislada, sin afectar
        // el resto del sistema.
    }

}

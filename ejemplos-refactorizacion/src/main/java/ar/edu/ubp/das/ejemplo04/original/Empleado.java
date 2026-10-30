package ar.edu.ubp.das.ejemplo04.original;

// SMELL: Shotgun Surgery — las reglas (bonificación, vacaciones, registro) viven acá y en RRHH.
// SMELL: Dead Code — calcularBonificacion() y calcularDiasVacaciones() nunca se usan desde Run.
// SMELL: Duplicated Code — las mismas fórmulas aparecen también en RRHH.
// Refactor sugerida: Extract Class (BonificacionesService, VacacionesService, RegistroService).
public class Empleado {

    private String nombre;
    private double salario;
    private int añosTrabajados;

    public Empleado(String nombre, double salario, int añosTrabajados) {
        this.nombre = nombre;
        this.salario = salario;
        this.añosTrabajados = añosTrabajados;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public int getAñosTrabajados() {
        return añosTrabajados;
    }

    // SMELL: Dead Code + Duplicated Code — fórmula también está en RRHH.calcularBonificaciones().
    public double calcularBonificacion() {
        return salario * 0.05 * añosTrabajados;
    }

    // SMELL: Dead Code + Duplicated Code — fórmula también está en RRHH.calcularDiasVacaciones().
    public int calcularDiasVacaciones() {
        return añosTrabajados * 2;
    }

    public void registrarAumento(double nuevoSalario) {
        System.out.println("Empleado " + nombre + " ha recibido un aumento. Nuevo salario: " + nuevoSalario);
    }

}


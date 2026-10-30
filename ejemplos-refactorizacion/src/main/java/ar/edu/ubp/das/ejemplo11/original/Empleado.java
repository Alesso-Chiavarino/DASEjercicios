package ar.edu.ubp.das.ejemplo11.original;

// SMELL: Parallel Inheritance Hierarchies — la jerarquía Empleado (TiempoCompleto / TiempoParcial)
// corre en paralelo con EstrategiaPago (PagoTiempoCompleto / PagoTiempoParcial).
// Al agregar un tipo de empleado hay que crear también la estrategia equivalente.
// Refactor sugerida: Replace Inheritance with Delegation (Empleado tiene una EstrategiaPago).
public abstract class Empleado {

    private String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double calcularPago();

}

package ar.edu.ubp.das.ejemplo11.original;

// SMELL: Parallel Inheritance Hierarchies — esta jerarquía duplica la estructura de Empleado.
public abstract class EstrategiaPago {

    public abstract double calcular();

}

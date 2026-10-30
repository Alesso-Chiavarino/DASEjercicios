package ar.edu.ubp.das.ejemplo07.refact;

public class Calculadora {

    public double calcular(Operacion operacion, double a, double b) {
        return operacion.ejecutar(a, b);
    }

}

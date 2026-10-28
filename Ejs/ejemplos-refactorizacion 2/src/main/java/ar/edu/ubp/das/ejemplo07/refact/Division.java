package ar.edu.ubp.das.ejemplo07.refact;

public class Division implements Operacion {

    @Override
    public double ejecutar(double a, double b) {
        if (b != 0) {
            return a / b;
        }
        else {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
    }

}


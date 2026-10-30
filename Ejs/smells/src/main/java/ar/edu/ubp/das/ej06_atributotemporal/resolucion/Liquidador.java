package ar.edu.ubp.das.ej06_atributotemporal.resolucion;

public class Liquidador {

    public double liquidar(Empleado empleado) {
        return liquidar(empleado, null, null, null, null);
    }

    public double liquidar(Empleado empleado, int horasExtra, double valorHoraExtra) {
        return liquidar(empleado, horasExtra, valorHoraExtra, null, null);
    }

    public double liquidar(Empleado empleado, String motivoBono, double montoBono) {
        return liquidar(empleado, null, null, motivoBono, montoBono);
    }

    public double liquidar(Empleado empleado, Integer horasExtra, Double valorHoraExtra,
                           String motivoBono, Double montoBono) {
        double total = empleado.getSueldoBasico();
        if (horasExtra != null) {
            double extras = horasExtra * valorHoraExtra;
            System.out.println("  Horas extra: " + horasExtra + " x $" + valorHoraExtra + " = $" + extras);
            total += extras;
        }
        if (montoBono != null) {
            System.out.println("  Bono por " + motivoBono + ": $" + montoBono);
            total += montoBono;
        }
        System.out.println("Liquidación de " + empleado.getNombre() + ": $" + total);
        return total;
    }

}

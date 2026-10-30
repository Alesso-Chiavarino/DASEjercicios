package ar.edu.ubp.das.ejemplo22.refact;

public class CalculadorNomina {

    public double calcular(Empleado empleado) {
        double base = calcularBase(empleado);
        double bonos = calcularBonos(empleado, base);
        double subtotal = base + bonos;
        double aportes = calcularAportes(subtotal);
        double impuesto = calcularImpuesto(subtotal);
        double neto = subtotal - aportes - impuesto;

        imprimirRecibo(empleado, base, bonos, aportes, impuesto, neto);
        return neto;
    }

    private double calcularBase(Empleado empleado) {
        return empleado.getSueldoHora() * empleado.getHorasTrabajadas();
    }

    private double calcularBonos(Empleado empleado, double base) {
        double bonos = 0;
        if (empleado.getAntiguedad() > 5) {
            bonos += base * 0.10;
        }
        if (empleado.esProfesional()) {
            bonos += base * 0.05;
        }
        return bonos;
    }

    private double calcularAportes(double subtotal) {
        return subtotal * 0.11;
    }

    private double calcularImpuesto(double subtotal) {
        return subtotal * 0.05;
    }

    private void imprimirRecibo(Empleado empleado, double base, double bonos, double aportes, double impuesto, double neto) {
        System.out.println("Recibo de " + empleado.getNombre());
        System.out.println("Base: " + base);
        System.out.println("Bonos: " + bonos);
        System.out.println("Aportes: " + aportes);
        System.out.println("Impuesto: " + impuesto);
        System.out.println("Neto: " + neto);
    }

}

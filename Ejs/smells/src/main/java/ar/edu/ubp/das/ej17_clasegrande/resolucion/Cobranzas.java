package ar.edu.ubp.das.ej17_clasegrande.resolucion;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cobranzas {

    private Map<String, Double> deudas = new LinkedHashMap<>();
    private double valorCuota = 45000;
    private double recaudado = 0;

    public void registrarAlumno(String dni) {
        deudas.put(dni, 0.0);
    }

    public void generarCuota(String dni) {
        deudas.put(dni, deudas.get(dni) + valorCuota);
    }

    public void registrarPago(String dni, double monto) {
        deudas.put(dni, deudas.get(dni) - monto);
        recaudado += monto;
    }

    public boolean tieneDeuda(String dni) {
        return deudas.get(dni) > 0;
    }

    public double getDeuda(String dni) {
        return deudas.get(dni);
    }

    public double getRecaudado() {
        return recaudado;
    }

}

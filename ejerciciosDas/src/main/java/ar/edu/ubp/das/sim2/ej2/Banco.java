package ar.edu.ubp.das.sim2.ej2;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nombre;
    private List<CuentaCorriente> cuentas;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.cuentas = new ArrayList<CuentaCorriente>();
    }

    public void abrirCuenta(CuentaCorriente cuenta) {
        cuentas.add(cuenta);
    }

    public void cierreDeMes() {
        System.out.println("Cierre de mes - " + nombre);
        for (CuentaCorriente cuenta : cuentas) {
            if (cuenta instanceof CajaDeAhorro) {
                ((CajaDeAhorro) cuenta).acreditarIntereses();
            }

            double mantenimiento = cuenta.calcularMantenimiento();
            if (mantenimiento > 0) {
                cuenta.extraer(mantenimiento);
                System.out.println("  Mantenimiento cobrado a " + cuenta.getTitular() + ": $" + mantenimiento);
            }
        }
    }

    public void imprimirCuentas() {
        for (CuentaCorriente cuenta : cuentas) {
            System.out.println(cuenta.resumen());
        }
    }

}

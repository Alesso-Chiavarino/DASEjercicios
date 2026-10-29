package ar.edu.ubp.das.sim1.ej1;

import java.util.ArrayList;
import java.util.List;

public class Agencia {

    private String nombre;
    private List<Alquiler> alquileres;

    public Agencia(String nombre) {
        this.nombre = nombre;
        this.alquileres = new ArrayList<Alquiler>();
    }

    public void registrarAlquiler(Alquiler alquiler) {
        this.alquileres.add(alquiler);
    }

    public double calcularTotal(Alquiler a) {
        double total = a.getAuto().getPrecioPorDia() * a.getDias();

        // recargo de $100 por cada km que supere los 200 km diarios
        if (a.getKmRecorridos() > a.getDias() * 200) {
            total += (a.getKmRecorridos() - a.getDias() * 200) * 150;
        }

        // seguro opcional por día
        if (a.isConSeguro()) {
            total += a.getDias() * 8000;
        }

        // entrega a domicilio fuera de la provincia
        if (!a.getCliente().getDireccion().getLocalidad().getProvincia().equals("Córdoba")) {
            total += 25000;
        }

        return total;
    }

    public void imprimirResumen() {
        // Encabezado
        System.out.println("==============================================");
        System.out.println("RESUMEN DE ALQUILERES - " + nombre);
        System.out.println("==============================================");

        double totalFacturado = 0;
        double mayorTotal = 0;
        String clienteMayorTotal = "";

        // Recorrer cada alquiler y mostrar el detalle
        for (Alquiler a : alquileres) {
            // Datos del cliente
            System.out.println("Cliente: " + a.getCliente().getNombre() + " (DNI " + a.getCliente().getDni() + ")");
            System.out.println("Domicilio: " + a.getCliente().getDireccion().getCalle() + " "
                    + a.getCliente().getDireccion().getNumero() + ", "
                    + a.getCliente().getDireccion().getLocalidad().getNombre() + ", "
                    + a.getCliente().getDireccion().getLocalidad().getProvincia());

            // Datos del auto
            System.out.println("Auto: " + a.getAuto().getModelo() + " [" + a.getAuto().getPatente() + "]");
            System.out.println("Días: " + a.getDias() + " - Km recorridos: " + a.getKmRecorridos());

            // Si recorrió más de 200 km por día se informan los km excedidos
            int excedidos = a.getKmRecorridos() - a.getDias() * 200;
            if (excedidos > 0) {
                System.out.println("Km excedidos: " + excedidos);
            }

            // Seguro
            if (a.isConSeguro()) {
                System.out.println("Incluye seguro");
            }

            // Si el cliente no es de Córdoba se le cobra la entrega
            if (!a.getCliente().getDireccion().getLocalidad().getProvincia().equals("Córdoba")) {
                System.out.println("Incluye entrega fuera de la provincia");
            }

            // Total del alquiler
            double total = calcularTotal(a);
            System.out.println("Total: $" + total);
            System.out.println("----------------------------------------------");

            // Acumular para los totales generales
            totalFacturado += total;
            if (total > mayorTotal) {
                mayorTotal = total;
                clienteMayorTotal = a.getCliente().getNombre();
            }
        }

        // Totales generales
        System.out.println("Cantidad de alquileres: " + alquileres.size());
        System.out.println("Total facturado: $" + totalFacturado);
        // Promedio por alquiler (solo si hay alquileres)
        if (alquileres.size() > 0) {
            System.out.println("Promedio por alquiler: $" + (totalFacturado / alquileres.size()));
        }
        System.out.println("Alquiler más caro: " + clienteMayorTotal + " ($" + mayorTotal + ")");
        System.out.println("==============================================");
    }

}

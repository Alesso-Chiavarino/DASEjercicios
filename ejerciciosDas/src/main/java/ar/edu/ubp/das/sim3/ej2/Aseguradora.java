package ar.edu.ubp.das.sim3.ej2;

import java.util.ArrayList;
import java.util.List;

public class Aseguradora {

    private String nombre;
    private List<Poliza> polizas;
    private int ultimoNumero;

    public Aseguradora(String nombre) {
        this.nombre = nombre;
        this.polizas = new ArrayList<Poliza>();
        this.ultimoNumero = 1000;
    }

    public void emitirPoliza(Vehiculo vehiculo) {
        ultimoNumero++;
        Poliza poliza;
        if (vehiculo instanceof Auto) {
            poliza = new PolizaAuto(ultimoNumero, (Auto) vehiculo);
        }
        else if (vehiculo instanceof Moto) {
            poliza = new PolizaMoto(ultimoNumero, (Moto) vehiculo);
        }
        else if (vehiculo instanceof Camion) {
            poliza = new PolizaCamion(ultimoNumero, (Camion) vehiculo);
        }
        else {
            System.out.println("No se aseguran vehículos de este tipo: " + vehiculo.getPatente());
            ultimoNumero--;
            return;
        }
        polizas.add(poliza);
        System.out.println("Póliza N°" + poliza.getNumero() + " emitida: " + poliza.descripcion());
    }

    public void imprimirCartera() {
        System.out.println("===== Cartera de " + nombre + " =====");
        double total = 0;
        for (Poliza p : polizas) {
            System.out.println("N°" + p.getNumero() + " - " + p.descripcion() + " - prima: $" + p.calcularPrima());
            total += p.calcularPrima();
        }
        System.out.println("Total primas: $" + total);
    }

}

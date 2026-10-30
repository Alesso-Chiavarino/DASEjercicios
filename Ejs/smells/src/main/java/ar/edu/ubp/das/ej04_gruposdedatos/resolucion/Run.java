package ar.edu.ubp.das.ej04_gruposdedatos.resolucion;

public class Run {

    public static void main(String[] args) {
        Logistica logistica = new Logistica();

        Deposito deposito = new Deposito("Depósito Central", new Direccion("Av. Colón", 1200, "Córdoba", "5000"));

        Cliente c1 = new Cliente("Laura Gómez", new Direccion("Belgrano", 350, "Córdoba", "5000"));
        Cliente c2 = new Cliente("Pedro Sosa", new Direccion("San Martín", 80, "Río Cuarto", "5800"));
        Cliente c3 = new Cliente("Marta Ríos", new Direccion("Corrientes", 1500, "Buenos Aires", "1043"));

        System.out.println("Envíos desde " + deposito.getNombre() + " (" + deposito.getDireccion().getDescripcionCorta() + ")");

        logistica.imprimirEtiqueta(c1);
        System.out.println("  Costo: $" + logistica.calcularCosto(deposito.getDireccion(), c1.getDireccion(), 2));

        logistica.imprimirEtiqueta(c2);
        System.out.println("  Costo: $" + logistica.calcularCosto(deposito.getDireccion(), c2.getDireccion(), 5));

        logistica.imprimirEtiqueta(c3);
        System.out.println("  Costo: $" + logistica.calcularCosto(deposito.getDireccion(), c3.getDireccion(), 1.5));
    }

}

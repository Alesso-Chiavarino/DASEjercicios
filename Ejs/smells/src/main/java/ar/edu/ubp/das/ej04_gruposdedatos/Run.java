package ar.edu.ubp.das.ej04_gruposdedatos;

public class Run {

    public static void main(String[] args) {
        Logistica logistica = new Logistica();

        Deposito deposito = new Deposito("Depósito Central", "Av. Colón", 1200, "Córdoba", "5000");

        Cliente c1 = new Cliente("Laura Gómez", "Belgrano", 350, "Córdoba", "5000");
        Cliente c2 = new Cliente("Pedro Sosa", "San Martín", 80, "Río Cuarto", "5800");
        Cliente c3 = new Cliente("Marta Ríos", "Corrientes", 1500, "Buenos Aires", "1043");

        System.out.println("Envíos desde " + deposito.getNombre() + " (" + deposito.getCalle() + " "
                + deposito.getNumero() + ", " + deposito.getCiudad() + ")");

        logistica.imprimirEtiqueta(c1.getNombre(), c1.getCalle(), c1.getNumero(), c1.getCiudad(), c1.getCodigoPostal());
        System.out.println("  Costo: $" + logistica.calcularCosto(deposito.getCiudad(), deposito.getCodigoPostal(),
                c1.getCiudad(), c1.getCodigoPostal(), 2));

        logistica.imprimirEtiqueta(c2.getNombre(), c2.getCalle(), c2.getNumero(), c2.getCiudad(), c2.getCodigoPostal());
        System.out.println("  Costo: $" + logistica.calcularCosto(deposito.getCiudad(), deposito.getCodigoPostal(),
                c2.getCiudad(), c2.getCodigoPostal(), 5));

        logistica.imprimirEtiqueta(c3.getNombre(), c3.getCalle(), c3.getNumero(), c3.getCiudad(), c3.getCodigoPostal());
        System.out.println("  Costo: $" + logistica.calcularCosto(deposito.getCiudad(), deposito.getCodigoPostal(),
                c3.getCiudad(), c3.getCodigoPostal(), 1.5));
    }

}

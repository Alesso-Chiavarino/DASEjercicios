package ar.edu.ubp.das.ej04_gruposdedatos.resolucion;

public class Logistica {

    public double calcularCosto(Direccion origen, Direccion destino, double pesoKg) {
        double costo = pesoKg * 1200;
        if (!origen.esMismaCiudad(destino)) {
            costo += 5000;
        }
        if (!origen.esMismaProvincia(destino)) {
            costo += 3000;
        }
        return costo;
    }

    public void imprimirEtiqueta(Cliente cliente) {
        System.out.println("Destinatario: " + cliente.getNombre());
        System.out.println("  " + cliente.getDireccion().getDescripcionCompleta());
    }

}

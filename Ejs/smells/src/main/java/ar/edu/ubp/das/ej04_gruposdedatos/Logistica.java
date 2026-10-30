package ar.edu.ubp.das.ej04_gruposdedatos;

public class Logistica {

    public double calcularCosto(String ciudadOrigen, String codigoPostalOrigen,
                                String ciudadDestino, String codigoPostalDestino, double pesoKg) {
        double costo = pesoKg * 1200;
        if (!ciudadOrigen.equals(ciudadDestino)) {
            costo += 5000;
        }
        // si el primer dígito del CP es distinto, es otra provincia
        if (codigoPostalOrigen.charAt(0) != codigoPostalDestino.charAt(0)) {
            costo += 3000;
        }
        return costo;
    }

    public void imprimirEtiqueta(String nombre, String calle, int numero, String ciudad, String codigoPostal) {
        System.out.println("Destinatario: " + nombre);
        System.out.println("  " + calle + " " + numero + " - " + ciudad + " (CP " + codigoPostal + ")");
    }

}

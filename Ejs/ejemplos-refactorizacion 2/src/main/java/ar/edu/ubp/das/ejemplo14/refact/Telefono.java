package ar.edu.ubp.das.ejemplo14.refact;

public class Telefono {

    private String numero;

    public Telefono(String numero) {
        if (!numero.matches("\\d{3}-\\d{3}-\\d{4}")) {
            throw new IllegalArgumentException("Formato de teléfono inválido. Debe ser XXX-XXX-XXXX");
        }
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

}


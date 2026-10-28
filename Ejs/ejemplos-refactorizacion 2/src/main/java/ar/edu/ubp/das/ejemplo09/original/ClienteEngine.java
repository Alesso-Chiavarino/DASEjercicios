package ar.edu.ubp.das.ejemplo09.original;

public class ClienteEngine {

    private Cliente cliente;

    public ClienteEngine(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNombreCliente() {
        return cliente.getNombre();
    }

    public String getEmailCliente() {
        return cliente.getEmail();
    }

}


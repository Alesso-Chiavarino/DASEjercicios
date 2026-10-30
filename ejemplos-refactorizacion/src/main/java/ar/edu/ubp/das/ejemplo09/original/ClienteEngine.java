package ar.edu.ubp.das.ejemplo09.original;

// SMELL: Middleman — ClienteEngine solo delega todas sus llamadas a Cliente sin agregar lógica.
// Refactor sugerida: Remove Middle Man (que Pedido hable directo con Cliente).
public class ClienteEngine {

    private Cliente cliente;

    public ClienteEngine(Cliente cliente) {
        this.cliente = cliente;
    }

    // SMELL: Middleman — simple reenvío a Cliente.getNombre().
    public String getNombreCliente() {
        return cliente.getNombre();
    }

    // SMELL: Middleman — simple reenvío a Cliente.getEmail().
    public String getEmailCliente() {
        return cliente.getEmail();
    }

}


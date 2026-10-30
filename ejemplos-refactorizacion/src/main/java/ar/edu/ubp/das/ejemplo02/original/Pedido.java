package ar.edu.ubp.das.ejemplo02.original;

// SMELL: Message Chains — Pedido conoce la estructura interna de Cliente y Direccion.
// Refactor sugerida: Hide Delegate (que Cliente exponga la info sin que Pedido vea a Direccion).
public class Pedido {

    private Cliente cliente;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void imprimirCliente() {
        System.out.println("Nombre: " + cliente.getNombre());
        // SMELL: Message Chain — cliente.getDireccion().getCalle()... viola la Ley de Demeter.
        System.out.println("Domicilio: " + cliente.getDireccion().getCalle() + " " + cliente.getDireccion().getNroCalle() + ", " + cliente.getDireccion().getCiudad());
    }

}

package ar.edu.ubp.das.ejemplo02.refact;

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
        System.out.println("Domicilio: " + cliente.getDireccion());
    }

}

package ar.edu.ubp.das.ejemplo02.refact;

public class Run {

    public static void main(String[] args) {
        Direccion direccion = new Direccion("Argüello", "Donato Alvarez", 380);
        Cliente cliente = new Cliente("UBP", direccion);
        Pedido pedido = new Pedido(cliente);
        pedido.imprimirCliente();

        // Refactorización aplicada: "Hide Delegate" (Ocultar Delegado)
        // Eliminamos la cadena de invocaciones múltiples
        // como ser cliente.getDireccion().getCiudad() introduciendo una nueva
        // función en la clase Cliente para que Pedido no tenga que acceder a los
        // detalles internos de Direccion.
    }

}

package ar.edu.ubp.das.ejemplo10.refact;

public class Run {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("ATAHUALPA MAS", "atahmas@ubp.edu.ar");
        Pedido pedido = new Pedido(cliente, "2024-00123456", 150.50);
        pedido.mostrarDetallePedido();

        // Refactorización aplicada: "Encapsulate Field" (Encapsular campo) la clase
        // Pedido accedía directamente a los atributos nombre y email de la clase
        // Cliente. Esto violaba el principio de encapsulación, ya que otras clases
        // podían manipular o acceder directamente a los datos internos de Cliente.
        // Se encapsularon los atributos nombre y email en la clase Cliente haciéndolos
        // privados y proporcionando métodos getters (getNombre() y getEmail()) para
        // acceder a estos datos.
    }

}

package ar.edu.ubp.das.ejemplo06.refact;

public class Run {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("ATAHUALPA MAS", "atahmas@ubp.edu.ar", 6);
        Pedido pedido = new Pedido(1000, cliente);
        System.out.println("Monto con descuento: " + pedido.aplicarDescuento());

        // Refactorización aplicada: "Move Method" (Mover método) el método calcularDescuento() dentro
        // de la clase Pedido accedía más a los atributos de la clase Cliente
        // (como getAntiguedad()) que a los atributos de Pedido.
        // Esto indicaba que el método pertenecía más naturalmente a la clase Cliente,
        // ya que el descuento está relacionado con la antigüedad del cliente.
    }

}

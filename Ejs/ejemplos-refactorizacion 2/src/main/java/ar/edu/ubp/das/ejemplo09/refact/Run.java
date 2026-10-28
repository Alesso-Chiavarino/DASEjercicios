package ar.edu.ubp.das.ejemplo09.refact;

public class Run {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("ATAHUALPA MAS", "atahmas@ubp.edu.ar");
        Pedido pedido = new Pedido(cliente, "2024-00123456", 150.50);
        pedido.mostrarDetallePedido();

        // Refactorización aplicada: "Remove Middle Man" (Eliminar intermediario) la clase
        // ClienteEngine no añadía ningún valor, ya que solo delegaba las llamadas de la
        // clase Pedido a la clase Cliente. Esta clase intermediaria actuaba como un
        // "middle man" innecesario, lo que complicaba el diseño sin razón justificada.
        // Se eliminó la clase ClienteEngine, permitiendo que la clase Pedido
        // interactuara directamente con la clase Cliente.
    }

}

package ar.edu.ubp.das.ej18_cambiodivergente;

public class Run {

    public static void main(String[] args) {
        Pedido pedido = new Pedido(101, "Ferretería López");
        pedido.agregarItem(new Item("Taladro", 2, 48000));
        pedido.agregarItem(new Item("Mechas x10", 3, 6500));

        System.out.println("Total: $" + pedido.calcularTotal());
        System.out.print(pedido.exportarCSV());
        System.out.println(pedido.exportarJSON());
        pedido.guardar();
        pedido.borrar();
    }

}

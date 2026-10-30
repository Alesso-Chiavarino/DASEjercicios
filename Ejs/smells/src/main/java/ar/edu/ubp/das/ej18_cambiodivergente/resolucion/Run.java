package ar.edu.ubp.das.ej18_cambiodivergente.resolucion;

public class Run {

    public static void main(String[] args) {
        Pedido pedido = new Pedido(101, "Ferretería López");
        pedido.agregarItem(new Item("Taladro", 2, 48000));
        pedido.agregarItem(new Item("Mechas x10", 3, 6500));

        ExportadorPedidos exportador = new ExportadorPedidos();
        RepositorioPedidos repositorio = new RepositorioPedidos();

        System.out.println("Total: $" + pedido.calcularTotal());
        System.out.print(exportador.exportarCSV(pedido));
        System.out.println(exportador.exportarJSON(pedido));
        repositorio.guardar(pedido);
        repositorio.borrar(pedido);
    }

}

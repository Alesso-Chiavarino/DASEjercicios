package ar.edu.ubp.das.ej18_cambiodivergente.resolucion;

public class RepositorioPedidos {

    public void guardar(Pedido pedido) {
        System.out.println("INSERT INTO pedidos (numero, cliente, total) VALUES (" + pedido.getNumero() + ", '"
                + pedido.getCliente() + "', " + pedido.calcularTotal() + ");");
        for (Item item : pedido.getItems()) {
            System.out.println("INSERT INTO items (pedido, producto, cantidad) VALUES (" + pedido.getNumero() + ", '"
                    + item.getProducto() + "', " + item.getCantidad() + ");");
        }
    }

    public void borrar(Pedido pedido) {
        System.out.println("DELETE FROM items WHERE pedido = " + pedido.getNumero() + ";");
        System.out.println("DELETE FROM pedidos WHERE numero = " + pedido.getNumero() + ";");
    }

}

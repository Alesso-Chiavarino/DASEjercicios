package ar.edu.ubp.das.ej18_cambiodivergente.resolucion;

public class ExportadorPedidos {

    public String exportarCSV(Pedido pedido) {
        String csv = "numero;cliente;producto;cantidad;precio\n";
        for (Item item : pedido.getItems()) {
            csv += pedido.getNumero() + ";" + pedido.getCliente() + ";" + item.getProducto() + ";"
                    + item.getCantidad() + ";" + item.getPrecio() + "\n";
        }
        return csv;
    }

    public String exportarJSON(Pedido pedido) {
        String json = "{\"numero\": " + pedido.getNumero() + ", \"cliente\": \"" + pedido.getCliente()
                + "\", \"total\": " + pedido.calcularTotal() + "}";
        return json;
    }

}

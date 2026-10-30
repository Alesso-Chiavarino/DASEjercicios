package ar.edu.ubp.das.ejemplo17.refact;

public class Tienda {

    private Inventario inventario;
    private GestorClientes clientes;
    private RegistroVentas ventas;

    public Tienda() {
        this.inventario = new Inventario();
        this.clientes = new GestorClientes();
        this.ventas = new RegistroVentas();
    }

    public Inventario getInventario() {
        return inventario;
    }

    public GestorClientes getClientes() {
        return clientes;
    }

    public RegistroVentas getVentas() {
        return ventas;
    }

    public void vender(String cliente, String producto, double monto) {
        inventario.descontarUnidad(producto);
        clientes.sumarPuntos(cliente, (int) (monto / 100));
        ventas.registrar(cliente, producto, monto);
    }

}

package ar.edu.ubp.das.ej2;

public class GestorCliente {

    private final Cliente cliente;

    public GestorCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String obtenerNombre() { return cliente.getNombre(); }
    public String obtenerDni() { return cliente.getDni(); }
    public int obtenerPuntos() { return cliente.getPuntos(); }
    public String obtenerCategoria() { return cliente.getCategoria(); }

    public void sumarPuntos(int puntos) {
        cliente.setPuntos(cliente.getPuntos() + puntos);
    }

    public boolean aplicaDescuentoPrefer() {
        return "ORO".equals(cliente.getCategoria()) || "PLATA".equals(cliente.getCategoria());
    }

}

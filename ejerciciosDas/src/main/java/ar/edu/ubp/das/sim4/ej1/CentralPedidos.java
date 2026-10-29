package ar.edu.ubp.das.sim4.ej1;

public class CentralPedidos {

    private Despacho despacho;
    private Ticket ticket;
    private ReporteDiario reporte;

    public CentralPedidos() {
        this.despacho = new Despacho();
        this.ticket = new Ticket();
        this.reporte = new ReporteDiario();
    }

    public Pedido crearPedido(String cliente, double distanciaKm) {
        return despacho.crearPedido(cliente, distanciaKm);
    }

    public void asignar(Pedido pedido, Repartidor repartidor) {
        despacho.asignar(pedido, repartidor);
    }

    public void entregar(Pedido pedido) {
        despacho.entregar(pedido);
    }

    public void imprimirTicket(Pedido pedido) {
        ticket.imprimir(pedido);
    }

    public void imprimirReporte() {
        reporte.imprimir(despacho.getPedidos());
    }

}

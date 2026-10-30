package ar.edu.ubp.das.ejemplo17.refact;

public class RegistroVentas {

    private double totalVendido;

    public RegistroVentas() {
        this.totalVendido = 0;
    }

    public void registrar(String cliente, String producto, double monto) {
        totalVendido += monto;
        System.out.println("Venta registrada: " + producto + " a " + cliente + " por $" + monto);
    }

    public double getTotalVendido() {
        return totalVendido;
    }

}

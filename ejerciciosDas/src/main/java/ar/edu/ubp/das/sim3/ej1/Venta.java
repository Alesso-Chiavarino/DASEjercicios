package ar.edu.ubp.das.sim3.ej1;

public class Venta {

    private String medicamento;
    private int cantidad;
    private String obraSocial;
    private double descuento;
    private double importe;

    public Venta(String medicamento, int cantidad, String obraSocial, double descuento, double importe) {
        this.medicamento = medicamento;
        this.cantidad = cantidad;
        this.obraSocial = obraSocial;
        this.descuento = descuento;
        this.importe = importe;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public double getDescuento() {
        return descuento;
    }

    public double getImporte() {
        return importe;
    }

}

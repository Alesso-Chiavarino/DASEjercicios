package ar.edu.ubp.das.ejemplo19.refact;

public class CalculadorPrecio {

    private static final double ALICUOTA_IVA = 1.21;
    private static final int ANTIGUEDAD_MINIMA_DESCUENTO = 5;
    private static final double FACTOR_DESCUENTO_ANTIGUEDAD = 0.9;

    public double calcularTotalConIVA(Pedido pedido) {
        double subtotal = sumarPrecios(pedido);
        double conDescuento = aplicarDescuentoPorAntiguedad(subtotal, pedido);
        return agregarIVA(conDescuento);
    }

    private double sumarPrecios(Pedido pedido) {
        double subtotal = 0;
        for (double precio : pedido.getPrecios()) {
            subtotal += precio;
        }
        return subtotal;
    }

    private double aplicarDescuentoPorAntiguedad(double subtotal, Pedido pedido) {
        if (pedido.getAntiguedadCliente() > ANTIGUEDAD_MINIMA_DESCUENTO) {
            return subtotal * FACTOR_DESCUENTO_ANTIGUEDAD;
        }
        return subtotal;
    }

    private double agregarIVA(double monto) {
        return monto * ALICUOTA_IVA;
    }

}

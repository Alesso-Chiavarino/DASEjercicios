package ar.edu.ubp.das.ej1;

import java.util.List;
import java.util.Map;

public class CalcularMiCarrito {

    private Double porcentajePromoTemporal = null;
    private Integer cuotasTemporales = null;
    private Double impuestoExtraTemporal = null;

    //Supongamos la siguiente fuente de datos
    private final Map<String, Double> precios = Map.of(
        "mate", 2500.0,
        "yerba", 1800.0,
        "termo", 12000.0,
        "azucar", 700.0,
        "bombilla", 150.0
    );

    public void configurarPromocionTemporal(double porcentaje) {
        this.porcentajePromoTemporal = porcentaje;
    }

    public void configurarCuotasTemporales(int cuotas) {
        this.cuotasTemporales = cuotas;
    }

    public void configurarImpuestoExtraTemporal(double porcExtra) {
        this.impuestoExtraTemporal = porcExtra;
    }

    public void limpiarConfiguracion() {
        this.porcentajePromoTemporal = null;
        this.cuotasTemporales = null;
        this.impuestoExtraTemporal = null;
    }

    public double totalEfectivo(List<String> items, int cantidad) {
        double subtotal = 0;
        for (String item : items) {
            Double precio = precios.get(item.toLowerCase());
            if (precio != null) subtotal += precio * cantidad;
        }
        double descuentoBasico = (subtotal > 10000) ? subtotal * 0.05 : 0.0;

        double descuentoPromo = 0.0;
        if (porcentajePromoTemporal != null) {
            descuentoPromo = subtotal * (porcentajePromoTemporal / 100.0);
        }

        double impuestos = subtotal * 0.21;
        if (impuestoExtraTemporal != null) {
            impuestos += subtotal * (impuestoExtraTemporal / 100.0);
        }

        return subtotal - (descuentoBasico + descuentoPromo) + impuestos;
    }

    public double totalTarjeta(List<String> items, int cantidad) {
        double subtotal = 0;
        for (String item : items) {
            Double precio = precios.get(item.toLowerCase());
            if (precio != null) subtotal += precio * cantidad;
        }
        double descuentoBasico = (subtotal > 10000) ? subtotal * 0.05 : 0.0;

        double descuentoPromo = 0.0;
        if (porcentajePromoTemporal != null) {
            descuentoPromo = subtotal * (porcentajePromoTemporal / 100.0);
        }

        double impuestos = subtotal * 0.21;
        if (impuestoExtraTemporal != null) {
            impuestos += subtotal * (impuestoExtraTemporal / 100.0);
        }

        int cuotas = (cuotasTemporales == null) ? 1 : cuotasTemporales;
        double recargoTarjeta = (cuotas > 3) ? subtotal * 0.08 : subtotal * 0.02;

        return subtotal - (descuentoBasico + descuentoPromo) + impuestos + recargoTarjeta;
    }

}

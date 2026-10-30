package ar.edu.ubp.das.ejemplo20.original;

// SMELL: Duplicated Code — los dos métodos repiten exactamente la misma suma de precios.
// Si mañana la suma necesita ignorar precios negativos o aplicar redondeo, hay que tocar
// los dos lugares y es fácil olvidarse de uno.
// Refactor sugerida: Extract Method (sumarPrecios) para que la fórmula viva en un solo lugar.
public class CalculadorPrecios {

    public double totalConIVA(double[] precios) {
        // SMELL: Duplicated Code — este for es idéntico al de totalConDescuento().
        double total = 0;
        for (double precio : precios) {
            total += precio;
        }
        return total * 1.21;
    }

    public double totalConDescuento(double[] precios, double descuento) {
        // SMELL: Duplicated Code — misma suma de precios copiada.
        double total = 0;
        for (double precio : precios) {
            total += precio;
        }
        return total - (total * descuento / 100);
    }

}

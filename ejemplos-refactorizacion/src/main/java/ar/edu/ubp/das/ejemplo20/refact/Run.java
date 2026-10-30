package ar.edu.ubp.das.ejemplo20.refact;

public class Run {

    public static void main(String[] args) {
        double[] precios = { 100.0, 200.0, 50.0 };

        CalculadorPrecios calculador = new CalculadorPrecios();

        System.out.println("Total con IVA: " + calculador.totalConIVA(precios));
        System.out.println("Total con 10% de descuento: " + calculador.totalConDescuento(precios, 10));

        // Refactorización aplicada: "Extract Method" (Extraer Método). La suma de
        // precios estaba duplicada en totalConIVA() y totalConDescuento(). Se extrajo
        // a un método privado sumarPrecios(). Ahora la fórmula vive en un único lugar:
        // si cambia (por ejemplo, ignorar precios negativos), se modifica una sola vez.
    }

}

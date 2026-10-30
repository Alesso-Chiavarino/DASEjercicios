package ar.edu.ubp.das.ejemplo01.refact;

public class Run {

    public static void main(String[] args) {
        double items[] = { 10.50, 20.00, 5.50, 46.00, 18.00 };

        Pedido pedidoRef = new Pedido(items);
        pedidoRef.imprimirFactura(10);

        // Refactorización aplicada: "Replace Temp with Query" (Reemplazar atributo
        // temporal con consulta) el problema surgía porque la clase tenía un
        // atributo temporal que solo era relevante en ciertos contextos
        // (el atributo totalConDescuento).
        // Para resolver esto, eliminamos el atributo temporal y reemplazamos su uso
        // con un cálculo o consulta directa en el método imprimirFactura.
    }

}

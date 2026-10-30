package ar.edu.ubp.das.ejemplo19.refact;

public class Run {

    public static void main(String[] args) {
        Pedido pedido = new Pedido(new double[]{ 100.0, 200.0, 50.0 }, 7);
        CalculadorPrecio calculador = new CalculadorPrecio();
        System.out.println("Total: " + calculador.calcularTotalConIVA(pedido));

        // Refactorización aplicada: "Extract Method" + "Rename". Los comentarios que
        // explicaban qué hacía cada bloque ("sumo los precios", "le sumo el IVA") se
        // reemplazaron por métodos con nombres descriptivos (sumarPrecios,
        // aplicarDescuentoPorAntiguedad, agregarIVA). Las variables también se
        // renombraron (t → subtotal, x → precio) y los números mágicos quedaron como
        // constantes con nombre. Ahora el código se lee solo y los comentarios
        // sobran.
    }

}

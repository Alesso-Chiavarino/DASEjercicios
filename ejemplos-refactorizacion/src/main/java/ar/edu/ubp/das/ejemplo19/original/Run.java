package ar.edu.ubp.das.ejemplo19.original;

public class Run {

    public static void main(String[] args) {
        Pedido pedido = new Pedido(new double[]{ 100.0, 200.0, 50.0 }, 7);
        CalculadorPrecio calculador = new CalculadorPrecio();
        System.out.println("Total: " + calculador.calcular(pedido));
    }

}

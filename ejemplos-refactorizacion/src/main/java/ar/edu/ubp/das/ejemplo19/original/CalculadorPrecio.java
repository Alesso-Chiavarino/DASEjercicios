package ar.edu.ubp.das.ejemplo19.original;

// SMELL: Comments — los comentarios "/ sumo los precios", "/ si tiene más de 5 años..."
// están tapando que el método hace varias cosas con nombres pobres (t, x).
// Son "desodorante" sobre código poco claro.
// Refactor sugerida: Extract Method + Rename (los nombres de los métodos reemplazan al comentario).
public class CalculadorPrecio {

    public double calcular(Pedido p) {
        // SMELL: Comments — este comentario describe el "qué" porque la variable 't' no lo dice.
        // sumo los precios
        double t = 0;
        for (double x : p.getPrecios()) {
            t += x;
        }
        // SMELL: Comments — comentario que debería ser el nombre de un método.
        // si tiene más de 5 años, 10% de descuento
        if (p.getAntiguedadCliente() > 5) {
            t = t * 0.9;
        }
        // SMELL: Comments — otro bloque que pide ser un método con nombre.
        // le sumo el IVA
        return t * 1.21;
    }

}

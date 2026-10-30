package ar.edu.ubp.das.ejemplo10.original;

// SMELL: Inappropriate Intimacy — atributos sin modificador (package-private)
// permiten que otras clases del mismo paquete (Pedido) accedan directo a ellos.
// Refactor sugerida: Encapsulate Field (ponerlos private y exponer getters).
public class Cliente
{
    // SMELL: Inappropriate Intimacy — sin 'private', Pedido lee cliente.nombre y cliente.email directamente.
    String nombre;
    String email;

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

}

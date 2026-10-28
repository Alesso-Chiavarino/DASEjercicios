package ar.edu.ubp.das.ejemplo05.refact;

public class Run {

    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("ATAHUALPA MAS", 1000.00);
        cuenta.consultarSaldo();
        cuenta.depositar(500.00);
        cuenta.retirar(2000.00);
        cuenta.retirar(300.00);
        cuenta.consultarSaldo();

        // Refactorizaciones aplicadas:
        // "Encapsulate Field" (Encapsular Campo): Los atributos saldo y titular están
        // encapsulados en la clase. No se exponen setters para cambiar el saldo
        // directamente desde fuera. Los cambios en el saldo solo pueden realizarse
        // a través de los métodos depositar y retirar, que contienen la lógica
        // necesaria para manejar esas operaciones de forma segura.
        // "Move Method" (Mover Método): Las operaciones bancarias que podrían haberse
        // dispersado en otras clases como son depositar y retirar se movieron dentro
        // de la clase CuentaBancaria, donde tienen más sentido. Esto asegura que
        // CuentaBancaria gestione sus propios datos y el comportamiento relacionado,
        // lo que mejora la cohesión.
    }

}

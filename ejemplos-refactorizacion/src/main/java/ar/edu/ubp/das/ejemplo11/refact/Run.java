package ar.edu.ubp.das.ejemplo11.refact;

public class Run {

    public static void main(String[] args) {
        Empleado empleadoTiempoCompleto = new EmpleadoTiempoCompleto("ATAHUALPA MAS");
        Empleado empleadoMedioTiempo = new EmpleadoTiempoParcial("TUPAC DUPLO");

        System.out.println("Pago de empleado tiempo completo: " + empleadoTiempoCompleto.calcularPago());
        System.out.println("Pago de empleado medio tiempo: " + empleadoMedioTiempo.calcularPago());

        // Refactorización aplicada: "Replace Inheritance with Delegation" (Reemplazar
        // la herencia por delegación) teníamos dos jerarquías paralelas una para los
        // tipos de empleados y otra para las estrategias de pago. Cada vez que se
        // creara un nuevo tipo de empleado, también se tenía que crear una nueva
        // subclase de pago, lo que duplicaba el código y hacía que el sistema fuera
        // difícil de mantener.
        // En lugar de tener una jerarquía de herencia paralela para las estrategias
        // de pago, se utilizó delegación (composición). Los empleados ahora tienen
        // una estrategia de pago (delegan la responsabilidad del cálculo de pagos),
        // en lugar de depender de la herencia. Esto permite que las estrategias de pago
        // sean reutilizables y evita la duplicación de clases.
    }

}

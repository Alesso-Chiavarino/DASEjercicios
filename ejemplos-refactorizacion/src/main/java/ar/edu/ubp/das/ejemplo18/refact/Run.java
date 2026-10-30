package ar.edu.ubp.das.ejemplo18.refact;

public class Run {

    public static void main(String[] args) {
        Factura factura = new Factura(1000);
        System.out.println("Total con IVA: " + factura.calcularTotal());

        // Refactorización aplicada: "Inline Class" (poner la clase en línea).
        // CalculadoraIVA era una "Lazy Class": no tenía estado, no tenía reglas propias
        // y sólo la usaba Factura para hacer 'monto * 0.21'. Se eliminó y su contenido
        // pasó directamente a Factura. La alícuota quedó como constante para que, si
        // alguna vez vuelve a aparecer en más lugares, pueda extraerse de nuevo.
    }

}

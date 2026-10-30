package ar.edu.ubp.das.ejemplo22.original;

// SMELL: Long Method — calcular() hace muchas cosas: calcula base, bonos, aportes,
// impuestos e imprime el detalle. Cada bloque se puede entender solo, pero vive
// atrapado entre los otros, no se puede reutilizar ni testear por separado.
// Los comentarios que separan secciones son la pista: cada uno pide ser un método.
// Refactor sugerida: Extract Method (uno por bloque, con un nombre claro).
public class CalculadorNomina {

    public double calcular(Empleado empleado) {
        // SMELL: Long Method — bloque "calcular salario base".
        double base = empleado.getSueldoHora() * empleado.getHorasTrabajadas();

        // SMELL: Long Method — bloque "sumar bonos".
        double bonos = 0;
        if (empleado.getAntiguedad() > 5) {
            bonos += base * 0.10;
        }
        if (empleado.esProfesional()) {
            bonos += base * 0.05;
        }
        double subtotal = base + bonos;

        // SMELL: Long Method — bloque "aplicar deducciones".
        double aportes = subtotal * 0.11;
        double impuesto = subtotal * 0.05;
        double neto = subtotal - aportes - impuesto;

        // SMELL: Long Method — bloque "imprimir recibo" mezclado con la cuenta.
        System.out.println("Recibo de " + empleado.getNombre());
        System.out.println("Base: " + base);
        System.out.println("Bonos: " + bonos);
        System.out.println("Aportes: " + aportes);
        System.out.println("Impuesto: " + impuesto);
        System.out.println("Neto: " + neto);

        return neto;
    }

}

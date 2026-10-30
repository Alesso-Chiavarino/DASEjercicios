package ar.edu.ubp.das.ej06_atributotemporal;

public class Run {

    public static void main(String[] args) {
        Liquidador liquidador = new Liquidador();

        Empleado ana = new Empleado("Ana", 900000);
        Empleado luis = new Empleado("Luis", 750000);

        System.out.println("Caso 1: sueldo básico");
        liquidador.liquidar(ana);

        System.out.println("\nCaso 2: con horas extra");
        liquidador.prepararHorasExtra(10, 3000);
        liquidador.liquidar(ana);

        System.out.println("\nCaso 3: otro empleado (las horas extra quedaron cargadas)");
        liquidador.liquidar(luis);

        System.out.println("\nCaso 4: limpiamos y cargamos un bono");
        liquidador.limpiar();
        liquidador.prepararBono("presentismo", 20000);
        liquidador.liquidar(luis);
    }

}

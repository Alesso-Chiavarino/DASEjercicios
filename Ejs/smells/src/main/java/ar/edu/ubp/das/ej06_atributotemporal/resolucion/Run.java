package ar.edu.ubp.das.ej06_atributotemporal.resolucion;

public class Run {

    public static void main(String[] args) {
        Liquidador liquidador = new Liquidador();

        Empleado ana = new Empleado("Ana", 900000);
        Empleado luis = new Empleado("Luis", 750000);

        System.out.println("Caso 1: sueldo básico");
        liquidador.liquidar(ana);

        System.out.println("\nCaso 2: con horas extra");
        liquidador.liquidar(ana, 10, 3000);

        System.out.println("\nCaso 3: otro empleado (las horas extra quedaron cargadas)");
        liquidador.liquidar(luis, 10, 3000);

        System.out.println("\nCaso 4: limpiamos y cargamos un bono");
        liquidador.liquidar(luis, "presentismo", 20000);
    }

}

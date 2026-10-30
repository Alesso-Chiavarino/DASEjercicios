package ar.edu.ubp.das.ejemplo03.original;

public class Run {

    public static void main(String[] args) {
        Empleado emp = new Empleado("ATAHUALPA MAS", 50000, 5000);
        emp.guardarEmpleado();
        emp.calcularSalarioTotal();
        System.out.println(emp.generarInforme());
    }

}

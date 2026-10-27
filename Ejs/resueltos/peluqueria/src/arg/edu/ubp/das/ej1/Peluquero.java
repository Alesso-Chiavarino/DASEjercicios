package arg.edu.ubp.das.ej1;

public class Peluquero {

    private String nombre;
    private String especialidad;
    private double salario;

    public Peluquero(String nombre,
                     String especialidad,
                     double salario) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.salario = salario;
    }

    public void calcularPagoMensual(double totalServicios) {
        double monto = this.salario + (totalServicios * 0.10);
        System.out.println("Pago mensual de " + this.nombre + ": " + monto);
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public double getSalario() {
        return salario;
    }

}

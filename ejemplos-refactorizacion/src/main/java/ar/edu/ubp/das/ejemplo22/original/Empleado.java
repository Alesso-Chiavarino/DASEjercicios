package ar.edu.ubp.das.ejemplo22.original;

public class Empleado {

    private String nombre;
    private double sueldoHora;
    private int horasTrabajadas;
    private int antiguedad;
    private boolean profesional;

    public Empleado(String nombre, double sueldoHora, int horasTrabajadas, int antiguedad, boolean profesional) {
        this.nombre = nombre;
        this.sueldoHora = sueldoHora;
        this.horasTrabajadas = horasTrabajadas;
        this.antiguedad = antiguedad;
        this.profesional = profesional;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldoHora() {
        return sueldoHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public boolean esProfesional() {
        return profesional;
    }

}

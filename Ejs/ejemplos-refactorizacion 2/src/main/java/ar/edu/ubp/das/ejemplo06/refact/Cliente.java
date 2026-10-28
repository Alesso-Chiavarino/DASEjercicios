package ar.edu.ubp.das.ejemplo06.refact;

public class Cliente {

    private String nombre;
    private String email;
    private int antiguedad;

    public Cliente(String nombre, String email, int antiguedad) {
        this.nombre = nombre;
        this.email = email;
        this.antiguedad = antiguedad;
    }

    public double calcularDescuento(double montoTotal) {
        if (antiguedad > 5 && email.contains(".edu")) {
            return montoTotal * 0.15;
        }
        else if (antiguedad > 2) {
            return montoTotal * 0.05;
        }
        else {
            return 0;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

}

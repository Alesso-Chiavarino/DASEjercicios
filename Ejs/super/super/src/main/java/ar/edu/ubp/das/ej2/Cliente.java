package ar.edu.ubp.das.ej2;

class Cliente {

    private String dni;
    private String nombre;
    private int puntos;
    private String categoria;

    public Cliente(String dni, String nombre, int puntos, String categoria) {
        this.dni = dni;
        this.nombre = nombre;
        this.puntos = puntos;
        this.categoria = categoria;
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public int getPuntos() { return puntos; }
    public String getCategoria() { return categoria; }

    public void setPuntos(int puntos) { this.puntos = puntos; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

}
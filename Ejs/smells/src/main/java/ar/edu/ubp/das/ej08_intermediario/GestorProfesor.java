package ar.edu.ubp.das.ej08_intermediario;

public class GestorProfesor {

    private Profesor profesor;

    public GestorProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String obtenerNombre() {
        return profesor.getNombre();
    }

    public String obtenerEmail() {
        return profesor.getEmail();
    }

    public void actualizarEmail(String email) {
        profesor.setEmail(email);
    }

    public int obtenerHorasSemanales() {
        return profesor.getHorasSemanales();
    }

}

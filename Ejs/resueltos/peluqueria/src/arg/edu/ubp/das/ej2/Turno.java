package arg.edu.ubp.das.ej2;

public class Turno {
    private DatosEnvio datosEnvio;
    private String fecha;
    private String hora;
    private double monto;

    private boolean finalizado;

    public Turno() {
    }

    public Turno(DatosEnvio datosEnvio, String fecha, String hora, double monto) {
        this.datosEnvio = datosEnvio;
        this.fecha = fecha;
        this.hora = hora;
        this.monto = monto;
    }

    public DatosEnvio getDatosEnvio() {
        return datosEnvio;
    }

    public void setDatosEnvio(DatosEnvio datosEnvio) {
        this.datosEnvio = datosEnvio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }
}

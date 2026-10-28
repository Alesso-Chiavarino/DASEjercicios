package arg.edu.ubp.das.ej2;

public class DatosEnvio {
    private String nombreCliente;
    private String telefonoCliente;
    private String nombrePeluquero;
    private String especialidadPeluquero;

    public DatosEnvio() {
    }

    public DatosEnvio(String nombreCliente,
                      String telefonoCliente,
                      String nombrePeluquero,
                      String especialidadPeluquero) {
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.nombrePeluquero = nombrePeluquero;
        this.especialidadPeluquero = especialidadPeluquero;
    }

    public String getEspecialidadPeluquero() {
        return especialidadPeluquero;
    }

    public void setEspecialidadPeluquero(String especialidadPeluquero) {
        this.especialidadPeluquero = especialidadPeluquero;
    }

    public String getNombrePeluquero() {
        return nombrePeluquero;
    }

    public void setNombrePeluquero(String nombrePeluquero) {
        this.nombrePeluquero = nombrePeluquero;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }


}

package ar.edu.ubp.das.ej3.ref;

import java.util.Date;

class Envio {

    public void procesarEnvio(Direccion direccion, Date fechaEnvio) {
        System.out.println("Procesando envío:");
        System.out.println("Fecha: " + fechaEnvio);
        System.out.println("Calle: " + direccion.getCalle());
        System.out.println("Ciudad: " + direccion.getCiudad());
        System.out.println("Código Postal: " + direccion.getCodigoPostal());
    }
}

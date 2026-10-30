package ar.edu.ubp.das.ej23_bibliotecaincompleta.resolucion;

public class Comprobante {

    public void imprimir(Cliente cliente, Empleado empleado, double monto, String cbuDestino) {
        System.out.println("Cliente: " + cliente.getNombreFormateado() + " - Tarjeta: " + cliente.getTarjetaOculta());
        System.out.println("Atendió: " + empleado.getApellidoFormateado() + " (legajo " + empleado.getLegajo() + ")");
        System.out.println("Monto: $" + monto + " - CBU destino: " + UtilidadesTexto.enmascarar(cbuDestino));
    }

}

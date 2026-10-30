package ar.edu.ubp.das.ej01_codigoduplicado.resolucion;

public class Gimnasio {

    public void cobrarMensual(Socio socio) {
        double cuota = socio.getCuotaBase();
        cobrar("mensual", socio, cuota);
    }

    public void cobrarAnual(Socio socio) {
        double cuota = socio.getCuotaBase() * 12;
        double descuento = cuota * 0.15;
        cuota = cuota - descuento;
        cobrar("anual", socio, cuota);
    }

    private void cobrar(String tipo, Socio socio, double cuota) {
        double recargo = 0;
        if (socio.getMesesAdeudados() > 0) {
            recargo = socio.getCuotaBase() * 0.10 * socio.getMesesAdeudados();
        }
        double total = cuota + recargo;
        System.out.println("Cobro " + tipo + " a " + socio.getNombre());
        System.out.println("  Cuota: $" + cuota);
        System.out.println("  Recargo por mora: $" + recargo);
        System.out.println("  Total: $" + total);
    }

}

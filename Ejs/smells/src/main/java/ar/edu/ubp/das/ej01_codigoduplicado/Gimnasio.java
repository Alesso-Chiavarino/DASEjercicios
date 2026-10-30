package ar.edu.ubp.das.ej01_codigoduplicado;

public class Gimnasio {

    public void cobrarMensual(Socio socio) {
        double cuota = socio.getCuotaBase();
        double recargo = 0;
        if (socio.getMesesAdeudados() > 0) {
            recargo = socio.getCuotaBase() * 0.10 * socio.getMesesAdeudados();
        }
        double total = cuota + recargo;
        System.out.println("Cobro mensual a " + socio.getNombre());
        System.out.println("  Cuota: $" + cuota);
        System.out.println("  Recargo por mora: $" + recargo);
        System.out.println("  Total: $" + total);
    }

    public void cobrarAnual(Socio socio) {
        double cuota = socio.getCuotaBase() * 12;
        double descuento = cuota * 0.15;
        cuota = cuota - descuento;
        double recargo = 0;
        if (socio.getMesesAdeudados() > 0) {
            recargo = socio.getCuotaBase() * 0.10 * socio.getMesesAdeudados();
        }
        double total = cuota + recargo;
        System.out.println("Cobro anual a " + socio.getNombre());
        System.out.println("  Cuota: $" + cuota);
        System.out.println("  Recargo por mora: $" + recargo);
        System.out.println("  Total: $" + total);
    }

}

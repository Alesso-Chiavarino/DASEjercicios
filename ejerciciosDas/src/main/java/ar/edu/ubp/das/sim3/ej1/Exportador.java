package ar.edu.ubp.das.sim3.ej1;

import java.util.List;

public interface Exportador {

    String exportar(List<Venta> ventas);

    String exportarXML(List<Venta> ventas);

    String exportarJSON(List<Venta> ventas);

}

package ar.edu.ubp.das.sim3.ej1;

import java.util.List;

public class ExportadorCSV implements Exportador {

    @Override
    public String exportar(List<Venta> ventas) {
        StringBuilder sb = new StringBuilder();
        sb.append("medicamento;cantidad;obra_social;importe\n");
        for (Venta v : ventas) {
            sb.append(v.getMedicamento()).append(";")
              .append(v.getCantidad()).append(";")
              .append(v.getObraSocial()).append(";")
              .append(v.getImporte()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String exportarXML(List<Venta> ventas) {
        return null;
    }

    @Override
    public String exportarJSON(List<Venta> ventas) {
        return null;
    }

}

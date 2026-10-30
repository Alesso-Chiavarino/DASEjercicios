package ar.edu.ubp.das.ejemplo21.original;

public class Run {

    public static void main(String[] args) {
        Reporte reporte = new Reporte("Ventas 2026", "Total: $1.000.000");
        ExportadorBase exportador = new ExportadorPDF();
        exportador.exportar(reporte, "PDF", false, "es", 1);
    }

}

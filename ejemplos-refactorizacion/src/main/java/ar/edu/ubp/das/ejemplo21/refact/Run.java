package ar.edu.ubp.das.ejemplo21.refact;

public class Run {

    public static void main(String[] args) {
        Reporte reporte = new Reporte("Ventas 2026", "Total: $1.000.000");
        ExportadorPDF exportador = new ExportadorPDF();
        exportador.exportar(reporte);

        // Refactorización aplicada: "Collapse Hierarchy" + "Remove Parameter".
        // ExportadorBase era una abstracción "por si acaso" con una única implementación
        // (ExportadorPDF). Se eliminó la clase base y el hook antesDeExportar() que
        // nadie redefinía. Los parámetros 'formato', 'comprimir', 'idioma' y 'version'
        // siempre valían lo mismo, así que también se quitaron (YAGNI). Si en el futuro
        // aparece ExportadorExcel, se agrega la abstracción recién en ese momento.
    }

}

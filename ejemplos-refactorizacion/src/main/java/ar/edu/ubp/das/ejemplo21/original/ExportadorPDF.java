package ar.edu.ubp.das.ejemplo21.original;

// SMELL: Speculative Generality — única subclase de ExportadorBase. La abstracción no se justifica.
public class ExportadorPDF extends ExportadorBase {

    @Override
    public void exportar(Reporte reporte, String formato, boolean comprimir, String idioma, int version) {
        System.out.println("Exportando a PDF: " + reporte.getTitulo());
        System.out.println("Contenido: " + reporte.getContenido());
    }

}

package ar.edu.ubp.das.ejemplo21.refact;

public class ExportadorPDF {

    public void exportar(Reporte reporte) {
        System.out.println("Exportando a PDF: " + reporte.getTitulo());
        System.out.println("Contenido: " + reporte.getContenido());
    }

}

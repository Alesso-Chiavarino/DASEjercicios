package ar.edu.ubp.das.ejemplo21.original;

// SMELL: Speculative Generality — jerarquía abstracta "por si en el futuro aparecen otros formatos".
// Hoy sólo existe ExportadorPDF, los parámetros 'comprimir', 'idioma' y 'version' siempre llegan
// con el mismo valor, y antesDeExportar() no lo usa nadie.
// Refactor sugerida: Collapse Hierarchy + Remove Parameter + borrar el hook sin uso.
public abstract class ExportadorBase {

    // SMELL: Speculative Generality — parámetros que nunca varían en los llamadores.
    public abstract void exportar(Reporte reporte, String formato, boolean comprimir, String idioma, int version);

    // SMELL: Speculative Generality — hook declarado "por si alguna subclase lo necesita". Nadie lo redefine.
    protected void antesDeExportar() {
    }

}

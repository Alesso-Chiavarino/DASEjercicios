package ar.edu.ubp.das.ej12_agrupacioncondicional.resolucion;

public class Run {

    public static void main(String[] args) {
        Boleteria boleteria = new Boleteria(6000);

        boleteria.vender(new EntradaGeneral("Dune"));
        boleteria.vender(new EntradaEstudiante("Dune"));
        boleteria.vender(new EntradaJubilado("Coco"));
        boleteria.vender(new EntradaVip("Coco"));
    }

}

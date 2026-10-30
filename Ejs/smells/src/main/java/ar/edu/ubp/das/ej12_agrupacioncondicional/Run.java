package ar.edu.ubp.das.ej12_agrupacioncondicional;

public class Run {

    public static void main(String[] args) {
        Boleteria boleteria = new Boleteria(6000);

        boleteria.vender(new Entrada("Dune", "GENERAL"));
        boleteria.vender(new Entrada("Dune", "ESTUDIANTE"));
        boleteria.vender(new Entrada("Coco", "JUBILADO"));
        boleteria.vender(new Entrada("Coco", "VIP"));
    }

}

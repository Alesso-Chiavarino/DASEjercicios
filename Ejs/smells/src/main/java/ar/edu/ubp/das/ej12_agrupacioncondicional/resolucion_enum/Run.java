package ar.edu.ubp.das.ej12_agrupacioncondicional.resolucion_enum;

public class Run {

    public static void main(String[] args) {
        Boleteria boleteria = new Boleteria(6000);

        boleteria.vender(new Entrada("Dune", TipoEntrada.GENERAL));
        boleteria.vender(new Entrada("Dune", TipoEntrada.ESTUDIANTE));
        boleteria.vender(new Entrada("Coco", TipoEntrada.JUBILADO));
        boleteria.vender(new Entrada("Coco", TipoEntrada.VIP));
    }

}

package ar.edu.ubp.das.sim3.ej2;

public class Run {

    public static void main(String[] args) {
        Aseguradora aseguradora = new Aseguradora("Seguros La Docta");

        aseguradora.emitirPoliza(new Auto("AE111AA", 18000000, true));
        aseguradora.emitirPoliza(new Auto("AF222BB", 25000000, false));
        aseguradora.emitirPoliza(new Moto("A123BCD", 4000000, 300));
        aseguradora.emitirPoliza(new Moto("A456EFG", 2500000, 110));
        aseguradora.emitirPoliza(new Camion("AD333CC", 60000000, 12));

        aseguradora.imprimirCartera();
    }

}

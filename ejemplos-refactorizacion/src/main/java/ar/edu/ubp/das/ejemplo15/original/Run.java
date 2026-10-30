package ar.edu.ubp.das.ejemplo15.original;

public class Run {

    public static void main(String[] args) {
        EnvioMaritimo envioMaritimo = new EnvioMaritimo();
        EnvioTerrestre envioTerrestre = new EnvioTerrestre();

        double peso = 10.0;
        double distancia = 100.0;

        System.out.println("Costo de envío marítimo: " + envioMaritimo.calcularTarifa(peso, distancia));
        System.out.println("Costo de envío terrestre: " + envioTerrestre.calcularCosto(peso, distancia));
    }

}

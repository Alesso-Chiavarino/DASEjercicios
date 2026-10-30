package ar.edu.ubp.das.ejemplo15.refact;

public class Run {

    public static void main(String[] args) {
        ServicioEnvio envioMaritimo = new EnvioMaritimo();
        ServicioEnvio envioTerrestre = new EnvioTerrestre();

        double peso = 10.0;
        double distancia = 100.0;

        System.out.println("Costo de envío marítimo: " + envioMaritimo.calcularCostoEnvio(peso, distancia));
        System.out.println("Costo de envío terrestre: " + envioTerrestre.calcularCostoEnvio(peso, distancia));

        // Refactorización realizada: "Introduce Interface" (Introducir interfaz) las clases
        // EnvioMaritimo y EnvioTerrestre tenían diferentes nombres de método
        // (calcularTarifa y calcularCosto), a pesar de que ambos realizaban el mismo
        // cálculo. Esto causaba inconsistencias y dificultaba la reutilización de estas
        // clases.
        // Se creó una interfaz común llamada ServicioEnvio con el método
        // calcularCostoEnvio. Luego, ambas clases (EnvioMaritimo y EnvioAereo)
        // se refactorizaron para implementar esta interfaz, lo que unificó la firma
        // del método y facilitó el uso polimórfico.
    }

}


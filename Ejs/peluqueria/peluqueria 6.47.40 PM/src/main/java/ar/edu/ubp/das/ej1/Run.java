package ar.edu.ubp.das.ej1;

public class Run {

    public static void main(String[] args) {
        Peluquero turnoPeluquero = new Peluquero(
            "Carolina",
            "3516778899",
            "2025-11-20",
            "15:00",
            45,
            "Marcelo",
            "Cortes",
            200000
        );

        System.out.print(turnoPeluquero);

        turnoPeluquero.confirmar();
        turnoPeluquero.registrarLlegada();
        turnoPeluquero.finalizar();
        turnoPeluquero.calcularPagoMensual(80000);
    }

}

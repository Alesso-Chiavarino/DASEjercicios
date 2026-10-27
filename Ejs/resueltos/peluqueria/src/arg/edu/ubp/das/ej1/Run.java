package arg.edu.ubp.das.ej1;

public class Run {

    public static void main(String[] args) {
        Turno turnoPeluquero = new Turno(
            "Carolina",
            "3516778899",
            "2025-11-20",
            "15:00",
            45
        );

        Peluquero peluquero = new Peluquero( "Marcelo",
                "Cortes",
                200000);


        System.out.print(
                turnoPeluquero.mostrarDatosTurno(peluquero)
        );

        turnoPeluquero.confirmar();
        turnoPeluquero.registrarLlegada();
        turnoPeluquero.finalizar();
        peluquero.calcularPagoMensual(80000);
    }

}

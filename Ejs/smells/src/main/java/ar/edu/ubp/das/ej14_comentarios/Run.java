package ar.edu.ubp.das.ej14_comentarios;

public class Run {

    public static void main(String[] args) {
        Estacionamiento estacionamiento = new Estacionamiento();

        System.out.println("Auto 8 min: $" + estacionamiento.calcularTarifa(8, false));
        System.out.println("Auto 15 min: $" + estacionamiento.calcularTarifa(15, false));
        System.out.println("Auto 50 min: $" + estacionamiento.calcularTarifa(50, false));
        System.out.println("Moto 50 min: $" + estacionamiento.calcularTarifa(50, true));
        System.out.println("Auto 12 hs: $" + estacionamiento.calcularTarifa(720, false));
    }

}

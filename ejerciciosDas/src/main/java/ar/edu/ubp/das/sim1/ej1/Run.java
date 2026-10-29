package ar.edu.ubp.das.sim1.ej1;

public class Run {

    public static void main(String[] args) {
        Agencia agencia = new Agencia("RentCar Córdoba");

        Cliente ana = new Cliente("Ana Gómez", "30111222",
                new Direccion("Av. Colón", 1250, new Localidad("Córdoba", "Córdoba")));
        Cliente bruno = new Cliente("Bruno Díaz", "28999888",
                new Direccion("San Martín", 450, new Localidad("Rosario", "Santa Fe")));
        Cliente carla = new Cliente("Carla Ruiz", "35444555",
                new Direccion("Belgrano", 87, new Localidad("Villa Carlos Paz", "Córdoba")));

        Auto gol = new Auto("AB123CD", "VW Gol", 35000);
        Auto corolla = new Auto("AC456EF", "Toyota Corolla", 60000);

        Alquiler a1 = new Alquiler();
        a1.setCliente(ana);
        a1.setAuto(gol);
        a1.setDias(3);
        a1.setKmRecorridos(450);
        a1.setConSeguro(true);
        agencia.registrarAlquiler(a1);

        Alquiler a2 = new Alquiler();
        a2.setCliente(bruno);
        a2.setAuto(corolla);
        a2.setDias(5);
        a2.setKmRecorridos(1400);
        a2.setConSeguro(false);
        agencia.registrarAlquiler(a2);

        Alquiler a3 = new Alquiler();
        a3.setCliente(carla);
        a3.setAuto(gol);
        a3.setDias(2);
        a3.setKmRecorridos(520);
        a3.setConSeguro(true);
        agencia.registrarAlquiler(a3);

        agencia.imprimirResumen();
    }

}

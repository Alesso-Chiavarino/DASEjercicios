package ar.edu.ubp.das.ej13_cadenademensajes;

public class Run {

    public static void main(String[] args) {
        Provincia cordoba = new Provincia("Córdoba", 1500);
        Provincia mendoza = new Provincia("Mendoza", 4200);

        Cliente ana = new Cliente("Ana", new Direccion("Obispo Trejo 323", new Ciudad("Córdoba", cordoba)));
        Cliente beto = new Cliente("Beto", new Direccion("San Martín 1100", new Ciudad("Godoy Cruz", mendoza)));

        Despachante despachante = new Despachante();
        despachante.despachar(new Pedido(ana, 18000));
        despachante.despachar(new Pedido(beto, 32500));
    }

}

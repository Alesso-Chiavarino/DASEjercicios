package ar.edu.ubp.das.ej01_codigoduplicado;

public class Run {

    public static void main(String[] args) {
        Gimnasio gimnasio = new Gimnasio();

        SocioComun ana = new SocioComun("Ana", 0);
        SocioPremium luis = new SocioPremium("Luis", 2);

        ana.imprimirCarnet();
        luis.imprimirCarnet();

        gimnasio.cobrarMensual(ana);
        gimnasio.cobrarMensual(luis);
        gimnasio.cobrarAnual(ana);
        gimnasio.cobrarAnual(luis);
    }

}

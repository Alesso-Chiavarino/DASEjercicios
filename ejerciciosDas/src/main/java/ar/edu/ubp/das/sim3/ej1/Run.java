package ar.edu.ubp.das.sim3.ej1;

public class Run {

    public static void main(String[] args) {
        Farmacia farmacia = new Farmacia("Farmacia del Centro");

        farmacia.agregarMedicamento(new Medicamento("Ibuprofeno 400", 3500, false, 20));
        farmacia.agregarMedicamento(new Medicamento("Amoxicilina 500", 6200, true, 6));
        farmacia.agregarMedicamento(new Medicamento("Losartán 50", 4800, true, 10));

        farmacia.vender("Ibuprofeno 400", 2, "PAMI", false);
        farmacia.vender("Amoxicilina 500", 2, "OSDE", true);
        farmacia.vender("Losartán 50", 1, "IOMA", false);
        farmacia.vender("Ibuprofeno 400", 1, "PARTICULAR", false);
        farmacia.vender("Amoxicilina 500", 9, "PAMI", true);

        farmacia.reponerStock("Amoxicilina 500", 10, true);

        farmacia.imprimirReporteDelDia();
        System.out.print(farmacia.exportarVentas());
    }

}

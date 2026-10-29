package ar.edu.ubp.das.sim3.ej1;

import java.util.ArrayList;
import java.util.List;

public class Farmacia {

    private String nombre;
    private String sucursalAnterior;
    private List<Medicamento> medicamentos;
    private List<Venta> ventas;
    private Exportador exportador;

    public Farmacia(String nombre) {
        this.nombre = nombre;
        this.medicamentos = new ArrayList<Medicamento>();
        this.ventas = new ArrayList<Venta>();
        this.exportador = new ExportadorCSV();
    }

    public void agregarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    public void reponerStock(String nombreMedicamento, int cantidad, boolean urgente) {
        Medicamento m = buscar(nombreMedicamento);
        if (m != null) {
            m.setStock(m.getStock() + cantidad);
            System.out.println("Stock repuesto: " + m.getNombre() + " -> " + m.getStock() + " unidades");
        }
    }

    private Medicamento buscar(String nombreMedicamento) {
        for (Medicamento m : medicamentos) {
            if (m.getNombre().equalsIgnoreCase(nombreMedicamento)) {
                return m;
            }
        }
        return null;
    }

    public void vender(String nombreMedicamento, int cantidad, String obraSocial, boolean presentaReceta) {
        Medicamento m = buscar(nombreMedicamento);
        if (m == null) {
            System.out.println("No se encontró el medicamento " + nombreMedicamento);
            return;
        }
        if (m.isRequiereReceta() && !presentaReceta) {
            System.out.println("Venta rechazada: " + m.getNombre() + " requiere receta");
            return;
        }
        if (m.getStock() < cantidad) {
            System.out.println("Venta rechazada: stock insuficiente de " + m.getNombre());
            return;
        }

        double subtotal = m.getPrecio() * cantidad;
        double descuento;
        switch (obraSocial) {
            case "PAMI":
                descuento = subtotal * 0.70;
                break;
            case "OSDE":
                descuento = subtotal * 0.40;
                break;
            case "IOMA":
                descuento = subtotal * 0.30;
                break;
            default:
                descuento = 0;
        }
        double importe = subtotal - descuento;

        int stockAnterior = m.getStock();
        m.setStock(m.getStock() - cantidad);

        Venta venta = new Venta(m.getNombre(), cantidad, obraSocial, descuento, importe);
        ventas.add(venta);
        imprimirTicket(venta, subtotal);

        if (m.getStock() < 5) {
            System.out.println("ALERTA: quedan " + m.getStock() + " unidades de " + m.getNombre());
        }
    }

    private void imprimirTicket(Venta venta, double subtotal) {
        System.out.println("------ " + nombre.toUpperCase() + " ------");
        System.out.println(venta.getMedicamento() + " x" + venta.getCantidad());
        System.out.println("Subtotal: $" + subtotal);
        if (venta.getDescuento() > 0) {
            System.out.println("Cobertura " + nombreObraSocial(venta.getObraSocial()) + ": -$" + venta.getDescuento());
        }
        System.out.println("TOTAL: $" + venta.getImporte());
        System.out.println("-------------------------");
    }

    private String nombreObraSocial(String codigo) {
        switch (codigo) {
            case "PAMI":
                return "PAMI (jubilados)";
            case "OSDE":
                return "OSDE";
            case "IOMA":
                return "IOMA (Prov. de Buenos Aires)";
            default:
                return "Particular";
        }
    }

    public void imprimirReporteDelDia() {
        double recaudado = 0;
        double cubiertoPorObrasSociales = 0;
        int unidades = 0;
        for (Venta v : ventas) {
            recaudado += v.getImporte();
            cubiertoPorObrasSociales += v.getDescuento();
            unidades += v.getCantidad();
        }
        System.out.println("===== REPORTE DEL DÍA - " + nombre + " =====");
        System.out.println("Ventas: " + ventas.size() + " (" + unidades + " unidades)");
        System.out.println("Recaudado: $" + recaudado);
        System.out.println("A reclamar a obras sociales: $" + cubiertoPorObrasSociales);
    }

    public String exportarVentas() {
        return exportador.exportar(ventas);
    }

    private double calcularDescuentoViejo(double subtotal, String obraSocial) {
        if (obraSocial.equals("PAMI")) {
            return subtotal * 0.50;
        }
        return 0;
    }

}

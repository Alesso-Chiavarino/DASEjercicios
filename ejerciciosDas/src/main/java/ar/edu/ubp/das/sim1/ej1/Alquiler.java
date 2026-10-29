package ar.edu.ubp.das.sim1.ej1;

public class Alquiler {

    private Cliente cliente;
    private Auto auto;
    private int dias;
    private int kmRecorridos;
    private boolean conSeguro;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getKmRecorridos() {
        return kmRecorridos;
    }

    public void setKmRecorridos(int kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }

    public boolean isConSeguro() {
        return conSeguro;
    }

    public void setConSeguro(boolean conSeguro) {
        this.conSeguro = conSeguro;
    }

}

package ar.edu.ubp.das.ejemplo05.original;

public class Run {

    public static void main(String[] args) {
        CuentaBancaria cuentaBancaria = new CuentaBancaria("ATAHUALPA MAS", 10000);
        cuentaBancaria.consultarSaldo();
    }

}

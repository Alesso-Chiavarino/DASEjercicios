package ar.edu.ubp.das.app;

public class Tablero {
    private char[][] tablero = new char[3][3];

    public Tablero() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    public char[][] getTablero() {
        return tablero;
    }

    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }

    public void mostrarTablero() {
        System.out.println("TABLERO");
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(this.tablero[i][j]);
            }
            System.out.println();
        }
    }

}
